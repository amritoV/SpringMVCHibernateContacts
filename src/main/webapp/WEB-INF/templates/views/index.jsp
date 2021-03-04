<%-- 
    Document   : index1
    Created on : 1 mar 2021, 09:29:09
    Author     : amrit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Benvenuto</h1>
        
        <br>
        <p>
            <a href="${pageContext.request.contextPath}/contacts/home"><button>contatti</button></a> <br/><br/>
            <a href="${pageContext.request.contextPath}/groups/home"><button>gruppi</button></a> <br/><br/>
        </p>
    </body>
</html>
