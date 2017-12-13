package co.simplon.maisonHote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBase {
	
	private final static String BDPATH = "jdbc:mysql://localhost:3306/mydb";
	private final static String DBUSER = "admin";
	private final static String DBPASSWORD = "admin";
	private static Connection connection;
	
	public void connexion() throws Exception {
		// Load the database driver
				Class.forName("com.mysql.jdbc.Driver");
				
				// Create the jdbc connection
				connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
				System.out.println("Connection OK");
	}
	
	
	public void sauvegarderReservation(String nom, String prenom, String dateArrivee,String regionOrigine, String typeSejour, String telephone, String mail, int nombrePersonnes, int nuitee) throws SQLException
	{
		Statement statement = null;

		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO `tabResa` (`nom`, `prenom`, `dateArrivee`,`regionOrigine`,`typeSejour`,`telephone`,`mail`,`nombrePersonnes`,`nuitee`) VALUES ('" + nom + "', '" + prenom + "', '" + dateArrivee + "','" + regionOrigine + "','" + typeSejour + "','" + telephone + "','" + mail + "'," + nombrePersonnes + "," + nuitee + ")";
			statement.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.println("Erreur à l'insertion des données");
		}
		finally{	 
			statement.close();
		}
	
		System.out.println();
	}
	
	public static void voirLesReservations() throws SQLException
	{
		Statement statement = null;
		ResultSet rs = null;

		try {
			// Create the statement
			statement = connection.createStatement();
			String sql = "SELECT * FROM reservationTab";
			
			// Execute the query
			rs = statement.executeQuery(sql);
		
			// Loop on the results extracted from the database
			System.out.println("Liste des réservations");
			while (rs.next()) {
				System.out.println("  - " + rs.getString("idReservation") + " : " + rs.getString("prenom") + " " +  rs.getString("nom"));
			}
		}
		catch(SQLException e){
			System.out.println("Erreur à la lecture des données");
		}
		finally{	 
			statement.close();
		}
		
		System.out.println();
	}

}
