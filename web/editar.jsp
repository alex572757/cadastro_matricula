<%-- 
    Document   : editar
    Created on : 12/06/2021, 09:45:14
    Author     : PICHAU
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Matrícula</title>
        <link rel="stylesheet" href="style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Editar matrícula</h1>
        <form name="frmMatricula" action="updateMatricula.jsp">
            <table>
                <tr>
                    <td><input type="text" name="id_mat" id="caixa3" readonly value="<%out.print(request.getAttribute("id_mat"));%>"></td>
                </tr>
                <tr>
                    <td><input type="text" name="nome" class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
                </tr>
                <tr>
                    <td><input type="text" name="fone" class="Caixa2" value="<%out.print(request.getAttribute("fone"));%>"></td>
                </tr>
                <tr>
                    <td><input type="text" name="email" class="Caixa1" value="<%out.print(request.getAttribute("email"));%>"></td>
                </tr>
                <tr>
                    <td><input type="text" name="curso" class="Caixa1" value="<%out.print(request.getAttribute("curso"));%>"></td>
                </tr>
            </table>
            <input type="button" value="Salvar" class="Botao1" onclick="validar()">
        </form>
        <script src="scripts/validador.js"></script>
    </body>
</html>
