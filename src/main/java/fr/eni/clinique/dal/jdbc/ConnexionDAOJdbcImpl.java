package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class ConnexionDAOJdbcImpl {
	
    private final static String SELECT_ALL_QUERY = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, "
    												+ " Adresse2, CodePostal, Ville, NumTel,"
    												+ " Assurance, Email, Remarque, Archive"
    												+ " FROM Clients";
    
    public ConnexionDAOJdbcImpl() {
        
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
            throw new DaoException("Erreur d'execution de la requete SELECT ALL Clients", e);
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
}
