<%-- 
    Document   : contact-modify
    Created on : 3 mar 2021, 10:13:53
    Author     : amrit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica contatto</title>
    </head>
    <body>
        <h1>Modifica il contatto: </h1>
        <br>
        <a href="${pageContext.request.contextPath}/home"><button>Home</button></a><br/><br/>
        <a href="${pageContext.request.contextPath}/contacts/home"><button>torna alla lista dei contatti</button></a><br/><br/>
        <br/><br/>
        
        <form:form method="post" action="save" modelAttribute="contact">
            <fieldset>
                <legend> dettagli contatto</legend>
                <div>
                    <form:input id="id" type="hidden" path="id"/>
                </div>
                <div align="center">
                    <label for="nome">nome</label><br/>
                    <form:input id="nome" type="text" path="name"/>
                    <form:errors path="name"/>
                </div>
                <div align="center">
                    <label for="cognome">cognome</label><br/>
                    <form:input id="cognome" type="text" path="surname"/>
                    <form:errors path="surname"/>
                </div>
                <div align="center">
                    <label for="email">email</label><br/>
                    <form:input id="email" type="text" path="email"/>
                    <form:errors path="email"/>
                </div>
                <div align="center">
                    <label for="telefono">telefono</label><br/>
                    <form:input id="telefono" type="text" path="telephone"/>
                    <form:errors path="telephone"/>
                </div>
                <br>
                <p align="center">
                <input type="submit" name="action" value="modifica">
                </p>
            </fieldset>
        </form:form>
        
    </body>
</html>
