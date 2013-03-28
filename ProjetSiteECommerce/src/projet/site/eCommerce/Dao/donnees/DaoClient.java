package projet.site.eCommerce.Dao.donnees;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import projet.site.eCommerce.Dao.exception.DAOException;
import projet.site.eCommerce.beans.Client;

public class DaoClient extends InterfaceClient{
	private DAOFactory df;
	Connection connexion = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	public DaoClient(DAOFactory df)
	{
		this.df=df;
	}

	public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
	
	private static Client map( ResultSet rs ) throws SQLException 
    { 
    Client c=new Client();
    c.setId(rs.getInt(1));
   	c.setLogin(rs.getString(2));
   	c.setNom(rs.getString(3));
   	c.setPrenom(rs.getString(4));
   	c.setDn(rs.getDate(5));
   	c.setAdre(rs.getString(6));
   	c.setVille(rs.getString(7));
   	c.setPays(rs.getString(8));
    
    return c;
    	
    }
	
	
	@Override
	public Client trouver(String username) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	/* Fermeture silencieuse du resultset */
	public static void fermetureSilencieuse( ResultSet resultSet ) {
	    if ( resultSet != null ) {
	        try {
	            resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
	        }
	    }
	}
	 
	/* Fermeture silencieuse du statement */
	public static void fermetureSilencieuse( Statement statement ) {
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
	        }
	    }
	}
	 
	/* Fermeture silencieuse de la connexion */
	public static void fermetureSilencieuse( Connection connexion ) {
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
	        }
	    }
	}
	 
	/* Fermetures silencieuses du statement et de la connexion */
	public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {
	    fermetureSilencieuse( statement );
	    fermetureSilencieuse( connexion );
	}
	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void fermeturesSilencieuses( ResultSet resultSet, PreparedStatement preparedStatement, Connection connexion ) {
	    fermetureSilencieuse( resultSet );
	    fermetureSilencieuse(  preparedStatement );
	    fermetureSilencieuse( connexion );
	}

	@Override
	public ArrayList<Client> getAll() throws DAOException {
		ArrayList<Client> l=new ArrayList<Client>();
		Client c=new Client();
		String   req="select `idUser`,`identifiant`, `nom`, `prenom`, `dn`, `adresse`, `ville`, `pays` from users where `role`= 'client'";
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = df.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, req, false);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	       while( resultSet.next() ) {
	            c = map( resultSet );
	            l.add(c);
	        }
	        return l;
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
		
	}

	@Override
	public void delete(int iduser) throws DAOException {
		String req="delete  from users where `idUser`=?";
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = df.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, req, false,iduser);
	       int res = preparedStatement.executeUpdate();
		} catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
	}

	@Override
	public Client getUser(String login, String pwdd) throws DAOException {
		// TODO Auto-generated method stub
		Client c=new Client();
		String   req="select `idUser`,`identifiant`, `nom`, `prenom`, `dn`, `adresse`, `ville`, `pays`,`role` from users where  `identifiant`= \""+login+"\" and `pwd`= \""+pwdd+"\"";
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = df.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, req, false);
	        resultSet = preparedStatement.executeQuery();
	        if(resultSet != null){
	        c.setId(resultSet.getInt(1));
	       	c.setLogin(resultSet.getString(2));
	       	c.setNom(resultSet.getString(3));
	       	c.setPrenom(resultSet.getString(4));
	       	c.setDn(resultSet.getDate(5));
	       	c.setAdre(resultSet.getString(6));
	       	c.setVille(resultSet.getString(7));
	       	c.setPays(resultSet.getString(8));
	       	c.setPays(resultSet.getString(9));
	        }
	        else {
	        	System.out.println("aucun user");
	        }
	        
	        return c;
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
	}

}
