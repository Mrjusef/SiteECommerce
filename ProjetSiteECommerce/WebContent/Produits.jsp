<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="projet.site.eCommerce.beans.Produit"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Produits</title>
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

				<fieldset>
					<%
						ArrayList<Produit> listeProduit = (ArrayList) request
								.getAttribute("listeProduit");
					%>
					<legend>Produits</legend>
					<h3>Gestion des produits</h3>
					<blockquote>
						<a href="ServletCategorieFormulaire"><img
							src=Images/Icones/add.png></a>
					</blockquote>
					<table>
						<tr>
							<th>Image</th>
							<th>IdProduit</th>
							<th>Libelle</th>
							<th>Prix</th>
							<th>Quantitée</th>
							<th>Etat</th>
							<th>Detaille</th>
							<th>Edit</th>
							<th>Supprimer</th>
						</tr>
						<%
							for (int i = 0; i < listeProduit.size(); i++) {
								Produit p = (Produit) listeProduit.get(i);
								out.println("<tr><td>");
								out.println("<img src=Images/images/" + p.getPhoto()
										+ " style=\"width: 100px; height: 90px\">");
								out.println("</td>");
								out.println("<td>");
								out.println(p.getIdProduit());
								out.println("</td><td>");
								out.println(p.getLibelle());
								out.println("</td><td>");
								out.println(p.getPrix() + "DH");
								out.println("</td><td>");

								out.println(p.getCont());
								out.println("</td><td>");
								int n = (int) p.getEtat();
								if (n == 1) {
									out.println("<img src=Images/Icones/disp.png>");
								}
								if (n == 0) {
									out.println("<img src=Images/Icones/indisp.png>");
								}
								out.println("</td><td>");
								out.println("<a href=ProduitDetaille?id=" + p.getIdProduit()
										+ ">Détaille</a>");
								out.println("</td><td>");
								out.println("<center><a href=PrepareModifierProduit?id="
										+ p.getIdProduit()
										+ "><img src=Images/Icones/modifier.png></a></center> ");
								out.println("</td><td>");
								out.println("<center><a href=SupprimerProduit?id="
										+ p.getIdProduit()
										+ "><img src=Images/Icones/supprimer.png></a></center");
								out.println("</td></tr>");
							}
						%>
					</table>

				</fieldset>
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