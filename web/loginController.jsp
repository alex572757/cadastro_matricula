<%-- 
    Document   : loginController
    Created on : 19/06/2021, 11:23:18
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LoginController</title>
    </head>
    <body>
        <%
            model.DAO dao = new model.DAO();
            model.JavaBeansLogin login = new model.JavaBeansLogin();
            
            login.setUsername(request.getParameter("username"));
            login.setSenha(request.getParameter("senha"));

            model.JavaBeansLogin loginReturn = dao.selecionarUser(login);
            if (loginReturn == null) {
                try {
                    response.sendRedirect("loginFailUser.html");
                } catch (java.io.IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else {
                loginReturn = dao.selecionarSenha(login);
                if (loginReturn == null) {
                    try {
                        response.sendRedirect("loginFailSenha.html");
                    } catch (java.io.IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    try {
                        response.sendRedirect("loginSucess.html");
                    } catch (java.io.IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        %>
    </body>
</html>
