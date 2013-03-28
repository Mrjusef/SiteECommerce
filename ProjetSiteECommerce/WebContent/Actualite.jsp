			<%@page import="projet.site.eCommerce.beans.Produit"%>
            <%@page import="java.util.ArrayList"%>
                <div id="slider" class="box">
				<div id="slider-holder">
					<ul>
					<%
					ArrayList<Produit> act =(ArrayList<Produit>)request.getAttribute("listeProduit");
					for(Produit p : act){
					%>
					<li><a href="#"><img src="Images/images/<%=p.getPhoto() %>" alt="" style="width: 383px; height: 231px"/></a></li>
					<%
					}
					%>
					    <!-- li><a href="#"><img src="Images/images/pc1.jpg" alt="" style="width: 383px; height: 231px"/></a></li>
					    <li><a href="#"><img src="Images/images/pcp1.jpg" alt="" style="width: 383px; height: 231px"/></a></li>
					    <li><a href="#"><img src="Images/images/pc2.jpg" alt="" style="width: 383px; height: 231px"/></a></li>
					    <li><a href="#"><img src="Images/images/pcp2.jpg" alt="" style="width: 383px; height: 231px"/></a></li-->
					</ul>
				</div>
				<div id="slider-nav">
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
				</div>
				</div>
		