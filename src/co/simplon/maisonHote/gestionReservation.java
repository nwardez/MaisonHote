package co.simplon.maisonHote;

import java.util.ArrayList;


import java.util.List;




import co.simplon.maisonHote.Reservation;
import co.simplon.maisonHote.gestionReservation;

public class gestionReservation {
	
	private final static gestionReservation INSTANCE = new gestionReservation(); // SINGLETON
	private final List<Reservation> listeResa = new ArrayList<>();
	
	private gestionReservation(){  // Constructeur en Private car SINGLETON
	}
	
	public static gestionReservation getInstance() {
		return INSTANCE;
	}
	
	
	
	public void ajouterReservation(Reservation reservation) throws Exception{
		
		
		listeResa.add(reservation);
	}

	public List<Reservation> getList() {
		return listeResa;
	}

}
