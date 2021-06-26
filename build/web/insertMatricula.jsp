<%-- 
    Document   : OlaMundo
    Created on : 19/06/2021, 10:20:42
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InsertMatricula</title>
    </head>
    <body>
        <%
            //Insere um nova matricula
            model.DAO dao = new model.DAO();
            model.JavaBeans matricula = new model.JavaBeans();
            
            //setar as variaveis no JavaBeans
            matricula.setNome_aluno(request.getParameter("nome"));
            matricula.setFone(request.getParameter("fone"));
            matricula.setEmail(request.getParameter("email"));
            matricula.setCurso(request.getParameter("curso"));

            //invocar metodo inserirMatricula passando o objeto matricula
            dao.inserirMatricula(matricula);
            
            //redirecionar para o doc cadastro_matricula.jsp
            response.sendRedirect("cadastroMatSucess.html");
        %>
    </body>
</html>
