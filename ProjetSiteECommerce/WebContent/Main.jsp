<!-- Products -->

<%@ page import="java.util.ArrayList" %>  
  <%@ page import="projet.site.eCommerce.beans.Produit" %>
  <div class="products">
  <% 

//récupérer les articles dans la requête 
ArrayList<Produit> listeProduit=(ArrayList<Produit>)request.getAttribute("listeProduit"); 


					int i;
				    for(i=0 ; i < listeProduit.size() ; i++) 
				    { 
				    	Produit p= (Produit)listeProduit.get(i);
				    	%>	
				    
					
			
				<ul>
				    <li>
				    	<a href="#"><img src="Images/images/<%=p.getPhoto() %>" alt="" /></a>
				    	<div class="product-info">
				    		<h3><%=p.getLibelle() %></h3>
				    		<div class="product-desc">
								<h4>Nouveau ...</h4>
				    			<h5>Un ordinateur puissant<a href="#">Détaille ...</a><br /></h5>
				    			<strong class="price"><%=p.getPrix() %> DH</strong>
				    		</div>
				    	</div>
			    	</li>
			    	<% }%>
			    	
				</ul>
			
			<!-- End Products -->
			</div>