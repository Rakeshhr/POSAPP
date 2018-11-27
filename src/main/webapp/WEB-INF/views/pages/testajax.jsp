 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Dynamic Tabs</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a href="#home">Establishment</a></li>
    <li><a data-toggle="tab" href="#menu1">Floor</a></li>
    <li><a data-toggle="tab" href="#menu2">Table</a></li>
    <li><a data-toggle="tab" href="#menu3">Menu</a></li>
  </ul>

  <div class="tab-content">
		<div id="home" class="tab-pane fade in active">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<div class="table-responsive">
						<form action="posfloor.html" method="post" id="estform">
							<c:forEach var="s" items="${ESTABLISHMENTMAP}">
								<tr>
									<td><input type="button" class="btn btn-success mr-2" id="button"
											 value="${s.value}" onclick="crunchifyAjax(${s.key})"  />
										</td>
								</tr>
							</c:forEach>
							<input type="hidden" id="estid" name="estid">
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
    document.getElementById("estid").value=id;
    document.getElementById("estform").submit(); 
    }

</script>
</body>
</html>
