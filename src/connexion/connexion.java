package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connexion {
	
	private static String login="root";
	private static String password="";
	private static String url="jdbc::mysql://localhost:3306/gestion_stock";
	private static Connection connection;
	
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,login,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de charger le Driver");
		} catch (SQLException e) {
			System.out.println("Impossible d'établir la connexion ");
			System.out.println("ERROR:"+e.getMessage());
		}	
	}
	public static Connection getConnection() {
		return connection;
	}
}
