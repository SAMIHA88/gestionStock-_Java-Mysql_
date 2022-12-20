package services;

import connexion.connexion;
import entities.Client;
import entities.Commande;
import entities.Fournisseur;
import entities.Produit;
import entities.Demande;
import entities.Fournisseur;
import entities.Produit;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandeService {
        private ClientService cls;
        
       public CommandeService(){
           cls=new ClientService();
       }
	
	public boolean create(Commande o) {
		try {
			String sql ="insert into commande values(null ,'" + new Date(o.getDate().getTime())+ "' ,'" + o.getClient().getId()+ "' ) ";
			Statement st = connexion.getConnection().createStatement();
			if(st.executeUpdate(sql)==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean delete(Commande o) {
		// TODO Auto-generated method stub
		try {
			String sql ="delete from commande where code= "+o.getCode();
			Statement st = connexion.getConnection().createStatement();
			if(st.executeUpdate(sql)==1) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	
	public boolean update(Commande o) {
         try {
			String req = "update commande set date = ? , client = ? where code = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new Date(o.getDate().getTime()));
			ps.setInt(2, o.getClient().getId());
			ps.setInt(3, o.getCode());
			if (ps.executeUpdate() == 1)
				return true;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public Commande findById(int id) {
			Commande commande= null;
        try {
            String sql = "select * from commande where code = " + id;
            Statement st = connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Commande(rs.getInt("code"), rs.getDate("date"),cls.findById(rs.getInt("client")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}


	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			String sql="select * from commande ";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				commandes.add(new Commande(rs.getInt("code"), rs.getDate("date"),cls.findById(rs.getInt("client"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commandes;
	}
          public List<Commande> findByClient(Client c) {
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			String sql="select * from commande where client="+c.getId();
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				commandes.add(new Commande(rs.getInt("code"), rs.getDate("date"),cls.findById(rs.getInt("client"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commandes;
	}
}