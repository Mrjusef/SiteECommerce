package projet.site.eCommerce.Dao.donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projet.site.eCommerce.Dao.exception.DAOException;
import projet.site.eCommerce.beans.Categorie;
import projet.site.eCommerce.beans.Client;

public class DaoCategorie implements InterfaceCategorie{
	private DAOFactory df;
	Connection connexion = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
	public DaoCategorie(DAOFactory df){this.df=df;}
	
	public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
	private static Categorie map( ResultSet rs ) throws SQLException 
    { 
    Categorie c=new Categorie();
    c.setId(rs.getInt(1));
    c.setLibelle(rs.getString(2));
    c.setDescription(rs.getString(3));
    return c;
    	
    }

	@Override
	public Categorie find(String lib) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> listeCategorie=new ArrayList<Categorie>();
		Categorie c=new Categorie();
		String req="select `idCategorie`,`nomCategorie`, `descriptionCategorie` from categorie";
	try{
		connexion=df.getConnection();
		preparedStatement=initialisationRequetePreparee( connexion, req, false);
		resultSet =preparedStatement.executeQuery();
		while(resultSet.next())
		{
			c=map(resultSet);
			listeCategorie.add(c);
			
		}
		return listeCategorie;
	}catch ( SQLException e ) {
        throw new DAOException( e );
    } finally {
        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
    }
	}

	@Override
	public void add(Categorie c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String lib) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
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
	public int getId(String lib) {
		int c=0;
		String req="select `idCategorie` from categorie where `nomCategorie`=\""+ lib+"\"";
	try{
		connexion=df.getConnection();
		preparedStatement=initialisationRequetePreparee( connexion, req, false);
		resultSet =preparedStatement.executeQuery();
		
		while(resultSet.next()){c=resultSet.getInt(1);}
		return c;
		
	}catch ( SQLException e ) {
        throw new DAOException( e );
    } finally {
        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
    }
		
		
	}
	
	

}
