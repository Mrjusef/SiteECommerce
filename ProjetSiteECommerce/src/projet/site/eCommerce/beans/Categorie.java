package projet.site.eCommerce.beans;
import java.io.Serializable;
public class Categorie implements Serializable{
	private int id;
	private String libelle,description;
	public Categorie() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
