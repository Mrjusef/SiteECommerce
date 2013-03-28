
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>E-commerce</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->

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
		<div class="cl">&nbsp;</div>
		
		<!-- Content -->
		<div id="content">
		
			<!-- Content Slider -->
				 <c:import url="ProduitActualite"></c:import>  	 
		
				<div class="cl">&nbsp;</div>
				 <c:import url="ProduitMain"></c:import>
			   <div class="cl">&nbsp;</div>
			</div>
		
		<!-- End Content -->
		<!-- Sidebar -->
		<div id="sidebar">
                     <c:import url="MenuAdmi.jsp"></c:import>  
                     <c:import url="ServletCategorieModel"></c:import>              
		</div>
		<!-- End Sidebar -->
        
		<div class="cl">&nbsp;</div>
		
	</div>
	 
	<!-- End Main -->
	
	<!-- Side Full -->	           
    <c:import url="sidefull.jsp"></c:import>
	
	<!-- Footer -->
	<c:import url="Footer.jsp"></c:import>
	
</div>	
<!-- End Shell -->
	
	
</body>
</html>