<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function  establishfun()
{
	var v1 = document.getElementById("mId").value;
	alert(v1);
	   document.getElementById("formid").submit();
}
	
	

</script>
		
	
		<div class="col-sm-9">
                 
                      <h3>Add Table and It's Capacity</h3><br>
		<form class="forms-sample" id="formid" action="tablepost.html"
				method="post">
	
		
		<div class="col-sm-9" >
			<h4>Select Establishment name</h4><br>
 			<form:select path="TableFormBean" class="form-control" id = "mId"  name = "mId" onchange="establishfun()"> 
				<form:option value="NONE" label="--- Select ---"/>
			    <form:options items="${ESTABLISHMENTMAP}"/>
			</form:select> 
		</div>
		</form>
		</div>
		<br>

		<form:form class="forms-sample" 
				modelAttribute="TableFormBean" action="table.html" method="post">


				<div class="col-sm-9">
					<h4>Select Floor name</h4>
					<br>
						<form:select path="tableId" class="form-control">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${FLOORLIST}" />
						</form:select>
					</div>
				<br>
				<div class="col-sm-9">
                   <h4>Enter Table name</h4><br>
                   <form:input path = "tableName" class="form-control"  placeholder="Enter table Name"  />
                </div>
				<br>
				  <div class="col-sm-9">
            <h4>Enter Maximum Capacity </h4><br>
             <form:input path = "maxNo" class="form-control"  placeholder="Enter Maximum Capacity"  />
        </div>
        <br>
		 <input type="submit" class="btn btn-success mr-2" value="Submit">

			</form:form>
				
			
			
<!-- 			<div class="col-lg-12 grid-margin stretch-card" id="myLink"> -->
<!--               <div class="card"> -->
<!--                 <div class="card-body"> -->
<!--                   <h4 class="card-title" id="target">Establishment Floor</h4> -->
                
<!--                   <div class="table-responsive"> -->
<!--                     <table class="table table-dark"> -->
<!--                       <thead> -->
<!--                         <tr> -->
<!--                          <th>table Name</th> -->
<!--                         </tr> -->
<!--                       </thead> -->
<!--                       <tbody> -->
<%--                         <c:forEach var="s" items="${TABLELIST}"> --%>
<!-- 						<tr> -->
<%-- 						<td><c:out value="${s.name}"/></td> --%>
<!-- 						</tr> -->
<%-- 						</c:forEach> --%>
<!--                       </tbody> -->
<!--                     </table> -->
<!--                   </div> -->
<!--                 </div> -->
<!--               </div> -->
<!--             </div> -->
      
		