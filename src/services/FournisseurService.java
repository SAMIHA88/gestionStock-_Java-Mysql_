package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.connexion;
import dao.IDao;
import entities.Fournisseur;

public class FournisseurService implements IDao<Fournisseur> {
	
		@Override
		public boolean create(Fournisseur o) {
			// TODO Auto-generated method stub
			try {
				String sql ="insert into fournisseur  values(null ,'" + o.getNom() + "' ,'" + o.getNom()+ "' ,'" + o.getTelephone()	+"' ,'"+ o.getEmail() + "' ) ";
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
		@Override
		public boolean update(Fournisseur o) {
			// TODO Auto-generated method stub
			try {
				String sql ="delete from fournisseur where id= "+o.getId();
				Statement st = connexion.getConnection().createStatement();
				if(st.executeUpdate(sql)==1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;	
		}
		
		@Override
		public Fournisseur findById(int id) {
			
			Fournisseur fournisseur  = null;
			try {
				String sql="select * from fournisseur  where id=" + id ;
				Statement st = connexion.getConnection().createStatement();
				ResultSet rs=st.executeQuery(sql);
				if(rs.next()) {
					return new Fournisseur (rs.getInt("id"),rs.getString("nom"),rs.getString("telephone"),rs.getString("email"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		@Override
		public List<Fournisseur> findAll() {
			// TODO Auto-generated method stub
			List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
			try {
				String sql="select * from fournisseur ";
				Statement st = connexion.getConnection().createStatement();
				ResultSet rs=st.executeQuery(sql);
				while(rs.next()) {
					fournisseurs.add(new Fournisseur(rs.getInt("id"),rs.getString("nom"),rs.getString("telephone"),rs.getString("email")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fournisseurs;
		
		}
		@Override
		public boolean delete(Fournisseur o) {
			try {
				String sql ="delete from fournisseur where id= "+o.getId();
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

	}



