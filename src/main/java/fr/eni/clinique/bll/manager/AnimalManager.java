package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Animal;

public interface AnimalManager {



    List<Animal> getAnimal() throws ManagerException;
    
    Animal addAnimal(Animal newAnimal) throws ManagerException;
    
    void updateAnimal(Animal animal) throws ManagerException;
    
    void removeAnimal(Animal animal) throws ManagerException;
	
}
