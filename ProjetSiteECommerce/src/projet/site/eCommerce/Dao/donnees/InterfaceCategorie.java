package projet.site.eCommerce.Dao.donnees;

import java.util.ArrayList;
import projet.site.eCommerce.beans.Categorie;

public interface InterfaceCategorie {
	
	public abstract Categorie find(String lib);
	public abstract ArrayList<Categorie>getAll();
	public abstract void add (Categorie c);
	public abstract void delete(String lib);
	public abstract int getId(String lib);
	

}
