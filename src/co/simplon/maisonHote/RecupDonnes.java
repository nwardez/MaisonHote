package co.simplon.maisonHote;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import co.simplon.maisonHote.Reservation;

import co.simplon.maisonHote.gestionReservation;


/**
 * Servlet implementation class RecupDonnes
 */
@WebServlet("/RecupDonnes")
public class RecupDonnes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupDonnes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des tickets actifs
				request.setAttribute("reservation", gestionReservation.getInstance().getList());
				
				getServletContext().getRequestDispatcher("/listeReservation.jsp").forward(request, response); 
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des informations saisies par l'utilisateur
				String numeroResa="1";
				String nom = request.getParameter("name");
				String prenom = request.getParameter("subname");
				String telephone = request.getParameter("telephone");
				String mail = request.getParameter("contact_mail");
				int nombrePersonnes = Integer.parseInt(request.getParameter("personnes"));
				String region = request.getParameter("region");
				Boolean fumeur = request.getParameter("fumeur") != null;
				Boolean animal = request.getParameter("animal") != null;
				Boolean parking = request.getParameter("parking") != null;
				String dateArrivee = request.getParameter("arrive");
				int nombreDeNuits = Integer.parseInt(request.getParameter("nombreDeNuits"));
				String typeSejour=request.getParameter("group1");
				
				// Vérification des informations saisies
				if((nom == null) || (nom.isEmpty()))
				{
					String message = "Le nom  n'est pas renseigné !";
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response); // REDISPATCH vers erreurJSP avec bon message
				}
				else if((prenom == null) || (prenom.isEmpty()))
				{
					String message = "Le prenom  n'est pas renseigné !";
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response);
				}
				
				else
				{
					boolean enregistrementOk = true;
					
					// Tout est en règle => Création NOUVELLE réservation
					Reservation maResa = new Reservation();
					maResa.setNumeroResa(numeroResa);
					maResa.setNom(nom);
					maResa.setPrenom(prenom);
					maResa.setTelephone(telephone);
					maResa.setMail(mail);
					maResa.setRegionOrigine(region);
					maResa.setNombrePersonnes(nombrePersonnes);
					maResa.setFumeur(fumeur);
					maResa.setParking(parking);
					maResa.setAnimal(animal);
					maResa.setTypeSejour(typeSejour);
					maResa.setDateArrivee(dateArrivee);
					maResa.setNuits(nombreDeNuits);
					maResa.setTypeSejour(typeSejour);
					
					
					
					
					
					// Ajout de la réservation à la liste
					try {
						gestionReservation.getInstance().ajouterReservation(maResa); // Fonction SINGLETON -initialiser 1 seule fois
					}
					catch (Exception e) {
						// Gestion des exceptions
						enregistrementOk = false;
						request.setAttribute("message", e.getMessage());
						getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response);
					}
					
					if(enregistrementOk)
					{
						// Si ok, création d'une instance de ConnexionBase
						ConnexionBase monConnect = new ConnexionBase();
						try {
							// Appel de la méthode connexion
							monConnect.connexion();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							// Appel de la méthode d'inscrption dans la base SQL
							monConnect.sauvegarderReservation(nom, prenom,dateArrivee,region,typeSejour,telephone,mail,nombrePersonnes,nombreDeNuits,fumeur,animal,parking);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						/*try {
							monConnect.voirLesReservations();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						// L'ajout de la réservation s'est bien passée => Affichage de la page de récapitulation
						request.setAttribute("reservation", maResa);
						//getServletContext().getRequestDispatcher("/confirmResa.jsp").forward(request, response);
						request.setAttribute("reservation", gestionReservation.getInstance().getList());
						try {
							request.setAttribute("reservation", monConnect.voirLesReservations());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						getServletContext().getRequestDispatcher("/listeReservation.jsp").forward(request, response);
						
						
					}	
					
				}
	}

}
