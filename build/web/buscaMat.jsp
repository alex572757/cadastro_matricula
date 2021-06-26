<%-- 
    Document   : buscaMat
    Created on : 19/06/2021, 11:33:30
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BuscaMat</title>
    </head>
    <body>
        <%
            model.DAO dao = new model.DAO();
            model.JavaBeans matricula = new model.JavaBeans();
            
            matricula.setId_mat(request.getParameter("id_mat"));
            matricula.setNome_aluno(request.getParameter("nome_aluno"));

            model.JavaBeans matriculaReturn = dao.buscarMatricula(matricula);
            if (matriculaReturn == null) {
                try {
                    response.sendRedirect("idMatriculaInvalid.html");
                } catch (java.io.IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else {
                matriculaReturn = dao.selecionarNome(matricula);
                if (matriculaReturn == null) {
                    try {
                        response.sendRedirect("nomeMatriculaInvalid.html");
                    } catch (java.io.IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    dao.selecionarMatricula(matriculaReturn);
                    try {
                        //setar os atributos do formulario com o conteudo JavaBeans
                        request.setAttribute("id_mat", matriculaReturn.getId_mat());
                        request.setAttribute("nome", matriculaReturn.getNome_aluno());
                        request.setAttribute("fone", matriculaReturn.getFone());
                        request.setAttribute("email", matriculaReturn.getEmail());
                        request.setAttribute("curso", matriculaReturn.getCurso());

                        //encaminhar ao doc editar.jsp
                        RequestDispatcher rd = request.getRequestDispatcher("exibeMatricula.jsp");
                        rd.forward(request, response);
                    } catch (java.io.IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        %>
    </body>
</html>
