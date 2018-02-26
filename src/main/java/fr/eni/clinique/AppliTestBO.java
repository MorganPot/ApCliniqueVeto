package fr.eni.clinique;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.bo.Race;

public class AppliTestBO {

	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new java.util.Date());
		Client cli1 = new Client(1, "NOEL","Pierre-Axel","1 Chateau Eraudière","La Vigne","44000","Nantes","0645743525","Axa","pierreaxel.noel@gmail.com","remarque", true);
		Agenda agenda1 = new Agenda(1, cal, 1);
		Animal animal1 = new Animal(1, "Diwan", "Male", "Marron", "Teckel", "Chiendelacasse", 1, "LeBGdu57", "VoldeVoiture",true);
		Personnel pers1 = new Personnel(1, "MorganLeBGDu44", "azertyui", "Sec", true);
		Race race1 = new Race("Teckel", "Teckel");
		System.out.println(cli1);
		System.out.println(agenda1);
		System.out.println(animal1);
		System.out.println(pers1);
		System.out.println(race1);

		
	}
}
