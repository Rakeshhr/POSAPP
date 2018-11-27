<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 				<div class="col-12">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Add Menu Master</h4>
                      <form class="forms-sample" action="menumaster.html" method="post">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Enter Menu Master Name" name="menumaster">
                        </div>
                        <input type="submit" class="btn btn-success mr-2" value="ADD">
                      </form>
                    </div>
                  </div>
                </div>
                
                <br><br>
                
                 <div class="table-responsive">
                    <table class="table table-dark">
                      <thead>
                        <tr>
                         <th>Existing Menu Masters</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="s" items="${MENUMASTERLIST}">
						<tr>						
						<td><c:out value="${s.name}"/></td>
						<td>
						</tr>
						</c:forEach>
                      </tbody>
                    </table>
                  </div>
                
                
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br>