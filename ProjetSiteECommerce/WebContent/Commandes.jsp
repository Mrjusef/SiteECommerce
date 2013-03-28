<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="java.util.ArrayList" %>
 <%@ page import="projet.site.eCommerce.beans.Commande" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des Commandes</title>
</head>
<body>
<fieldset>
<legend>Commande</legend>
<h3>Gestion des commandes</h3>
<% 

//récupérer les articles dans la requête 
ArrayList listeCmd=(ArrayList)request.getAttribute("listeCmd"); 
%> 
<br><br><table > 
<tr> <th>N°</th><th>Date Commande</th><th>Statut </th> <th>Total</th></tr> 

    <% 
    int i;
    for(i=0 ; i < listeCmd.size() ; i++) 
    { 
   Commande c=(Commande)listeCmd.get(i); 
    out.println("<tr>"); 
    out.println("<td>"+c.getIdCmd()+"</td>"); 
    out.println("<td>"+c.getDateCmd()+"</td>"); 
    out.println("<td>"+c.getStatutCmd()+"</td>"); 
    out.println("<td>"+c.getTotalCmd()+" DH </td>");   
    out.println("</tr>"); 
    }
%>

</table>

</fieldset>
</body>
</html>