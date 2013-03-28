<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<!-- Basics -->
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	
	<title>Authentification</title>

	<!-- CSS -->
	
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/styles1.css">
	
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->

	<!-- JS -->
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
	<script src="js/jquery-func.js" type="text/javascript"></script>
	<!-- End JS -->
	
</head>

	<!-- Main HTML -->
	
<body>
<!-- Shell -->
<div class="shell">
    <c:import url="header.jsp"></c:import>
	<!-- End Header -->

	<!-- Main -->
	<div id="main">
		<div class="cl">&nbsp;</div>
		
		<div id="container">
		
		<form method="Post" action="Authentification">
		
		<label for="name">Nom Utilisateur:</label>
		
		<input type="name" name="login">
		
		<label for="username">Mot de passe:</label>
		
		<p><a href="#">Mot de passe oublier?</a>
		
		<input type="password" name ="pwd">
		
		<div id="lower">
	
		<input type="submit" value="Connecte">
		
		</div>
		
		</form>
		
	</div>

	
	<!-- End Page Content -->
		
        
		<div class="cl">&nbsp;</div>
		
	</div>
	 
	<!-- End Main -->
	
	
</div>	
<!-- End Shell -->
	
	
	<!-- Begin Page Content -->
	
	
	
</body>

</html>