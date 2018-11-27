<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>POSDemo</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="static/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="static/vendors/iconfonts/font-awesome/css/font-awesome.css">
  <link rel="stylesheet" href="static/vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="static/vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="static/css/style.css">
  <link rel="shortcut icon" href="static/images/favicon.png" />
</head>

<body>

		<div class="container-scroller">
		<header id="header">
		<tiles:insertAttribute  name="header"/>
		</header>
		<div class="container-fluid page-body-wrapper">
		<section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section>		
		<div class="main-panel">
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
		
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
		</div>
		</div>
		</div>		
</body>
</html>