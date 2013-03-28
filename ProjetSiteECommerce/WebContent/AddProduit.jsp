<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.ArrayList" %>  
  <%@ page import="projet.site.eCommerce.beans.Categorie" %>

  <% 

//récupérer les articles dans la requête 
ArrayList<Categorie> listeCategorie=(ArrayList<Categorie>)request.getAttribute("listeCategorie"); 
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<title>Nouveau Produit</title>
</head>
<body>
<!-- Shell -->
<div class="shell">
    <c:import url="header.jsp"></c:import>
   
	<!-- End Header -->
	<!-- Main -->
<div id="main">
	<div id="content">
<fieldset>
<legend>Nouveau Produit</legend>
<form action="AjouterProduit" method="Post">
<table>

<tr>
<td>Libelle*</td><td><input type="text" name="libelle"></td>
</tr>

<tr>
<td>Description*</td><td><textarea rows="5" cols="20" name="description"></textarea></td>
</tr>


<tr>
<td>Prix*</td><td><input type="text" name="prix"></td>
</tr>

<tr>
<td>Date Production</td><td><input type="text" name="dp" value="<%= new Date()%>"></td>
</tr>

<tr>
<td>photo</td><td><input type="file" name="photo"></td>
</tr>

<tr>
<td> Categorie*</td><td>
<select name="categorie">
<%
	int i;
	for(i=0 ; i < listeCategorie.size() ; i++) 
	  { 
		Categorie c= (Categorie)listeCategorie.get(i);
		%>

<option><%=c.getLibelle() %>
<% }%>
</select>
</td>
</tr>

<tr>
<td><input type="submit"  value="Ajouter"></td>
<td><input type="reset"  value="Valider"></td>
</tr>
</table>
</form>
</fieldset>
</div>
<!-- Sidebar -->
		<div id="sidebar">
                
                    <c:import url="MenuAdmi.jsp"></c:import> 
                    <c:import url="ServletCategorieModel"></c:import>  
                    
        </div>                           
		</div>
		<!-- End Sidebar -->

<div class="cl">&nbsp;</div>
	</div>
	<!-- End Main -->
	
	<!-- Footer -->
	<c:import url="Footer.jsp"></c:import>
	
</body>
</html>