<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
function l2menulist(id,name)
{
	document.getElementById("l1menuid").value=id;
	document.getElementById("l2menuname").value=name;
	document.getElementById("l2menulist").submit();
	}
	
function l3menulist(id)
{
	
	document.getElementById("l2menuid").value=id;
	document.getElementById("l3menulist").submit();
	}
	
var list = [];
function addtablevalue(id,name,price,tax)
{
	var datatable=[id];
	list.push(datatable);
	$('#maintable').append('<tr><td>'+ id +'</td><td>'+ name +'</td><td>'+ price + '</td><td>'+ tax +'</td></tr>');
	document.getElementById("datatableid").value=list;
	}

function datatablesubmit()
{
	document.getElementById("datatableform").submit();
	}
	
</script>

	<div class="container">
		<h2>Dynamic Tabs</h2>
		<ul class="nav nav-tabs">
			<li><a href="testajax">Establishment</a></li>
			<li><a data-toggle="tab" href="#menu1">Floor</a></li>
			<li><a data-toggle="tab" href="#menu2">Tables</a></li>
			<li class="active"><a data-toggle="tab" href="#menu3">Menu</a></li>
		</ul>

		<div class="tab-content">
			<div id="menu3" class="tab-pane fade in active">
				<div class="col-lg-12 grid-margin stretch-card">
					<div class="card">
						<div class="card-body">
							<div class="table-responsive">
								<c:forEach var="s" items="${L1MenuList}">
									<tr>
										<td><input type="button" class="btn btn-success mr-2"
											id="button" value="${s.name}" onclick="l2menulist(${s.id},'${s.name}')" /></td>
									</tr>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<form action="l2menulist.html" method="post" id="l2menulist">
			<input type="hidden" id="l2menuname" name="l2menuname">
			<input type="hidden" id="l1menuid" name="l1menuid">
		</form>
		<form action="l3menulist.html" method="post" id="l3menulist">
			<input type="hidden" id="l2menuid" name="l2menuid">
		</form>
		<c:if test="${not empty L2MenuList}">
			<div class="tab-content" id="hidediv">
				<div id="menu3" class="tab-pane fade in active">
					<div class="col-lg-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<div class="table-responsive">
									<c:forEach var="s" items="${L2MenuList}">
										<tr>
											<td><input type="button" class="btn btn-success mr-2"
												id="button" value="${s.name}" onclick="l3menulist(${s.id})" /></td>
										</tr>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${not empty L3MenuList}">
			<div class="tab-content" id="hidediv">
				<div id="menu3" class="tab-pane fade in active">
					<div class="col-lg-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<div class="table-responsive">
									<c:forEach var="s" items="${L3MenuList}">
										<tr>
											<td><input type="button" class="btn btn-success mr-2"
												id="button123" value="${s.name}" onclick="addtablevalue(${s.id},'${s.name}',${s.price},'${s.tax.name}')" /></td>
										</tr>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		
	<div class="split right" style="position:fixed;
							overflow:scroll;
							display:inline-block;
							right:0px;
							top:100px;
							bottom:50px;
							width:640px;">
                    <table class="table table-dark" id="maintable">
                      <thead>
                        <tr>
						  <th>Code</th>
						  <th>Description</th>
						  <th>Amount</th>
						  <th>Tax</th>
                        </tr>
                      </thead>
                    </table>
                  </div>
                </div>
            
            <input type="button" onclick="datatablesubmit()" value="KOT">
            <form action="datatable.html" method="post" id="datatableform">
            
            
            <input type="hidden" id="datatableid" name="datatableid">
            <input  class="form-control" placeholder="PAX" name="PAX">
            <input  class="form-control" placeholder="STEWARD" name="STEWARD">
            </form>
