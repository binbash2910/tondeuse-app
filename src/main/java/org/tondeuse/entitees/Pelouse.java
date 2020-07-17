package org.tondeuse.entitees;

import lombok.Data;

@Data
public class Pelouse {

	/*
	 * Tableau à 2 dimension representant la dimension de la pelouse
	 */
	int[][] dimension;
	
	/*
	 * la longueur et la largeur de la pelouse
	 */
	int i, j ;
	
	public Pelouse(int i, int j) {
		this.i = i ;
		this.j = j ;
		this.dimension = new int[i][j] ;
		
	}
}
