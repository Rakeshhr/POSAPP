<%
session.invalidate();
//session.removeAttribute("USER");
response.sendRedirect("login.html");
%>