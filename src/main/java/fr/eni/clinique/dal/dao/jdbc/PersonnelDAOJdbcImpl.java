package fr.eni.clinique.dal.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.dao.PersonnelDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;
import fr.eni.clinique.common.util.ObjectUtil;

public class PersonnelDAOJdbcImpl implements PersonnelDao{
	
    private final static String SELECT_ALL_QUERY = "SELECT CodePers, Nom, MotPasse, Role,"
    												+ " Archive FROM Personnels";
    private final static String SELECT_ONE_QUERY = "SELECT CodePers, Nom, MotPasse, Role,"
													+ " Archive FROM Personnels WHERE CodePers = ?";
    private final static String INSERT_QUERY = "INSERT INTO Personnels(Nom, MotPasse, Role, Archive) "
    											+ "VALUES (?, ?, ?, ?);";
    private final static String UPDATE_QUERY = "UPDATE Personnels SET Nom = ?, MotPasse = ?, Role = ?, "
    											+ "Archive = ? WHERE CodePers = ?;";
    private static final String DELETE_QUERY = "DELETE FROM Personnels WHERE CodePers=?";
    
    
    private static PersonnelDAOJdbcImpl SINGLETON = null;
    
    private PersonnelDAOJdbcImpl() {
        
    }
    
    public static PersonnelDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new PersonnelDAOJdbcImpl();
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
            throw new DaoException("Erreur d'execution de la requete SELECT ALL Personnels", e);
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
    public Personnel insert(Personnel personnel) throws DaoException {
        
        // Check not null 
        ObjectUtil.checkNotNull(personnel);
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resulSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, personnel.getNom());
            statement.setString(2, personnel.getMotPasse());
            statement.setString(3, personnel.getRole());
            statement.setBoolean(4, personnel.getArchive());
            
            if(statement.executeUpdate() == 1) {
                resulSet = statement.getGeneratedKeys();
                if(resulSet.next()) {
                	personnel.setCodePers(resulSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete INSERT Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resulSet);
        }
        
        return personnel;
    }

	@Override
	public void update(Personnel element) throws DaoException {
		// TODO Auto-generated method stub

        // Check not null 
        ObjectUtil.checkNotNull(element);
        ObjectUtil.checkNotNull(element.getCodePers());
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(UPDATE_QUERY);
            
            statement.setString(1, element.getNom()); // Paramètre non nommés, cad avec des indexes
            statement.setString(2, element.getMotPasse());
            statement.setString(3, element.getRole());
            statement.setBoolean(4, element.getArchive());
            statement.setInt(5, element.getCodePers());
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete UPDATE Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
	}

	@Override
	public void delete(Integer id) throws DaoException {
		 
		// Check not null 
        ObjectUtil.checkNotNull(id);
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(DELETE_QUERY);
            
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete DELETE Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
	}
   @Override
    public Personnel selectById(Integer id) throws DaoException {
        
        // Check not null 
        ObjectUtil.checkNotNull(id);
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Personnel personnel = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_QUERY);
            
            statement.setInt(1, id);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                personnel = createPersonnel(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete select 1 membre du personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return personnel;
    }
}
