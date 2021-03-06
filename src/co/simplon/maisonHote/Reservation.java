package co.simplon.maisonHote;



public class Reservation {
	
	private String numeroResa;
	private String nom;
	private String prenom;
	private String dateArrivee;
	private Boolean parking;
	private Boolean fumeur;
	private Boolean animal;
	private int nombrePersonnes;
	private String regionOrigine;
	private String typeSejour;
	private String telephone;
	private String mail;
	private int nuitee;
	
	
	public int calculTarifSejour() {
		
		int nombreDeNuits=this.getNuits();
		int result;
		int animal = 0;
		int parking = 0;
		int personnes = this.getNombrePersonnes();
		int tarifNuitPersonnes = 150;
		
		if(this.getAnimal()) {
			animal=35;
		}
		if(this.getParking()) {
			parking=50;
		}
		
		result = nombreDeNuits*((personnes*tarifNuitPersonnes) + animal + parking);
		
		return result;
	}
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Boolean getParking() {
		return parking;
	}
	
	public String parking() {
		String result="";
		if(this.getParking()) {
			result="oui";
		} else {
			result="non";
		}
		return result;
	}
	
	public String animal() {
		String result="";
		if(this.getAnimal()) {
			result="oui";
		} else {
			result="non";
		}
		return result;
	}
	
	public String fumeur() {
		String result="";
		if(this.getFumeur()) {
			result="oui";
		} else {
			result="non";
		}
		return result;
	}
	
	public void setParking(Boolean parking) {
		this.parking = parking;
	}
	public Boolean getFumeur() {
		return fumeur;
	}
	public void setFumeur(Boolean fumeur) {
		this.fumeur = fumeur;
	}
	public int getNombrePersonnes() {
		return nombrePersonnes;
	}
	public void setNombrePersonnes(int nombrePersonnes) {
		this.nombrePersonnes = nombrePersonnes;
	}
	public String getRegionOrigine() {
		return regionOrigine;
	}
	public void setRegionOrigine(String regionOrigine) {
		this.regionOrigine = regionOrigine;
	}
	public String getTypeSejour() {
		return typeSejour;
	}
	public void setTypeSejour(String typeSejour) {
		this.typeSejour = typeSejour;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getNumeroResa() {
		numeroResa=this.getNom()+this.getPrenom()+this.getDateArrivee();
		return numeroResa;
	}
	public void setNumeroResa(String numeroResa) {
		this.numeroResa = numeroResa;
	}
	public Boolean getAnimal() {
		return animal;
	}
	public void setAnimal(Boolean animal) {
		this.animal = animal;
	}
	public String getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	

	public int getNuits() {
		return nuitee;
	}

	public void setNuits(int nuitee) {
		this.nuitee = nuitee;
	}
	
	
	
	
	
	

}
