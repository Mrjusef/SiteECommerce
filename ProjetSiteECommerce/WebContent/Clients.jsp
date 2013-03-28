<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page import="projet.site.eCommerce.beans.Client" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT LANGUAGE="Javascript" SRC="Js/javascript.js"> </SCRIPT>
<link rel="stylesheet" type="text/css" href="css/stylee.css"  title="defaut" /> 
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<title>Gestion Clients</title>
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
<legend>Clients</legend>
<h3>Gestion des clients</h3>
<% 

//récupérer les articles dans la requête 
ArrayList listeClient=(ArrayList)request.getAttribute("listeClient"); 
%> 


<br><br><table > 
<tr> <th>Identifiant</th><th>Nom</th><th>Prenom</th> 
<th>Date naissance</th><th>Adresse</th><th>ville</th><th>pays</th><th>Supprimer</th></tr> 

    <% 
    int i;
    for(i=0 ; i < listeClient.size() ; i++) 
    { 
   Client c=(Client)listeClient.get(i); 
    out.println("<tr>"); 
    out.println("<td>"+c.getLogin()+"</td>"); 
    out.println("<td>"+c.getNom()+"</td>"); 
    out.println("<td>"+c.getPrenom()+"</td>"); 
    out.println("<td>"+c.getDn()+"</td>"); 
    out.println("<td>"+c.getAdre()+"</td>"); 
    out.println("<td>"+c.getVille()+"</td>");
    out.println("<td>"+c.getPays()+"</td>"); 
    out.println("<td><a href=SupprimerClient?id="+c.getId()+"><img src=Images/Icones/delete1.png></a></td>"); 
    out.println("</tr>"); 
    }
%>

</table>

</fieldset>
</div>
<!-- Sidebar -->
		<div id="sidebar">
                
                    <c:import url="MenuAdmi.jsp"></c:import>  
                    
        </div>                           
		</div>
		<!-- End Sidebar -->

<div class="cl">&nbsp;</div>
	</div>
	<!-- End Main -->
	
	<!-- Footer -->
	<div id="footer">
		<p class="left">
			<a href="#">Accueil</a>
			<span>|</span>
			<a href="#">Aider</a>
			<span>|</span>
			<a href="#">Mon Compte</a>
			<span>|</span>
			<a href="#">Magasin</a>
			<span>|</span>
			<a href="#">Contactez-nous</a>
		</p>
		<p class="right">
			&copy;
			Design by Sellam Mhammad & Dahani Youssef & El fadili youness
		</p>
	</div>
	<!-- End Footer -->
	
</div>	
<!-- End Shell -->

</body>
</html>