package projet.site.eCommerce.beans;

import java.io.Serializable;
import java.util.Date;

public class Produit implements Serializable{
private  String libelle,description,photo;
private  double prix;
private int categorie,idProduit,etat,cont;
private Date dProduit=null;

public Produit(){}

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

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}



public int getEtat() {
	return etat;
}

public void setEtat(int etat) {
	this.etat = etat;
}

public int getCont() {
	return cont;
}

public void setCont(int cont) {
	this.cont = cont;
}

public double getPrix() {
	return prix;
}

public void setPrix(double prix) {
	this.prix = prix;
}

public int getCategorie() {
	return categorie;
}

public void setCategorie(int categorie) {
	this.categorie = categorie;
}

public int getIdProduit() {
	return idProduit;
}

public void setIdProduit(int idProduit) {
	this.idProduit = idProduit;
}

public Date getdProduit() {
	return dProduit;
}

public void setdProduit(Date dProduit) {
	this.dProduit = dProduit;
}


}
