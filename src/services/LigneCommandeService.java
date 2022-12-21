/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.connexion;
import dao.IDao;
import entities.Commande;
import entities.LigneCommande;
import entities.LigneDemande;
import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samih
 */
public class LigneCommandeService  {
        private CommandeService cs;
        private ProduitService ps;

    public LigneCommandeService(CommandeService cs, ProduitService ps) {
        this.cs = cs;
        this.ps = ps;
    }
        
       
    public boolean create(LigneCommande o) {
       try {
			String sql = "insert into lignecommande values(null," + o.getQuantite() + "," + o.getPrixVente() + ","
					+ o.getCommande().getCode() + "," + o.getProduit().getId() + ")";
			Produit p=ps.findById(o.getProduit().getId());
			if(p!=null)
			{
			p.quantite=p.quantite-o.getQuantite();
			String sql2="update produit set quantite="+p.quantite +" where id="+o.getProduit().getId();
			Statement st2=connexion.getConnection().createStatement();
			st2.executeUpdate(sql2);
			}
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

         }

    public boolean delete(LigneCommande o) {
        
        try {
			String req = "delete from lignedemande where commande  = ? and produit = ?";
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
    public boolean update(LigneCommande o) {
        try {
			String req = "update lignecommande set  quantite = ?, prixVente = ? where demande = ? and produit = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getQuantite());
                        ps.setDouble(2, o.getPrixVente());
			ps.setInt(3, o.getCommande().getCode());
                        ps.setInt(4, o.getProduit().getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
        }

 
  
    public LigneCommande findById(Commande commande,Produit produit) {
        LigneCommande lc;
        String sql = "select * from lignecommande where commande = "+commande.getCode()+"and produit="+produit.getId() ;
            Statement st;
            try {
                st = connexion.getConnection().createStatement();ResultSet rs = st.executeQuery(sql);
            if (rs.next())
				return new LigneCommande(cs.findById(rs.getInt("commande")), ps.findById(rs.getInt("produit")),rs.getInt("quantite"), rs.getDouble("prixAchat"));
            
            } catch (SQLException ex) {
                Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
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
						cs.findById(rs.getInt("commande")), ps.findById(rs.getInt("produit")),
						rs.getInt("quantite"), rs.getDouble("prixVente")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lignesCommandes;
}

   
}


   

