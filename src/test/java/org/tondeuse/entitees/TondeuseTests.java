package org.tondeuse.entitees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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

}
