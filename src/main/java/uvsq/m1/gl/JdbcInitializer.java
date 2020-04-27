package uvsq.m1.gl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcInitializer {
	
	private static final String userName = "maryeme";
	private static final String password = "root";
	
	public static String dburl = "jdbc:derby:bd;create=true";
	
	public JdbcInitializer() {
		Properties connectionProps = new Properties(); 
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}

	public void dropCreateTables() {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			
			Statement state = connect.createStatement();
			state.addBatch("DROP TABLE personnelGroupes");
			state.addBatch("DROP TABLE appartient");
			state.addBatch("DROP TABLE personnels");
			state.addBatch("CREATE TABLE personnelGroupes ("
					+ "id VARCHAR(100) PRIMARY KEY"
					+ ")");
			state.addBatch( 
					"CREATE TABLE appartient ("
					+ "id VARCHAR(100),"
					+ "nom VARCHAR(100)"
					+ ")"); 
			state.addBatch(
					"CREATE TABLE personnels ("
					+ "nom VARCHAR(100) PRIMARY KEY,"
					+ "prenom VARCHAR(100) NOT NULL,"
					+ "fonction VARCHAR(100) NOT NULL"
					
					+ ")");
			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void createTables() {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			Statement state = connect.createStatement();
			state.addBatch("CREATE TABLE personnelGroupes ("
					+ "id VARCHAR(100) PRIMARY KEY"
					+ ")");
			state.addBatch( 
					"CREATE TABLE appartient ("
					+ "id VARCHAR(100),"
					+ "nom VARCHAR(100)"
					+ ")"); 

			state.addBatch(
					"CREATE TABLE personnels ("
					+ "nom VARCHAR(100) PRIMARY KEY,"
					+ "prenom VARCHAR(100) NOT NULL,"
					+ "fonction VARCHAR(100) NOT NULL"
					+ ")");
			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
