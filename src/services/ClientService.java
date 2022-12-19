package services;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.connexion;
import dao.IDao;
import entities.Client;

public class ClientService implements IDao<Client> {

	

	

	@Override
	public boolean create(Client o) {
		try {
			String sql ="insert into client values(null ,'" + o.getNom() + "'  ,'" + o.getTelephone()	+"' ,'"+ o.getEmail() + "' ) ";
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
	public boolean delete(Client o) {
		// TODO Auto-generated method stub
		try {
			String sql ="delete from client where id= "+o.getId();
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
	public boolean update(Client o) {

		try {
			String sql ="update client set nom='" + o.getNom() + "' ,telephone='" + o.getTelephone()+ "' ,email='" + o.getEmail() + "' where id="+o.getId();
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
	public Client findById(int id) {
		Client client = null;
		try {
			String sql="select * from client where id=" + id ;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				return new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("telephone"),rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		try {
			String sql="select * from client ";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				clients.add(new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("telephone"),rs.getString("email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}

}
