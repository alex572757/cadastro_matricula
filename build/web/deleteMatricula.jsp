<%-- 
    Document   : deleteMatricula
    Created on : 19/06/2021, 11:18:53
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DeleteMatricula</title>
    </head>
    <body>
        <%
            model.DAO dao = new model.DAO();
            model.JavaBeans matricula = new model.JavaBeans();
            
            //Id matricula a ser removido
            String id_mat = request.getParameter("id_mat");

            //setar variavel JavaBeans
            matricula.setId_mat(id_mat);

            //executar metodo deletarMatricula
            dao.deletarMatricula(matricula);

            //redirecionar para doc matriculas_cadastradas.jsp (att as alteraçoes)
            response.sendRedirect("deleteMatSucess.html");
        %>
    </body>
</html>
