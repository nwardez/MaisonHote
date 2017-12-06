package co.simplon.maisonHote;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				request.setAttribute("reservation", gestionReservation.getInstance().getReservation().values());
				
				getServletContext().getRequestDispatcher("/confirmResa.jsp").forward(request, response); 
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des informations saisies par l'utilisateur
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
				
				
				
				// Vérification des informations saisies
				if((nom == null) || (nom.isEmpty()))
				{
					String message = "Le nom  n'est pas renseigné !";
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response); // REDISPATCH vers erreurJSP avec bon message
				}
				/*else if((prenom == null) || (prenom.isEmpty()))
				{
					String message = "Le prenom  n'est pas renseigné !";
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response);
				}*/
				
				else
				{
					boolean enregistrementOk = true;
					
					// Tout est en règle => Création du nouveau ticket
					Reservation maResa = new Reservation();
					maResa.setNom(nom);
					maResa.setPrenom(prenom);
					maResa.setTelephone(telephone);
					maResa.setMail(mail);
					maResa.setRegionOrigine(region);
					maResa.setNombrePersonnes(nombrePersonnes);
					maResa.setFumeur(fumeur);
					maResa.setParking(parking);
					maResa.setAnimal(animal);
					maResa.setDateArrivee(dateArrivee);
					
					
					
					// Ajout du ticket à la liste des tickets déjà entrés
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
						// L'ajout du ticket s'est bien passé => Affichage de la page de récapitulation
						request.setAttribute("reservation", maResa);
						getServletContext().getRequestDispatcher("/confirmResa.jsp").forward(request, response);
					}	
				}
	}

}
