package projet.site.eCommerce.Dao.donnees;
import java.util.ArrayList;
import projet.site.eCommerce.Dao.exception.DAOException;
import projet.site.eCommerce.beans.Client;


public abstract class InterfaceClient {

	public abstract Client trouver(String username)throws DAOException;
	public abstract ArrayList<Client> getAll()throws DAOException;
	public abstract void delete(int iduser)throws DAOException;
	public abstract Client getUser(String login,String pwd)throws DAOException;
}