package services;

import connexion.connexion;
import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import entities.Produit;
import entities.Rayon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RayonService implements IDao<Rayon>{
	 private ProduitService ps;
        
       RayonService(){
           ps=new ProduitService();
       }
	@Override
	public boolean create(Rayon o) {
		try {
			String sql ="insert into rayon values(null ,'" + o.getCode()+ "' ,'" + o.getProduits()+  "' ) ";
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
	public boolean delete(Rayon o) {
		// TODO Auto-generated method stub
		try {
			String sql ="delete from rayon where id= "+o.getId();
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
	public boolean update(Rayon o) {
         try {
			String req = "update produit set code = ? , produits = ? where id = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getCode());
			//ps.setInt(2, o.getProduits().get());
			ps.setInt(3, o.getId());
			
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Rayon findById(int id) {
			Rayon rayon= null;
        try {
            String sql = "select * from rayon where id = " + id;
            Statement st = connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //if (rs.next()) {
            //    return new Rayon(rs.getInt("id"), rs.getString("code"),ps.findById(rs.getInt("produits")));
            //}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Rayon> findAll() {
		List<Rayon> rayons = new ArrayList<Rayon>();
		try {
			String sql="select * from rayon ";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				//rayons.add(new new Rayon(rs.getInt("id"), rs.getString("code"),ps.findById(rs.getInt("produits"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rayons;
	}

}
