<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script type="text/javascript" >
  function myopen()
  {
	  document.getElementById("tableopen").submit();
	  
  }
  
  function myactive()
  {
	  document.getElementById("tableactive").submit();
  }
  
  function myorder()
  {
	  document.getElementById("order").submit();
  }
  
  function goFurther(id,status){ 
	  document.getElementById("floortableid").value=id;
	  document.getElementById("floortablestatus").value=status;
  	document.getElementById("inactive").disabled = false;	
   } 
  function disable()
  {
	  document.getElementById("inactive").disabled = true; 
  }
 
  </script>
<body onload="disable()">  
<div class="container">
	<h2>Dynamic Tabs</h2>
	<ul class="nav nav-tabs">
		<li><a href="testajax">Establishment</a></li>
		<li><a data-toggle="tab" href="#menu1">Floor</a></li>
		<li class="active"><a data-toggle="tab" href="#menu2">Tables</a></li>
		<li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
	</ul>
	<div class="tab-content">
		<div id="menu2" class="tab-pane fade in active">
			<div class="col-lg-12 grid-margin stretch-card" >
				<div class="card">
					<div class="card-body">
						<div class="table-responsive">
							<c:forEach var="s" items="${TABLELIST}">
								<tr>
									<c:if test="${s.status=='running'}">
									<td><input type="button" class="btn btn-danger mr-2"
										id="button" value="${s.name}" /></td>
										</c:if>
										<c:if test="${s.status=='open'}">
									<td><input type="button" class="btn btn-success mr-2"
										id="button" value="${s.name}" onclick="goFurther(${s.id},'${s.status}')"/></td>
										</c:if>
								</tr>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form action="tableopen.html" method="post" id="tableopen">
	</form>
	<form action="tableactive.html" method="post" id="tableactive">
	</form>
	<form action="order.html" method="post" id="order">
	<input type="hidden" id="floortableid" name="floortableid">
	<input type="hidden" id="floortablestatus" name="floortablestatus">
	</form>
	<input type="button" class="btn btn-success mr-2" value="open" onclick="myopen()">
	<input type="button" class="btn btn-danger mr-2" value="running" onclick="myactive()">
	<input type="button" class="btn btn-danger mr-2" value="order" id="inactive" onclick="myorder()">
	</div>
	</body>