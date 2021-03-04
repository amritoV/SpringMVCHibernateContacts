<%-- 
    Document   : contacts
    Created on : 1 mar 2021, 10:09:37
    Author     : amrit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>contacts-home</title>
    </head>
    <body>
        <h1>this is the contacts page</h1>
        <p>
            <a href="${pageContext.request.contextPath}/home"><button>Home</button></a><br/><br/>
            <br/><br/>
        </p>
        <p align="center">
            <a href="${pageContext.request.contextPath}/contacts/add"><button>Aggiungi contatto</button></a><br/><br/>
            <a href="${pageContext.request.contextPath}/contacts/remove"><button>Rimuovi tutti i contatti</button></a><br/>
        </p>
        <hr>
        <table align="center">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Email</th>
                    <th>telefono</th>
                    <th>id</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${contacts}" var="c">
                    <tr>
                        <td>${c.name}</td>
                        <td>${c.surname}</td>
                        <td>${c.email}</td>
                        <td>${c.telephone}</td>
                        <td>${c.id}</td>
                        <td>
                            <form method="post" action="remove">
                                <button>Rimuovi</button>
                                <!--<input type="hidden" name="action" value="delete">-->
                                <input type="hidden" name="id" value=${c.id}>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="modify">
                                <button>Modifica</button>
                                <input type="hidden" name="idModify" value=${c.id}>  <!--Perche non riesco a passare l'intero contatto-->
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
        <hr>
        
        
        
    </body>
</html>
