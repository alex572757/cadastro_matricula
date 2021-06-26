<%-- 
    Document   : insertLogin
    Created on : 19/06/2021, 11:31:01
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InsertLogin</title>
    </head>
    <body>
        <%
            model.DAO dao = new model.DAO();
            model.JavaBeansLogin login = new model.JavaBeansLogin();
            
            login.setUsername(request.getParameter("username"));
            login.setSenha(request.getParameter("senha"));

            dao.inserirLogin(login);

            response.sendRedirect("cadastroLoginSucess.html");
        %>
    </body>
</html>
