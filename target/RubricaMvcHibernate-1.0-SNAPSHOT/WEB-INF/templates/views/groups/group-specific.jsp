<%-- 
    Document   : group-specific
    Created on : 2 mar 2021, 12:15:51
    Author     : amrit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>gruppo ${group.groupName}</title>
    </head>
    <body>
        <h1>Specifiche gruppo:</h1>
        <br><br>
        <a href="${pageContext.request.contextPath}/home"><button>Home</button></a><br/><br/>
        <a href="${pageContext.request.contextPath}/groups/home"><button>torna alla lista dei Gruppi</button></a><br/><br/>
        <br/><br/>
        
        <hr>
        
        <h2>nome gruppo: ${group.groupName} </h2>
        <br>
        <h2>descrizione: ${group.description}</h2>
        <br>
        <h2> proprietario: ${group.owner.name}, ${group.owner.surname}, ${group.owner.email}</h2>
        <br>
        <h2> messaggi: ${group.messages}
        <hr>
    </body>
</html>
