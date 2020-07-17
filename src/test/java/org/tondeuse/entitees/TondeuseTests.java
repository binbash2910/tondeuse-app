package org.tondeuse.entitees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TondeuseTests {
	
	Tondeuse tondeuse = null ;
	
	Pelouse pelouse = null ;
	
	List<String> commandes = null ;
	
	@BeforeEach
	public void initComponents() {
		
		pelouse = new Pelouse(5, 5) ;
		tondeuse = new Tondeuse(1, 2, Orientation.valueOf("N")) ;
		commandes = new ArrayList<>(Arrays.asList("GAGAGAGAA".split(""))) ;
	}
	
	
	@DisplayName("Test de la méthode setNextOrientation()")
	@Test
	public void testSetNextOrientation() {
		
		for(String commande : commandes) {
			tondeuse.setNextOrientation(tondeuse, Commande.valueOf(commande)) ;
		}
		
		assertEquals("N", tondeuse.getOrientation().name());
	}
	
	
	@DisplayName("Test de la méthode testDeplacement()")
	@Test
	public void testTestDeplacement() {
		
		assertThat(tondeuse.testDeplacement(pelouse, tondeuse, Commande.A)).isTrue() ;
		
		tondeuse = new Tondeuse(5, 5, Orientation.valueOf("N")) ;
		assertThat(tondeuse.testDeplacement(pelouse, tondeuse, Commande.A)).isFalse() ;
	}
	
	
	@DisplayName("Test de la méthode deplacement()")
	@Test
	public void testDeplacement() {
		
		tondeuse.deplacement(tondeuse)	 ;	
		assertEquals(3, tondeuse.getY());
		
		tondeuse.setOrientation(Orientation.valueOf("E"));
		tondeuse.deplacement(tondeuse)	 ;
		assertEquals(2, tondeuse.getX());

		tondeuse.setOrientation(Orientation.valueOf("S"));
		tondeuse.deplacement(tondeuse)	 ;
		assertEquals(2, tondeuse.getY());
		
		tondeuse.setOrientation(Orientation.valueOf("W"));
		tondeuse.deplacement(tondeuse)	 ;
		assertEquals(1, tondeuse.getX());
	}
	
	
	
}
