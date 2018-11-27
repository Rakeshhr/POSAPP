<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>

   <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>POSDEMO</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="static/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="static/vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="static/vendors/css/vendor.bundle.addons.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="static/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="static/images/favicon.png" />

</head>
 
<body>
		

		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
		
			
</body>
</html>