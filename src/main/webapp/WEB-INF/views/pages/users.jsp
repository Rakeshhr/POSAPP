<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				
				<div class="col-12">
                  <div class="card">
                    <div class="card-body">
                      
                      <form:form class="forms-sample" method="post" action="createuser.html" modelAttribute="user" >
                        <div class="form-group">
                          <form:label path = "name" >UserName</form:label>
                          <form:input path = "name" class="form-control"  placeholder="Enter UserName" />
                        </div>
                        <div class="form-group">
                          <form:label path = "password" for="exampleInputPassword1">Password</form:label>
                          <form:input path = "password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
                        </div>
                        <div>
                        <label>Role</label>
                         <div class="col-sm-9" >
                            <form:select class="form-control" path = "role">
                              <option>ADMIN</option>
                              <option>MANAGER</option>
                              <option>POS</option>
                              <option>STEWARD</option>
                            </form:select>
                          </div>
                          </div>
                          <br>
                        <button type="submit" class="btn btn-success mr-2">Submit</button>
                        <button class="btn btn-light">Cancel</button>
                      </form:form>
                      
                    </div>
                  </div>
                </div>
                
                <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Users Table</h4>
                
                  <div class="table-responsive">
                    <table class="table table-dark">
                      <thead>
                        <tr>
                          <th>UserID</th>
						  <th>UserName</th>
						  <th>Password</th>
						  <th>UserRole</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="s" items="${USERLIST}">
						<tr>
						<td><c:out value="${s.id}"/> </td>
						<td><c:out value="${s.name}"/></td>
						<td><c:out value="*******" /></td>
						<td><c:out value="${s.role}"/></td>
						</tr>
						</c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>