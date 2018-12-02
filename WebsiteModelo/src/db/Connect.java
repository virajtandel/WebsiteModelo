package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static String status = "Desconectado";

	public Connect() {

	}

	public static java.sql.Connection getConexao() {

		Connection connection = null;

		try {
			String driverName = "com.mysql.jdbc.Driver";                        

			Class.forName(driverName);

			String serverName = "localhost";
            String mydatabase ="site";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase+"?serverTimezone=UTC";
            String username = "lab";
            String password = "lab";
            
			connection = DriverManager.getConnection(url, username, password);
			
			if (connection != null) {

				status = "Conectado";
			} else {

				status = "Falha";
			}
			
			return connection;
		} catch (ClassNotFoundException e) {
			
			System.out.println("Erro JDBC.");

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro BD");
			return null;
		}
	}

	public static String statusConection() {

		return status;
	}

	public static boolean FecharConexao() {
		try {

			Connect.getConexao().close();

			return true;
		} catch (SQLException e) {

			return false;
		}
	}
	
}
