package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.connexion;
import dao.IDao;
import entities.Fournisseur;
import entities.Produit;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ProduitService implements IDao<Produit> {
        private CategorieService cs;
        private RayonService rys;
        
       ProduitService(){
           cs=new CategorieService();
       }
	@Override
	public boolean create(Produit o) {
		try {
			String sql ="insert into produit values(null ,'" + o.getDesignation() + "' ,'" + o.getPrixAchat()+ "' ,'" + o.getCategorie()+"' ,'"+ o.getTva() + "' ,'"+ o.getRayon() + "' ) ";
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
	public boolean delete(Produit o) {
		// TODO Auto-generated method stub
		try {
			String sql ="delete from produit where id= "+o.getId();
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
	public boolean update(Produit o) {
         try {
			String req = "update produit set designation = ? , prixAchat = ?, categorie = ?, tva = ? where id = ?";
			PreparedStatement ps = connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getDesignation());
			ps.setDouble(2, o.getPrixAchat());
			ps.setInt(3, o.getCategorie().getId());
			ps.setDouble(5, o.getTva());
			ps.setInt(6, o.getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Produit findById(int id) {
			Produit produit= null;
        try {
            String sql = "select * from produit where id = " + id;
            Statement st = connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Produit(rs.getInt("id"), rs.getString("designation"), rs.getDouble("prixAchat"),cs.findById(rs.getInt("categorie")), rs.getDouble("tva"),rys.findById(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			String sql="select * from produit ";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"),rs.getDouble("prixAchat"),cs.findById(rs.getInt("categorie")), rs.getDouble("tva"),rys.findById(rs.getInt("id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

}
