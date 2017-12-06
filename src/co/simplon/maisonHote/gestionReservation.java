package co.simplon.maisonHote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import co.simplon.maisonHote.Reservation;
import co.simplon.maisonHote.gestionReservation;

public class gestionReservation {
	
	private final static gestionReservation INSTANCE = new gestionReservation(); // SINGLETON
	private final Map<String, Reservation> listeReservations = new HashMap<String, Reservation>();
	
	private gestionReservation(){  // Constructeur en Private car SINGLETON
	}
	
	public static gestionReservation getInstance() {
		return INSTANCE;
	}
	
	public Map<String, Reservation> getReservation(){
		return listeReservations;
	}
	
	public void ajouterReservation(Reservation reservation) throws Exception{
		if(listeReservations.containsKey(reservation.getNumeroResa()))
			throw new Exception("Cette réservation a déjà été enregistrée !");
		
		reservation.setDateEnregistrement(new Date());
		listeReservations.put(reservation.getNumeroResa(), reservation);
	}

}
