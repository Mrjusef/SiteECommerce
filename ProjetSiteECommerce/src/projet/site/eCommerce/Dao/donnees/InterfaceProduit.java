package projet.site.eCommerce.Dao.donnees;
import java.util.ArrayList;
import projet.site.eCommerce.beans.Produit;

public interface InterfaceProduit {
	
	public abstract void add(Produit p);
	public abstract ArrayList<Produit> getAll();
	public abstract void delete(int id);
	public abstract void modifier(Produit p);
	public abstract ArrayList<Produit> GetProduitCategorie(int categorie);
	public abstract ArrayList<Produit> GetActualite();
	public abstract Produit getProduit(int p);
	

}
