<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

</head>
<body>
<form:form method = "POST" action = "createuser"  modelAttribute="user">
         
            
               <form:label path = "name">Name</form:label>
               <form:input path = "name" />
           
              <form:label path = "password">Age</form:label>
               <form:input path = "password" />
           
               <form:label path = "role">id</form:label>
               <form:input path = "role" />
           
                  <input type = "submit" value = "Submit"/>
           
         
      </form:form>
</body>
</html>