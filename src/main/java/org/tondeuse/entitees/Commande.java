package org.tondeuse.entitees;

public enum Commande {

	D("DROITE"), G("GAUCHE"), A("AVANCE") ;
	
	private String commande ;
	
	Commande(String commande) {
        this.commande = commande;
    }
	
	
	public String getCommande() {
		return commande;
	}
	public void setCommande(String commande) {
		this.commande = commande;
	}
}
