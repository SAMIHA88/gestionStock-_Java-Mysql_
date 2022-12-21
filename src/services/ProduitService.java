package services;

import entities.Categorie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Produit;
import connexion.connexion;
import dao.IDao;
import entities.Rayon;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ProduitService implements IDao<Produit> {

	private RayonService rys;
        private CategorieService cs;

	public ProduitService() {
		rys = new RayonService();
	     cs=new CategorieService();
        }

	@Override
	public boolean create(Produit o) {
		try {
			String sql = "insert into produit values(null,'"+o.getDesignation()+"',"+ o.getPrixAchat() +","  + o.getCategorie().getId() +  ","+o.getTva()+","
					+ o.getRayon().getId() + "," + o.getQuantite() + ")";
                        
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

	@Override
	public boolean delete(Produit o) {
		try {
			String sql = "delete from produit where id=" + o.getId();
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

	@Override
	public boolean update(Produit o) {
		try {
                    

			/*String sql = "update produit set designation ='" + o.getDesignation() + "',categorie='" + o.getCategorie().getId() + "' ,prixAchat='" + o.getPrixAchat()+ "',tva='"+o.getTva()
					+ "',quantite='" + o.getQuantite() + "',rayon='" + o.getRayon().getId()+"'where id='"+o.getId();
			Statement st = connexion.getConnection().createStatement();
                    
			if (st.executeUpdate(sql) == 1) {
				return true;
			}*/
                      String sql = "update produit set designation = ? , categorie = ?, prixAchat = ?, tva=?,quantite=?,rayon=? where id = ?";
                    PreparedStatement st = connexion.getConnection().prepareStatement(sql);
            st.setString(1, o.getDesignation());
            st.setInt(2, o.getCategorie().getId());
            st.setDouble(3, o.getPrixAchat()); 
            st.setDouble(4, o.getTva());
            st.setInt(5,o.getQuantite());
            st.setInt(6, o.getRayon().getId());
            st.setInt(7, o.getId());
           if (st.executeUpdate() == 1) {
                return true;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Produit findById(int id) {
		try {
			String sql = "select * from produit where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
       
        public List<Produit> findByDesignation(String designation) {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit p where designation='"+designation+"'";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<Produit> findByPrix(double prix) {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit p where prixAchat<="+prix;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        public List<Produit> findByRayon(Rayon rayon) {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit p,rayon r where p.rayon=r.id and r.code='"+rayon.getCode()+"'";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

         public List<Produit> findByCategorie(Categorie c) {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			String sql="select * from produit where categorie= "+c.getId();
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon"))));
                        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
          public List<Produit> commandesBetweenDates(java.util.Date d1 ,java.util.Date d2) {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			String sql="'select id,designation,prixAchat,categorie,tva,rayon from produit,lignecommande,commande where produit.id=lignecommande.produit and lignecommande.commande=commande.code and date between '"+new Date(d1.getTime())+"'and'"+new Date(d2.getTime());
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
                public List<Produit> demandesBetweenDates(java.util.Date d1 ,java.util.Date d2) {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			String sql="select * from produit,lignedemande,demande where produit.id=lignedemande.produit and lignedemande.demande=demande.code and date between "+d1+"and"+d2;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), cs.findById(rs.getInt("categorie")), rs.getDouble("prixAchat"),rs.getDouble("tva"),
						rs.getInt("quantite"), rys.findById(rs.getInt("rayon"))));
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
     
        
}
