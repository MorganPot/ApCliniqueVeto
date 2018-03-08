package fr.eni.clinique.ihm.model;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;

public class AnimalModel {
	
	private AnimalManagerImpl animalM = AnimalManagerImpl.getInstance();
	
	public AnimalModel() {
	}
	
	public void addAnimal(Animal newAnimal) throws ManagerException {
		animalM.addAnimal(newAnimal);
	}
	
	public void removeAnimal(int index) throws ManagerException {
		animalM.removeAnimal(index);
	}
	

	public void updateAnimal(Animal animal) throws ManagerException {
		animalM.updateAnimal(animal);
	}
	
	public List<Animal> selectAll(Client client) throws ManagerException {
		return animalM.getAnimalClient(client);
	}
	
}
