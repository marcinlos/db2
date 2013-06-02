<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="pl.edu.agh.iisg.bd213lg.mvc.domain.*"%>
<%@page import="pl.edu.agh.iisg.bd213lg.mvc.dao.*"%>
 
<jsp:useBean id="customers" type="pl.edu.agh.iisg.bd213lg.mvc.dao.CustomerDAO" 
    scope="request" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Customers</title>
    </head>
 
    <body>
        <!-- 
        <form method="POST" action="guest.html">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form>
        -->
        <hr>
        <ol> 
        <% for (Customer customer : customers.findAll()) { %>
            <li> <%= customer.getCompanyName() %> </li>
        <% } %>
        </ol>
        <hr>
    </body>
</html>