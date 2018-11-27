<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container">
	<h2>Dynamic Tabs</h2>
	<ul class="nav nav-tabs">
		<li><a href="testajax">Establishment</a></li>
		<li class="active"><a data-toggle="tab" href="posfloor">Floor</a></li>
		<li><a data-toggle="tab" href="#menu2">Table</a></li>
		<li><a data-toggle="tab" href="#menu3">Menu</a></li>
	</ul>
	<div class="tab-content">
		<div id="menu1" class="tab-pane fade in active">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<div class="table-responsive">
						<form action="postable.html" method="post" id="floorform">
							<c:forEach var="s" items="${FLOORLIST}">
								<tr>
									<td><input type="button" class="btn btn-success mr-2"
										id="button" value="${s.value}" onclick="crunchifyAjax(${s.key})" /></td>
								</tr>
							</c:forEach>
							<input type="hidden" id="floorid" name="floorid">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
    function crunchifyAjax(id) {
    document.getElementById("floorid").value=id;
    document.getElementById("floorform").submit(); 
    }

</script>