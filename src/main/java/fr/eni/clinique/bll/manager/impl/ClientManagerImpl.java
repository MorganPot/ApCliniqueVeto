package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bo.Client;

public class ClientManagerImpl implements ClientManager{

private static ClientManagerImpl SINGLETON;
    
    /**
     * Get Article DAO.
     */
    private ClientDao clientDao = DaoFactory.articleDao();
    
    /**
     * Private constructor to forbid external instanciation.
     */
    private ClientManagerImpl() {
        
    }
    
    /**
     * Returns a unique CatalogueManagerImpl instance.
     * @return
     */
    public static ClientManagerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new CatalogueClientManagerImplManagerImpl();
        }
        return SINGLETON;
    }
    
    
    /**
     * Returns Articles from DAo
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public List<Personnel> getCatalogue() throws ManagerException {
        
        List<Personnel> articles = null;
        
        try {
            articles = articleDAO.selectAll();
            
        } catch (DaoException e) {
            throw new ManagerException("Error getting Articles", e);
        }
        
        return articles;
    }
    
    /**
     * Use Method delete() of DAO
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public void removeArticle(Personnel article) throws ManagerException {
        
        ObjectUtil.checkNotNull(article);
        ObjectUtil.checkNotNull(article.getIdArticle());
        
        try {
            articleDAO.delete(article.getIdArticle());
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
    }
   
    /**
     * Validate an Article.
     * 
     * @param article
     * @throws ManagerException
     */
    private void validerArticle(Personnel article) throws ManagerException {
        
        try {
            ObjectUtil.checkNotNull(article);
            ObjectUtil.checkNotBlank(article.getReference());
            ObjectUtil.checkNotBlank(article.getMarque());
            ObjectUtil.checkNotBlank(article.getDesignation());
            ObjectUtil.checkNotNull(article.getPrixUnitaire());
            ObjectUtil.checkNotNull(article.getQteStock());
            
            if(article instanceof Ramette) {
                if(((Ramette) article).getGrammage() == 0) {
                    throw new IllegalArgumentException("Le grammage doit etre strictement positif");
                }
            } else if(article instanceof Stylo) {
                ObjectUtil.checkNotBlank(((Stylo)article).getCouleur());
            }
        } catch (IllegalArgumentException e) { // Business Erreur remontée à l'utilisateur
            throw new ManagerException("Un des champs requis n'est pas valorisé !", e); 
        } catch(Exception e) { // Erreur technique suite à un pb lié au code.
            throw new TechnicalException("Erreur Technique", e);
        }
    }

    /**
     * Use Method insert() of DAO
     * Throw a ManagerException if newArticle is not valid.
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public Personnel addArticle(Personnel newArticle) throws ManagerException {
        
        ObjectUtil.checkNotNull(newArticle);
        
        Personnel article = null;
        try {
            
            validerArticle(newArticle);
            
            article = articleDAO.insert(newArticle);
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
        return article;
    }

    /**
     * Use Method update() of DAO
     * Throw a ManagerException if newArticle is not valid.
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public void updateArticle(Personnel article) throws ManagerException {
        
        ObjectUtil.checkNotNull(article);
        try {

            validerArticle(article);
            
            articleDAO.update(article);
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
    }    
}
