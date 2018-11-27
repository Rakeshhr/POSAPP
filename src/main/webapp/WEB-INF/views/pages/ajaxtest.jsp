<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#home">Establishment</a></li>
		<li><a href="#FLOOR">Floor</a></li>
		<li><a href="#menu2">Menu 2</a></li>
		<li><a href="#menu3">Menu 3</a></li>
	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<div class="table-responsive">
						<form action="ajaxtest.html" method="post" id="estform">
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
		
		<div id="FLOOR" class="tab-pane fade">
			<c:if test="${not empty FLOORLIST}">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<div class="table-responsive">
							<c:forEach var="s" items="${FLOORLIST}">
								<tr>
									<td><input type="button" class="btn btn-success mr-2" id="button"
											 value="${s.value}"   />
										</td>
								</tr>
							</c:forEach>
						</div>
					</div>
				</div>
			</div> 
			</c:if>
		</div>
		<div id="menu2" class="tab-pane fade">
			<h3>Menu 2</h3>
			<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem
				accusantium doloremque laudantium, totam rem aperiam.</p>
		</div>
		<div id="menu3" class="tab-pane fade">
			<h3>Menu 3</h3>
			<p>Eaque ipsa quae ab illo inventore veritatis et quasi
				architecto beatae vitae dicta sunt explicabo.</p>
		</div>
	</div>
</div>

<script type="text/javascript">
    function crunchifyAjax(id) {
    alert(id);
  
        $.ajax({
        	type: "POST",
            url : "ajaxtest-" + id + ".html",
            success : function(data) {
                $('#result').html(data);
            }
        });
        $('.nav-tabs a[href="#FLOOR"]').tab('show');
    }

</script>

