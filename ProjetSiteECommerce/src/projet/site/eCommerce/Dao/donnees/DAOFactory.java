package projet.site.eCommerce.Dao.donnees;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import projet.site.eCommerce.Dao.exception.DAOConfigurationException;

public class DAOFactory {
     private String              driver;
     private String              url;
     private String              username;
     private String              password;
  
     DAOFactory( String url, String username, String password ) {
         this.url = url;
         this.username = username;
         this.password = password;
     }
  
     /*
      * Méthode chargée de récupérer les informations de connexion à la base de
      * données, charger le driver JDBC et retourner une instance de la Factory
      */
     public static DAOFactory getInstance() throws DAOConfigurationException {
         Properties properties = new Properties();
         String url;
         String driver;
         String nomUtilisateur;
         String motDePasse;
 
            
             url ="jdbc:mysql://localhost/ecommerce" ;
             driver ="com.mysql.jdbc.Driver" ;
             nomUtilisateur ="root" ;
             motDePasse = "";
         
  
         try {
             Class.forName( driver );
         } catch ( ClassNotFoundException e ) {
             throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
         }
  
         DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
         return instance;
     }
  
     /* Méthode chargée de fournir une connexion à la base de données */
      /* package */ Connection getConnection() throws SQLException {
         return DriverManager.getConnection( url, username, password );
     }
  
     /*
      * Méthodes de récupération de l'implémentation des différents DAO (un seul
      * pour le moment)
      */
    public DaoClient getClientDao() {
        return new DaoClient( this );
    }
    public DaoCategorie getCategorieDao() {
        return new DaoCategorie( this );
    }
    public DaoProduit getProduitDao() {
        return new DaoProduit( this );
    }
}