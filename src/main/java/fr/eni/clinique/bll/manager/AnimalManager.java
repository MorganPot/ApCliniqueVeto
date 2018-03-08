package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;

public interface AnimalManager {



    List<Animal> getAnimal() throws ManagerException;
    
    List<Animal> getAnimalClient(Client client) throws ManagerException;
    
    Animal addAnimal(Animal newAnimal) throws ManagerException;
    
    void updateAnimal(Animal animal) throws ManagerException;
    
    void removeAnimal(Integer id) throws ManagerException;
	
}
