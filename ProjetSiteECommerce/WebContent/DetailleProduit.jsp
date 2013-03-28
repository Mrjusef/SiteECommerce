<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="projet.site.eCommerce.beans.Produit"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produit</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/stylee.css" type="text/css" />
<!-- JS -->
<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
<!-- End JS -->
</head>
<body>
	<!-- Shell -->
	<div class="shell">
		<c:import url="header.jsp"></c:import>

		<!-- End Header -->
		<!-- Main -->
		<div id="main">
			<div id="content">

				
					<%
						Produit p = (Produit) request.getAttribute("produit");
					%>
					
					<h3>Produit</h3>
					<blockquote>
						<a href="ServletCategorieFormulaire"><img
							src=Images/Icones/add.png></a>
					</blockquote>
					<%
						out.println("<hr class='barre'>");
						out.println("<div id='photo'>");
						out.println("<img src=Images/images/" + p.getPhoto()
								+ " style=\"width: 195px; height: 260px\">");
						out.println("</div>");
						out.println("<div>");
						out.println("<br><b>ID:</b>" + p.getIdProduit());
						out.println("<br><b>Produit :</b>" + p.getLibelle());
						out.println("<br><b>Prix :</b>" + p.getPrix() + "DH");
						out.println("<br><b>Quantitée :</b>" + p.getCont());
						out.println("<br><b>Description :</b>" + p.getDescription());
						out.println("<br><br><br><br><center><a href=PrepareModifierProduit?id="
								+ p.getIdProduit()
								+ "><img src=Images/Icones/modifier.png></a>  <a href=SupprimerProduit?id="
								+ p.getIdProduit()
								+ "><img src=Images/Icones/supprimer.png></a></center> ");
						out.println("</div>");
					%>
				
			</div>

			<!-- Sidebar -->
			<div id="sidebar">

				<c:import url="MenuAdmi.jsp"></c:import>
				<c:import url="ServletCategorieModel"></c:import>
			</div>
			<!-- End Sidebar -->

			<div class="cl">&nbsp;</div>
		</div>
		<!-- End Main -->

		<!-- Footer -->
		<div id="footer">
			<p class="left">
				<a href="#">Accueil</a> <span>|</span> <a href="#">Aider</a> <span>|</span>
				<a href="#">Mon Compte</a> <span>|</span> <a href="#">Magasin</a> <span>|</span>
				<a href="#">Contactez-nous</a>
			</p>
			<p class="right">&copy; Design by Sellam Mhammad & Dahani Youssef
				& El fadili youness</p>
		</div>
		<!-- End Footer -->

	</div>
	<!-- End Shell -->


</body>
</html>