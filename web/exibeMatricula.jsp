<%-- 
    Document   : teste
    Created on : 17/06/2021, 14:39:40
    Author     : PICHAU
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de Matrícula</title>
        <link rel="stylesheet" href="style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Matrícula</h1>
        <table id="tabela">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome Aluno</th>
                    <th>Fone</th>
                    <th>E-mail</th>
                    <th>Curso</th>
                    <th>Opções</th>
                </tr>
                <tbody>
                        <tr>
                            <td><%out.print(request.getAttribute("id_mat"));%></td>
                            <td><%out.print(request.getAttribute("nome"));%></td>
                            <td><%out.print(request.getAttribute("fone"));%></td>
                            <td><%out.print(request.getAttribute("email"));%></td>
                            <td><%out.print(request.getAttribute("curso"));%></td>
                            <td><a href="selectMatricula.jsp?id_mat=<%=request.getAttribute("id_mat") %>" class="Botao1">Editar</a>
                                <a href="javascript: confirmar(<%=request.getAttribute("id_mat") %>)" class="Botao2">Excluir</a>
                            </td>
                        </tr>
                </tbody>
            </thead>
        </table>
        <script src="scripts/confirmador.js"></script>
        <h2></h2>
        <a href="buscarMatricula.html" class="Botao1">Voltar</a>
    </body>
</html>
