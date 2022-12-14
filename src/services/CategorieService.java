/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.connexion;
import dao.IDao;
import entities.Categorie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samih
 */
public class CategorieService implements IDao<Categorie>{

    @Override
    public boolean create(Categorie o) {
                 try {
			String sql ="insert into categorie values(null ,'" +o.getLibelle() + "') ";
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
    public boolean delete(Categorie o) {
       try {
			String sql ="delete from categorie where id= "+o.getId();
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
    public boolean update(Categorie o) {
       try {
			String sql ="update categorie set libelle='" + o.getLibelle()+ "' where id="+o.getId();
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
    public Categorie findById(int id) {
    Categorie categorie = null;
		try {
			String sql="select * from categorie where id=" + id ;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				return new Categorie(rs.getInt("id"),rs.getString("libelle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public List<Categorie> findAll() {
        List<Categorie> categories = new ArrayList<Categorie>();
		try {
			String sql="select * from categorie ";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				categories.add(new Categorie(rs.getInt("id"),rs.getString("libelle")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
    }
}
