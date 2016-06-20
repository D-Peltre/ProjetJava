package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// cette variable nous servira a savoir si une instance existe ou non
	private static DBConnection INSTANCE = null;
	protected Connection connection;

	//Le contructeur appel la méthode open
	public DBConnection() {
		this.open();
	}

    // on regarde si l'instance est deja faite, si non, on appel le contructeuri 
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}
	
	//la méthode qui cree la connection, elle renvoit un boolean qui est true si la connection est faites 
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			//on fait appel au driver jdbc 
			Class.forName("com.mysql.jdbc.Driver");
			//on fait la connection et on enregiste l'objet de type connection dans celui de cette classe (composition)
			//l'url le login et le password sont recuperer par les methode de dbProperties
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(),
					dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	//le getter de l'attribut connection
	public Connection getConnection() {
		return this.connection;
	}
}
