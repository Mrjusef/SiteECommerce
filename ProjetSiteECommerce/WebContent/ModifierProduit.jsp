<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="projet.site.eCommerce.beans.Produit" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification</title>
</head>
<body>
<fieldset>
<legend>Modifier Produit</legend>
<% Produit p=(Produit) request.getAttribute("pr");  %>
<form action="ModifierProduit" method="Post">
<table>

<tr>
<td>Libelle*</td><td><input type="text" name="libelle" value="<%=p.getLibelle() %>"></td>
</tr>

<tr>
<td>Prix*</td><td><input type="text" name="prix" value="<%=p.getPrix() %>"></td>
</tr>

<tr>
<td>Description</td><td><textarea rows="5" cols="100" name="description" ><%=p.getDescription() %></textarea></td>
</tr>

<tr>
<td>photo</td><td><input type="file" name="photo" ></td>
</tr>

<tr>
<td> Categorie*</td><td><input type="text"  name="categorie" value="<%=p.getCategorie() %>"></td>
</tr>

<tr>
<td><input type="submit"  value="Ajouter"></td>
<td><input type="reset"  value="Valider"></td>
</tr>
</table>
</form>
</fieldset>
</body>
</html>