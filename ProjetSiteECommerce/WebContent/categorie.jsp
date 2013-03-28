
<!-- Categories -->
 <%@ page import="java.util.ArrayList" %>  
  <%@ page import="projet.site.eCommerce.beans.Categorie" %>

  <% 

//récupérer les articles dans la requête 
ArrayList listeCategorie=(ArrayList)request.getAttribute("listeCategorie"); 
%> 

				<h2>Categories <span></span></h2>
				<div class="box-content">
					<ul>
					<%
					int i;
				    for(i=0 ; i < listeCategorie.size() ; i++) 
				    { 
				    	Categorie c= (Categorie)listeCategorie.get(i);
				    	out.println("<li><a href=GetProduitCategorie?id="+c.getId()+" >"+c.getLibelle()+"</a></li>");
				    }
					%>
					    
					</ul>
				</div>
			</div>
			<!-- End Categories -->
		