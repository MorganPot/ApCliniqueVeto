package fr.eni.clinique.dal.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.dao.ClientDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class ClientDAOJdbcImpl implements ClientDao{
	
    private final static String SELECT_ALL_QUERY = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, "
    												+ "Adresse2, CodePostal, Ville, NumTel, Assurance, "
    												+ "Email, Remarque, Archive FROM Clients;";
    private final static String SELECT_ONE_QUERY = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, "
													+ "Adresse2, CodePostal, Ville, NumTel, Assurance, "
													+ "Email, Remarque, Archive FROM Clients "
													+ "WHERE CodeClient = ?;";
    private final static String SELECT_ALL_QUERY_BY_NAME = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, "
													+ "Adresse2, CodePostal, Ville, NumTel, Assurance, "
													+ "Email, Remarque, Archive FROM Clients "
													+ "WHERE NomClient LIKE ? AND Archive = 0;";
    private final static String INSERT_QUERY = "INSERT INTO Clients(NomClient, PrenomClient, Adresse1, "
													+ "Adresse2, CodePostal, Ville, NumTel, Assurance, "
													+ "Email, Remarque, Archive) "
													+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String UPDATE_QUERY = "UPDATE Clients SET NomClient = ?, PrenomClient = ?, Adresse1 = ?, "
												+ "Adresse2 = ?, CodePostal = ?, Ville = ? "
												+ "WHERE CodeClient = ?;";
    private final static String UPDATE_QUERY_ARCHIVE = "UPDATE Clients SET Archive = ?"
    												+ " WHERE NomClient = ?;";
    private static final String DELETE_QUERY = "DELETE FROM Clients WHERE CodeClient = ?";
    
    
    private static ClientDAOJdbcImpl SINGLETON = null;
    
    private ClientDAOJdbcImpl() {
        
    }
    
    public static ClientDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new ClientDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    public List<Client> selectAll() throws DaoException {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        List<Client> clients = new ArrayList<>();
        
        try {
            // 1- Recuperation d'une connection à la BDD
            connection = MSSQLConnectionFactory.get();
            
            // 2- Creation d'un statement
            statement = connection.createStatement();
            
            // 3 - Executer la requete SQL
            resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            
            // 4 - Recupération du resultat
            while(resultSet.next()) {
            	clients.add(createClient(resultSet));
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete SELECT ALL Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        
        return clients;
    }
    
    private Client createClient(ResultSet resultSet) throws SQLException {
        
    	Client client = new Client();
    	client.setCodeClient(resultSet.getInt("CodeClient"));
    	client.setNomClient(resultSet.getString("NomClient"));
    	client.setPrenomClient(resultSet.getString("PrenomClient"));
    	client.setAdresse1(resultSet.getString("Adresse1"));
    	client.setAdresse2(resultSet.getString("Adresse2"));
    	client.setCodePostal(resultSet.getString("CodePostal"));
    	client.setVille(resultSet.getString("Ville"));
    	client.setNumTel(resultSet.getString("NumTel"));
    	client.setAssurance(resultSet.getString("Assurance"));
    	client.setEmail(resultSet.getString("Email"));
    	client.setRemarque(resultSet.getString("Remarque"));
    	client.setArchive(resultSet.getBoolean("Archive"));
        
        return client;
    }

    @Override
    public Client insert(Client client) throws DaoException {
        
        // Check not null 
        ObjectUtil.checkNotNull(client);
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resulSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, client.getNomClient());
            statement.setString(2, client.getPrenomClient());
            statement.setString(3, client.getAdresse1());
            statement.setString(4, client.getAdresse2());
            statement.setString(5, client.getCodePostal());
            statement.setString(6, client.getVille());
            statement.setString(7, client.getNumTel());
            statement.setString(8, client.getAssurance());
            statement.setString(9, client.getEmail());
            statement.setString(10, client.getRemarque());
            statement.setBoolean(11, client.getArchive());
            
            if(statement.executeUpdate() == 1) {
                resulSet = statement.getGeneratedKeys();
                if(resulSet.next()) {
                	client.setCodeClient(resulSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete INSERT Client", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resulSet);
        }
        
        return client;
    }
//
//	@Override
//	public void update(Client element) throws DaoException {
//		// TODO Auto-generated method stub
//
//        // Check not null 
//        ObjectUtil.checkNotNull(element);
//        ObjectUtil.checkNotNull(element.getCodeClient());
//        
//        Connection connection = null;
//        PreparedStatement statement = null;
//        
//        try {
//            connection = MSSQLConnectionFactory.get();
//            statement = connection.prepareStatement(UPDATE_QUERY);
//            
//            statement.setString(1, element.getNomClient());
//            statement.setString(2, element.getPrenomClient());
//            statement.setString(3, element.getAdresse1());
//            statement.setString(4, element.getAdresse2());
//            statement.setString(5, element.getCodePostal());
//            statement.setString(6, element.getVille());
//            statement.setString(7, element.getNumTel());
//            statement.setString(8, element.getAssurance());
//            statement.setString(9, element.getEmail());
//            statement.setString(10, element.getRemarque());
//            statement.setBoolean(11, element.getArchive());
//            statement.setInt(1, element.getCodeClient());
//            
//            statement.executeUpdate();
//            
//        } catch (SQLException e) {
//            throw new DaoException("Erreur d'execution de la requete UPDATE Client", e);
//        } finally {
//            ResourceUtil.safeClose(connection, statement);
//        }
//	}

	@Override
	public void delete(Integer id) throws DaoException {
		 
		// Check not null 
        ObjectUtil.checkNotNull(id);
        
        Connection connection = null;
        CallableStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareCall(DELETE_QUERY);
            
            statement.setInt("CodePers", id);
            statement.execute();
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete DELETE Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
	}
   @Override
    public Client selectById(Integer id) throws DaoException {
        
        // Check not null 
        ObjectUtil.checkNotNull(id);
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Client client = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_QUERY);
            
            statement.setInt(1, id);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
            	client = createClient(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DaoException("Erreur d'execution de la requete select 1 client", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return client;
    }

@Override
public void update(Client client) throws DaoException {
	
    ObjectUtil.checkNotNull(client);
    
    Connection connection = null;
    PreparedStatement statement = null;
    
    try {
        connection = MSSQLConnectionFactory.get();
        statement = connection.prepareStatement(UPDATE_QUERY);
        
        statement.setString(1, client.getNomClient());
        statement.setString(2, client.getPrenomClient());
        statement.setString(3, client.getAdresse1());
        statement.setString(4, client.getAdresse2());
        statement.setString(5, client.getCodePostal());
        statement.setString(6, client.getVille());
        statement.setInt(7, client.getCodeClient());
        
        statement.executeUpdate();
        
    } catch (SQLException e) {
        throw new DaoException("Erreur d'execution de la requete UPDATE Client", e);
    } finally {
        ResourceUtil.safeClose(connection, statement);
    }
	
}

@Override
public List<Client> selectByNom(String nom) throws DaoException {
    // Check not null 
    ObjectUtil.checkNotNull(nom);
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<Client> clients = new ArrayList<Client>();
    
    String param = '%' + nom + '%';
    try {
        connection = MSSQLConnectionFactory.get();
        statement = connection.prepareStatement(SELECT_ALL_QUERY_BY_NAME);
        
        statement.setString(1, param);
        
        resultSet = statement.executeQuery();
        
        while(resultSet.next()) {
        	clients.add(createClient(resultSet));
        }
        
    } catch (SQLException e) {
        throw new DaoException("Erreur d'execution de la requete select 1 client", e);
    } finally {
        ResourceUtil.safeClose(connection, statement, resultSet);
    }
    return clients;
}

@Override
public void updateArchive(String nom) throws DaoException {
	
    ObjectUtil.checkNotNull(nom);
    
    Connection connection = null;
    PreparedStatement statement = null;
    
    try {
        connection = MSSQLConnectionFactory.get();
        statement = connection.prepareStatement(UPDATE_QUERY_ARCHIVE);
        
        statement.setString(1, "1");
        statement.setString(2, nom);
        
        statement.executeUpdate();
        
    } catch (SQLException e) {
        throw new DaoException("Erreur d'execution de la requete UPDATE Client archive", e);
    } finally {
        ResourceUtil.safeClose(connection, statement);
    }
}

@Override
public void update(Integer id, String password) throws DaoException {
	// TODO Auto-generated method stub
	
}
}
