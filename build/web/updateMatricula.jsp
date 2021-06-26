<%-- 
    Document   : updateMatricula
    Created on : 19/06/2021, 11:15:36
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpdateMatricula</title>
    </head>
    <body>
        <%
            model.DAO dao = new model.DAO();
            model.JavaBeans matricula = new model.JavaBeans();
            
            //setar variaveis JavaBeans
            matricula.setId_mat(request.getParameter("id_mat"));
            matricula.setNome_aluno(request.getParameter("nome"));
            matricula.setFone(request.getParameter("fone"));
            matricula.setEmail(request.getParameter("email"));
            matricula.setCurso(request.getParameter("curso"));

            //executar metodo alterarContato
            dao.alterarMatricula(matricula);

            //redirecionar para doc matriculas_cadastradas.jsp (att as alteraçoes)
            response.sendRedirect("edicaoMatSucess.html");
        %>
    </body>
</html>
