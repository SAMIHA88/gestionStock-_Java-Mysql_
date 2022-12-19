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

import connexion.connexion;
import entities.LigneCommande;

public class LigneCommandeService {

	CommandeService cs;
	ProduitService pp;
	
	
	
	public LigneCommandeService() {
		cs = new CommandeService();
		pp = new ProduitService();
	}

	
	public boolean create(LigneCommande o) {
		try {
			String req = "insert into lignecommande values (?, ? , ?, ?)";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCommande().getCode());
			ps.setInt(2, o.getProduit().getId());
			ps.setInt(3, o.getQuantite());
			ps.setDouble(4, o.getPrixVente());
                        
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean delete(LigneCommande o) {
		try {
			String req = "delete from lignecommande where commande  = ? and produit = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCommande().getCode());
                        ps.setInt(2, o.getProduit().getId());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean update(LigneCommande o, LigneCommande o1) {
		try {
			String req = "update lignecommande set commande = ? , produit = ?, quantite = ?, prixVente = ? where commande = ? and produit = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o1.getCommande().getCode());
			ps.setInt(2, o1.getProduit().getId());
			ps.setInt(3, o1.getQuantite());
                        ps.setDouble(4, o1.getPrixVente());
			ps.setInt(5, o.getCommande().getCode());
                        ps.setInt(6, o.getProduit().getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public LigneCommande findById(int commande, int produit) {
		try {
			String sql = "select * from lignecommande where commande = ? and produit = ?";
			PreparedStatement st = connexion.getConnection().prepareStatement(sql);
			st.setInt(1, commande);
                        st.setInt(2, produit);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new LigneCommande(cs.findById(rs.getInt("commande")),
						pp.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prixVente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LigneCommande> findAll() {
		List<LigneCommande> lignesCommandes = new ArrayList<LigneCommande>();
		try {
			String sql = "select * from lignecommande";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
				lignesCommandes.add(new LigneCommande(
						cs.findById(rs.getInt("commande")), pp.findById(rs.getInt("produit")),
						rs.getInt("quantite"), rs.getDouble("prixVente")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lignesCommandes;
	}

}

