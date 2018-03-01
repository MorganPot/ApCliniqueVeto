package fr.eni.clinique.dal.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.dao.AnimalDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class AnimalDAOJdbcImpl implements AnimalDao{
	
    private final static String SELECT_ALL_QUERY = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, "
    												+ "Race, Espece, CodeClient, Tatouage, Antecedant, "
    												+ "Archive FROM Animaux;";
    private final static String SELECT_ONE_QUERY = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, "
													+ "Race, Espece, CodeClient, Tatouage, Antecedant, "
													+ "Archive FROM Animaux WHERE CodeAnimal = ?;";
    private final static String INSERT_QUERY = "INSERT INTO Animaux(CodeAnimal, NomAnimal, Sexe, "
													+ "Couleur, Race, Espece, CodeClient, Tatouage, "
													+ "Antecedant, Archive) "
													+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String UPDATE_QUERY = "UPDATE Animaux SET NomAnimal = ?, Sexe = ?, Couleur = ?, "
												+ "Race = ?, Espece = ?, CodeClient = ?, Tatouage = ?"
												+ ", Antecedant = ?, Archive = ? WHERE CodeAnimal = ?;";
    private static final String DELETE_QUERY = "DELETE FROM Animaux WHERE CodeAnimal = ?";
    
    
    private static AnimalDAOJdbcImpl SINGLETON = null;
    
    private AnimalDAOJdbcImpl() {
        
    }
    
    public static AnimalDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new AnimalDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    public List<Animal> selectAll() throws DaoException {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        List<Animal> animaux = new ArrayList<>();
        
        try {
            // 1- Recuperation d'une connection à la BDD
            connection = MSSQLConnectionFactory.get();
            
            // 2- Creation d'un statement
            statement = connection.createStatement();
            
            // 3 - Executer la requete SQL
            resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            
            // 4 - Recupération du resultat
            while(resultSet.next()) {
            	animaux.add(createAnimal(resultSet));
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete SELECT ALL Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        
        return animaux;
    }
    
    private Animal createAnimal(ResultSet resultSet) throws SQLException {
        
    	Animal animal = new Animal();
    	animal.setCodeAnimal(resultSet.getInt("CodeAnimal"));
    	animal.setNomAnimal(resultSet.getString("NomAnimal"));
    	animal.setSexe(resultSet.getString("Sexe"));
    	animal.setCouleur(resultSet.getString("Couleur"));
    	animal.setRace(resultSet.getString("Race"));
    	animal.setEspece(resultSet.getString("Espece"));
    	animal.setCodeClient(resultSet.getInt("CodeClient"));
    	animal.setTatouage(resultSet.getString("Tatouage"));
    	animal.setAntecedents(resultSet.getString("Antecedant"));
    	animal.setArchive(resultSet.getBoolean("Archive"));
        
        return animal;
    }

    @Override
    public Animal insert(Animal animal) throws DaoException {
        
        // Check not null 
        ObjectUtil.checkNotNull(animal);
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resulSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, animal.getNomAnimal());
            statement.setString(2, animal.getSexe());
            statement.setString(3, animal.getCouleur());
            statement.setString(4, animal.getRace());
            statement.setString(5, animal.getEspece());
            statement.setInt(6, animal.getCodeClient());
            statement.setString(7, animal.getTatouage());
            statement.setString(8, animal.getAntecedents());
            statement.setBoolean(9, animal.getArchive());
            
            if(statement.executeUpdate() == 1) {
                resulSet = statement.getGeneratedKeys();
                if(resulSet.next()) {
                	animal.setCodeAnimal(resulSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete INSERT Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resulSet);
        }
        
        return animal;
    }

	@Override
	public void update(Animal element) throws DaoException {
		// TODO Auto-generated method stub

        // Check not null 
        ObjectUtil.checkNotNull(element);
        ObjectUtil.checkNotNull(element.getCodeAnimal());
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(UPDATE_QUERY);
            
            statement.setString(1, element.getNomAnimal());
            statement.setString(2, element.getSexe());
            statement.setString(3, element.getCouleur());
            statement.setString(4, element.getRace());
            statement.setString(5, element.getEspece());
            statement.setInt(6, element.getCodeClient());
            statement.setString(7, element.getTatouage());
            statement.setString(8, element.getAntecedents());
            statement.setBoolean(9, element.getArchive());
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete UPDATE Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
	}

	@Override
	public void delete(Integer id) throws DaoException {
		 
		// Check not null 
        ObjectUtil.checkNotNull(id);
        
        Connection connection = null;
        CallableStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareCall(DELETE_QUERY);
            
            statement.setInt("CodeAnimal", id);
            statement.execute();
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete DELETE Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
	}
   @Override
    public Animal selectById(Integer id) throws DaoException {
        
        // Check not null 
        ObjectUtil.checkNotNull(id);
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Animal animal = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_QUERY);
            
            statement.setInt(1, id);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
            	animal = createAnimal(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete select 1 animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return animal;
    }
}