package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.dao.AnimalDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;

public class AnimalManagerImpl implements AnimalManager{

private static AnimalManagerImpl SINGLETON;
    
    private AnimalDao animalDao = DaoFactory.animalDao();
    
    /**
     * Private constructor to forbid external instanciation.
     */
    private AnimalManagerImpl() {
        
    }
    
    public static AnimalManagerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new AnimalManagerImpl();
        }
        return SINGLETON;
    }
    
    @Override
    public List<Animal> getAnimal() throws ManagerException {
        
        List<Animal> animaux = null;
        
        try {
        	animaux = animalDao.selectAll();
            
        } catch (DaoException e) {
            throw new ManagerException("Error getting Animaux", e);
        }
        
        return animaux;
    }
    
    /**
     * Use Method delete() of DAO
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public void removeAnimal(Integer id) throws ManagerException {
        
        ObjectUtil.checkNotNull(id);
        
        try {
            animalDao.delete(id);
            
        } catch (DaoException e) {
            throw new ManagerException("Error deleting", e);
        }
    }
   
    private void validerAnimal(Animal animal) throws ManagerException {
        
        try {
            ObjectUtil.checkNotNull(animal);
            ObjectUtil.checkNotBlank(animal.getNomAnimal());
            ObjectUtil.checkNotBlank(animal.getSexe());
            ObjectUtil.checkNotBlank(animal.getCouleur());
            ObjectUtil.checkNotNull(animal.getRace());
            ObjectUtil.checkNotNull(animal.getEspece());
            ObjectUtil.checkNotNull(animal.getCodeClient());
            ObjectUtil.checkNotNull(animal.getTatouage());
            ObjectUtil.checkNotNull(animal.getAntecedents());
            ObjectUtil.checkNotNull(animal.getArchive());
            
        } catch (IllegalArgumentException e) { // Business Erreur remontée à l'utilisateur
            throw new ManagerException("Un des champs requis n'est pas valorisé !", e); 
        } catch(Exception e) { // Erreur technique suite à un pb lié au code.
            throw new TechnicalException("Erreur Technique", e);
        }
    }

    @Override
    public Animal addAnimal(Animal newAnimal) throws ManagerException {
        
        ObjectUtil.checkNotNull(newAnimal);
        
        Animal animal = null;
        try {
            
            validerAnimal(newAnimal);
            
            animal = animalDao.insert(newAnimal);
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
        return animal;
    }

	@Override
	public void updateAnimal(Animal animal) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Animal> getAnimalClient(Client client) throws ManagerException {
        List<Animal> animaux = null;
        
        try {
        	animaux = animalDao.selectAll(client);
            
        } catch (DaoException e) {
            throw new ManagerException("Error getting Animaux", e);
        }
        
        return animaux;
	}

	@Override
	public List<Race> getRace() throws ManagerException {
		List<Race> races = null;
        
        try {
        	races = animalDao.selectAllRace();
            
        } catch (DaoException e) {
            throw new ManagerException("Error getting races", e);
        }
        
        return races;
	}
 
}