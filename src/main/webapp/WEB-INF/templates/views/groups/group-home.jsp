<%-- 
    Document   : group-home
    Created on : 2 mar 2021, 10:52:40
    Author     : amrit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>groups-home</title>
    </head>
    <body>
        <h1>this is the group page</h1>
        <p>
            <a href="${pageContext.request.contextPath}/home"><button>Home</button></a><br/><br/>
            <br/><br/>
        </p>
        
        <hr>
        
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>nome gruppo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${groups}" var="g">
                    <tr>
                        <td>${g.id}</td>
                        <td>${g.groupName}</td>
                        <td>
                            <form method="post" action="select">
                                <button>Seleziona</button>
                                <!--<input type="hidden" name="action" value="delete">-->
                                <input type="hidden" name="id" value=${g.id}>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="remove">
                                <button>Rimuovi</button>
                                <!--<input type="hidden" name="action" value="delete">-->
                                <input type="hidden" name="id" value=${g.id}>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <hr>
        
        
    </body>
</html>
