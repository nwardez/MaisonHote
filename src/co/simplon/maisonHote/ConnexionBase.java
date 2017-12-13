package co.simplon.maisonHote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBase {
	
	// Déclaration des constantes pour connection à la base
	private final static String BDPATH = "jdbc:mysql://localhost:3306/mydb";
	private final static String DBUSER = "admin";
	private final static String DBPASSWORD = "admin";
	private static Connection connection;
	
	// Méthode d'initialisation de la connection qui sera appelé dans la servlet après la création de l'objet ConnexionBase
	public void connexion() throws Exception {
		// Load the database driver
				Class.forName("com.mysql.jdbc.Driver"); // Indispensable
				
				// Création de la connection
				connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD); 
				System.out.println("Connection OK");
	}
	
	/**
	 * METHODE POUR AJOUTER DES RESERVATIONS DANS LA TABLE
	 * @param nom
	 * @param prenom
	 * @param dateArrivee
	 * @param regionOrigine
	 * @param typeSejour
	 * @param telephone
	 * @param mail
	 * @param nombrePersonnes
	 * @param nuitee
	 * @param fumeur
	 * @param animal
	 * @param parking
	 * @throws SQLException
	 */
	public void sauvegarderReservation(String nom, String prenom, String dateArrivee,String regionOrigine, String typeSejour, String telephone, String mail, int nombrePersonnes, int nuitee, boolean fumeur, boolean animal, boolean parking) throws SQLException
	{
		// Déclaration de l'Interface permettant l'execution de requêtes
		Statement statement = null;

		try {
			statement = connection.createStatement();
			// Initialisation de la chaine de caractère de la requête
			String sql = "INSERT INTO `tabResa` (`nom`, `prenom`, `dateArrivee`,`regionOrigine`,`typeSejour`,`telephone`,`mail`,`nombrePersonnes`,`nuitee`,`fumeur`,`animal`,`parking`) VALUES ('" + nom + "', '" + prenom + "', '" + dateArrivee + "','" + regionOrigine + "','" + typeSejour + "','" + telephone + "','" + mail + "'," + nombrePersonnes + "," + nuitee + "," + fumeur + ", " + animal + ", " + parking + ")";
			statement.executeUpdate(sql); // Execution de la requête
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
