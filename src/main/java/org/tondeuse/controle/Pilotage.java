package org.tondeuse.controle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.tondeuse.entitees.Commande;
import org.tondeuse.entitees.Orientation;
import org.tondeuse.entitees.Pelouse;
import org.tondeuse.entitees.Tondeuse;

@Service
public class Pilotage {
	
	/* La pelouse à tondre*/
	Pelouse pelouse = null ;
	
	/* une tondeuse*/
	Tondeuse tondeuse = null ;
	
	/* Les commandes des différentes tondeuses*/
	Map<Tondeuse, List<String>> tondeuses = null ;
	
	/* Les commandes d'entrée*/
	List<String> lesCommandesEntrees = null ;
	
	/* Les commandes de la tondeuse*/
	List<String> lesCommandesDeLaTondeuses = null ;
	
	ResourceLoader resourceLoader = null ;
	
	Resource resourceFile = null ;
	
	
	public Pilotage() {
		
		// Lecture du fichier de commandes
		resourceLoader = new DefaultResourceLoader();
		resourceFile = resourceLoader.getResource("classpath:commandes.txt");
	}
	
	public void run() {
		
		try (InputStream inputStream = resourceFile.getInputStream()) {
			lesCommandesEntrees = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);

			// Construction de la pelouse
			String[] DonneesPelouse = lesCommandesEntrees.get(0).split(" ");
			pelouse = new Pelouse(Integer.parseInt(DonneesPelouse[0]), Integer.parseInt(DonneesPelouse[1])) ;
			//
			// Construction de la liste de tondeuses
			tondeuses = new HashMap<>() ;
			for(int i=1; i < lesCommandesEntrees.size() + 1 ; i = i + 2 ) {
				if(i == lesCommandesEntrees.size())
					break ;
				
				String[] DonneesTondeuse = lesCommandesEntrees.get(i).split(" ");
				tondeuse = new Tondeuse(Integer.parseInt(DonneesTondeuse[0]), Integer.parseInt(DonneesTondeuse[1]), Orientation.valueOf(DonneesTondeuse[2])) ;
				
				lesCommandesDeLaTondeuses = new ArrayList<>(Arrays.asList(lesCommandesEntrees.get(i+1).split(""))) ;
				tondeuses.put(tondeuse, lesCommandesDeLaTondeuses) ;
			}
		
			for(Tondeuse tondeuse : tondeuses.keySet()) { 
				for(String instruction : tondeuses.get(tondeuse)) {
					
					if("G".equals(instruction) || "D".equals(instruction)) {
						if("G".equals(instruction))
							tondeuse.setNextOrientation(tondeuse, Commande.G) ;
						else if("D".equals(instruction))
							tondeuse.setNextOrientation(tondeuse, Commande.D) ;
					}
					
					if("A".equals(instruction)) {
						if(tondeuse.testDeplacement(pelouse, tondeuse, Commande.A)) {
							tondeuse.deplacement(tondeuse) ;
						}
					}
				}
				
				System.out.println(tondeuse.toString()) ;
			}
		} 
		catch (IOException e) {
				e.printStackTrace();
			}
		
		
		
	
		
	}
}
