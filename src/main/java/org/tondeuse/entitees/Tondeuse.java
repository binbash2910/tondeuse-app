package org.tondeuse.entitees;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tondeuse {

	/*
	 * Abscisse
	 */
	private int x ;
	
	/*
	 * Ordonnée
	 */
	private int y ;
	
	/*
	 * Orientation
	 */
	private Orientation orientation ;
	
	
	/**
	 * 
	 * @param tondeuse, la tondeuse pour laquelle on assigne la nouvelle orientation (N,E,W,S)
	 * @param sens, le sens de l'orientation (D,G)
	 * @return tondeuse, la tondeuse avec sa nouvelle orientation
	 */
	public Tondeuse setNextOrientation(Tondeuse tondeuse, Commande commande) {
		
		if(commande.name().equals("D")) {
			
			switch(tondeuse.getOrientation().name()) {
			
			case ("N") :{
				tondeuse.setOrientation(Orientation.E);
				break ;
			}
			case ("E") :{
				tondeuse.setOrientation(Orientation.S);
				break ;
			}
			case ("S") :{
				tondeuse.setOrientation(Orientation.W);
				break ;
			}
			case ("W") :{
				tondeuse.setOrientation(Orientation.N);
				break ;
			}
			
			default : System.out.println("No Choice");
			
			}
		}
		
		if(commande.name().equals("G")) {
					
			switch(tondeuse.getOrientation().name()) {
			
			case ("N") :{
				tondeuse.setOrientation(Orientation.W);
				break ;
			}
			case ("W") :{
				tondeuse.setOrientation(Orientation.S);
				break ;
			}
			case ("S") :{
				tondeuse.setOrientation(Orientation.E);
				break ;
			}
			case ("E") :{
				tondeuse.setOrientation(Orientation.N);
				break ;
			}
			
			default : System.out.println("No Choice");
			
			}
		}
		
		return tondeuse ;
	}
	
	
	public boolean testDeplacement(Pelouse pelouse, Tondeuse tondeuse, Commande commande) {
		
		if(commande.name().equals("A")) {
			if(tondeuse.getOrientation().name().equals(Orientation.N.name())) {
				if(tondeuse.getY() + 1 <= pelouse.getJ())
					return true ;
			}
			if(tondeuse.getOrientation().name().equals(Orientation.S.name())) {
				if(tondeuse.getY() - 1 >= 0)
					return true ;
			}
			if(tondeuse.getOrientation().name().equals(Orientation.E.name())) {
				if(tondeuse.getX() + 1 <= pelouse.getI())
					return true ;
			}
			if(tondeuse.getOrientation().name().equals(Orientation.W.name())) {
				if(tondeuse.getX() - 1 >= 0)
					return true ;
			}
		}
		
		return false ;
	}
	
	
	public Tondeuse deplacement(Tondeuse tondeuse) {
			
				if(tondeuse.getOrientation().name().equals(Orientation.N.name())) 
					tondeuse.setY(tondeuse.getY() + 1);
				if(tondeuse.getOrientation().name().equals(Orientation.S.name()))
					tondeuse.setY(tondeuse.getY() - 1);
				if(tondeuse.getOrientation().name().equals(Orientation.E.name()))
					tondeuse.setX(tondeuse.getX() + 1);
				if(tondeuse.getOrientation().name().equals(Orientation.W.name()))
					tondeuse.setX(tondeuse.getX() - 1);
				
				return tondeuse;
			
		}
	
	
	@Override
    public String toString() {
        return this.x + " " + this.y + " " + this.orientation.name();
    }
}
