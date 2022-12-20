/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author samih
 */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.LigneDemande;
import connexion.connexion;
import entities.Demande;
import entities.Produit;

public class LigneDemandeService {

	DemandeService ds;
	ProduitService pp;
	
	
	
	public LigneDemandeService() {
		ds = new DemandeService();
		pp = new ProduitService();
	}

	
	public boolean create(LigneDemande o) {
		try {
			String req = "insert into lignedemande values (?, ? , ?, ?)";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getDemande().getCode());
			ps.setInt(2, o.getProduit().getId());
			ps.setInt(3, o.getQuantite());
			ps.setDouble(4, o.getPrixAchat());
                        
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean delete(LigneDemande o) {
		try {
			String req = "delete from lignedemande where demande  = ? and produit = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getDemande().getCode());
                        ps.setInt(2, o.getProduit().getId());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean update(LigneDemande o) {
		try {
			String req = "update lignedemande set  quantite = ?, prixAchat = ? where demande = ? and produit = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getQuantite());
                        ps.setDouble(2, o.getPrixAchat());
			ps.setInt(3, o.getDemande().getCode());
                        ps.setInt(4, o.getProduit().getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public LigneDemande findById(Demande demande, Produit produit) {
		try {
			String sql = "select * from lignedemande where demande = ? and produit = ?";
			PreparedStatement st = connexion.getConnection().prepareStatement(sql);
			st.setInt(1, demande.getCode());
                        st.setInt(2, produit.getId());
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new LigneDemande(ds.findById(rs.getInt("demande")),
						pp.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prixAchat"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LigneDemande> findAll() {
		List<LigneDemande> lignesDemandes = new ArrayList<LigneDemande>();
		try {
			String sql = "select * from lignedemande";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
				lignesDemandes.add(new LigneDemande(
						ds.findById(rs.getInt("demande")), pp.findById(rs.getInt("produit")),
						rs.getInt("quantite"), rs.getDouble("prixAchat")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lignesDemandes;
	}

}

