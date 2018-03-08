package fr.eni.clinique.dal.dao;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.exception.DaoException;

public interface ClientDao extends GenericDao<Client, Integer>{

	List<Client> selectByNom(String nom) throws DaoException;
	
	void updateArchive(String nom) throws DaoException;	
	
	void update(Client client) throws DaoException;	
}
