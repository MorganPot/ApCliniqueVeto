package fr.eni.clinique.dal.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.dao.ConnexionDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class ConnexionDAOJdbcImpl implements ConnexionDao{
	
    private final static String SELECT_ALL_QUERY = "SELECT CodePers, Nom, MotPasse, Role,"
    												+ " Archive FROM Personnels";
    
    
    private static ConnexionDAOJdbcImpl SINGLETON = null;
    
    private ConnexionDAOJdbcImpl() {
        
    }
    
    public static ConnexionDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new ConnexionDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    public List<Personnel> selectAll() throws DaoException {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        List<Personnel> personnels = new ArrayList<>();
        
        try {
            // 1- Recuperation d'une connection à la BDD
            connection = MSSQLConnectionFactory.get();
            
            // 2- Creation d'un statement
            statement = connection.createStatement();
            
            // 3 - Executer la requete SQL
            resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            
            // 4 - Recupération du resultat
            while(resultSet.next()) {
            	personnels.add(createPersonnel(resultSet));
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete SELECT ALL Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        
        return personnels;
    }
    
    private Personnel createPersonnel(ResultSet resultSet) throws SQLException {
        
    	Personnel personnel = new Personnel();
        personnel.setCodePers(resultSet.getInt("CodePers"));
        personnel.setNom(resultSet.getString("Nom"));
        personnel.setMotPasse(resultSet.getString("MotPasse"));
        personnel.setRole(resultSet.getString("Role"));
        personnel.setArchive(resultSet.getBoolean("Archive"));
        
        return personnel;
    }

	@Override
	public Personnel insert(Personnel element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void update(Personnel element) throws DaoException {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personnel selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Integer id, String password) throws DaoException {
		// TODO Auto-generated method stub
		
	}
}
