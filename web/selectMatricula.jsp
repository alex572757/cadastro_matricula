<%-- 
    Document   : selectMatricula
    Created on : 19/06/2021, 11:09:54
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SelectMatricula</title>
    </head>
    <body>
        <%
            model.DAO dao = new model.DAO();
            model.JavaBeans matricula = new model.JavaBeans();
            
            //Id matricula a ser editado
            String id_mat = request.getParameter("id_mat");

            //setar a variavel JavaBeans
            matricula.setId_mat(id_mat);

            //executar método selecionarMatricula (DAO)
            dao.selecionarMatricula(matricula);

            //setar os atributos do formulario com o conteudo JavaBeans
            request.setAttribute("id_mat", matricula.getId_mat());
            request.setAttribute("nome", matricula.getNome_aluno());
            request.setAttribute("fone", matricula.getFone());
            request.setAttribute("email", matricula.getEmail());
            request.setAttribute("curso", matricula.getCurso());

            //encaminhar ao doc editar.jsp
            RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
            rd.forward(request, response);
        %>
    </body>
</html>
