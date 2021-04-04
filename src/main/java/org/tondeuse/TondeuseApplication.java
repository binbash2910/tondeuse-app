package org.tondeuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tondeuse.controle.Pilotage;

@SpringBootApplication
public class TondeuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TondeuseApplication.class, args);
		System.out.println("----------TONDEUSE APPLICATION------------") ;
		Pilotage pilote =  new Pilotage();
		pilote.run();
		System.out.println("----------FIN TONDEUSE APP------------") ;
	}

}


