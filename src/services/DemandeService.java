package services;

import connexion.connexion;
import entities.Demande;
import entities.Produit;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DemandeService {
        private FournisseurService fs;
        
       public DemandeService(){
           fs=new FournisseurService();
       }
	
	public boolean create(Demande o) {
		try {
			String sql ="insert into demande values(null ,'" + o.getDate()+ "' ,'" + o.getFournisseur().getId()+ "' ) ";
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

	
	public boolean delete(Demande o) {
		// TODO Auto-generated method stub
		try {
			String sql ="delete from demande where code= "+o.getCode();
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
	

	
	public boolean update(Demande o) {
         try {
			String req = "update demande set date = ? , fournisseur = ? where code = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new Date(o.getDate().getTime()));
			ps.setInt(2, o.getFournisseur().getId());
			ps.setInt(3, o.getCode());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public Demande findById(int id) {
			Demande demande= null;
        try {
            String sql = "select * from demande where code = " + id;
            Statement st = connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Demande(rs.getInt("code"), rs.getDate("date"),fs.findById(rs.getInt("fournisseur")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}


	public List<Demande> findAll() {
		List<Demande> demandes = new ArrayList<Demande>();
		try {
			String sql="select * from demande ";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				demandes.add(new Demande(rs.getInt("code"), rs.getDate("date"),fs.findById(rs.getInt("fournisseur"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return demandes;
	}
}
