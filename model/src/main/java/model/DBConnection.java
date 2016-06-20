package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection INSTANCE = null;
	protected Connection connection;

	/**
	 * the constructor call open method
	 */
	public DBConnection() {
		this.open();
	}

	/**
	 * @return INSTANCE  the connection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}
	
	/** 
	 * @return true - open the connection
	 * 		   false - connection failed
	 */
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			//Call to jdbc 
			Class.forName("com.mysql.jdbc.Driver");
			//connect and record object 
			//recovery of url, login and password 
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(),
					dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	/**
	 * @return the attribute connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
