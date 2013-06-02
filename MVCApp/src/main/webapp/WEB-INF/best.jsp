<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="pl.edu.agh.iisg.bd213lg.mvc.domain.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<jsp:useBean id="employees" type="java.util.List<EmployeeStats>" scope="request" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Best employees</title>
    </head>
    <body>
    <table>
        <caption>Best employees</caption>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Boss</th>
            <th>Count</th>
            <th>Avg order value</th>
            <th>Max order value</th>
            <th>Max order customer</th>
        </tr>
        <c:forEach var="stats" items="${employees}">
            <tr>
            <td><c:out value="${stats.firstName}"/>  </td>
            <td><c:out value="${stats.lastName}"/>   </td>
            <td><c:out value="${stats.boss}"/>       </td>
            <td><c:out value="${stats.orderCount}"/> </td>
            <td><c:out value="${stats.avgValue}"/>   </td>
            <td><c:out value="${stats.maxValue}"/>   </td>
            <td><c:out value="${stats.customer}"/>   </td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>