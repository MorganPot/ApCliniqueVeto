package fr.eni.clinique.dal.dao;

import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.dal.exception.DaoException;

public interface AnimalDao extends GenericDao<Animal, Integer>{
	
	List<Race> selectAllRace() throws DaoException;

	List<Animal> selectAllCli(Client client) throws DaoException;
}
