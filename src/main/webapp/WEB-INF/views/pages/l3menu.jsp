<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">

	function myfun(){
   document.getElementById("formid").submit();
	}
	function myfun1(){
   document.getElementById("formid1").submit();
			}
	function myfun2(){
		   document.getElementById("formid2").submit();
			}
	
	function hideLink() {
		  var x = document.getElementById('myLink');
		  var b = document.getElementById('btnLink');


		  if (x.style.display !== 'block') {
		    x.style.display = 'block';
		    b.childNodes[0].nodeValue = "Add";

		  } else {
		    x.style.display = 'none';
		    b.childNodes[0].nodeValue = "Add";
		  }
		}

</script>
<div class="col-12">
	<div class="card">
		<div class="card-body">
			<h3>Add L3 Menu</h3>
			<br>
			<br>
			<form class="forms-sample" id="formid" action="l3menupost1.html"
				method="post">
				<div class="col-sm-9">
					<h4>Select Menu Master name</h4>
					<br>
					<form:select path="l3FormBean" class="form-control" id="mmId"
						name="mmId" onchange="myfun()">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${MENUMASTERMAP}" />

					</form:select>
				</div>
			</form>
			<br>
			<form class="forms-sample" id="formid1" action="l3menupost2.html"
				method="post">
				<div class="col-sm-9">
					<h4>Select L1 Menu name</h4>
					<br>
					<form:select path="l3FormBean" class="form-control" id="l1mmId"
						name="l1mmId" onchange="myfun1()">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${L1MENULIST}" />

					</form:select>
				</div>
			</form>
			<br>
			<form action="l3menupost3.html" class="forms-sample" id="formid2" method="post">
			<div class="col-sm-9">
					<h4>Select L2 Menu name</h4>
					<br>
					<form:select path="l3FormBean" class="form-control" onchange="myfun2()" name="l2mmId" id="l2mmId">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${L2MENULIST}" />
					</form:select>
				</div>
			</form>
			<form:form class="forms-sample" modelAttribute="l3FormBean"
				action="l3menu.html" method="post">
				<br>
				<div class="col-sm-9">
					<h4>Enter L3 menu name</h4>
					<br>
					<form:input path="l3MenuName" class="form-control"
						placeholder="Enter L1 Menu Name" />
				</div>
				<br>
				<div class="col-sm-9">
					<h4>Enter Price</h4>
					<br>
					<form:input path="price" class="form-control"
						placeholder="Enter Price" />
				</div>
				<br>
				<div class="col-sm-9">
					<h4>Select Tax from list</h4>
					<br>
					<form:select path="taxId" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${TAXMAP}" />
					</form:select>
				</div>
				<br>
				<br>
				<input type="submit" class="btn btn-success mr-2" value="Submit"
					id="submit">

			</form:form>
			<br>
				<br>
			<c:if test="${not empty L3MENULIST}">
			<div class="col-lg-12 grid-margin stretch-card" id="myLink">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title" id="target">L3 Menu Table</h4>

						<div class="table-responsive">
							<table class="table table-dark">
								<thead>
									<tr>
										<th>L3Menu Name</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="s" items="${L3MENULIST}">
										<tr>
											<td><c:out value="${s.name}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			</c:if>

		</div>
	</div>
</div>