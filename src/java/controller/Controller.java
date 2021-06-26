/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.DAO;
import model.JavaBeans;
import model.JavaBeansLogin;

/**
 *
 * @author PICHAU
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete", "/login", "/insertLogin", "/buscaMat"})
public class Controller extends HttpServlet {

    
    DAO dao = new DAO();
    JavaBeans matricula = new JavaBeans();
    JavaBeansLogin login = new JavaBeansLogin();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        
        if(action.equals("/main")){
            //matriculas(request, response);
        } else if(action.equals("/insert")){
            //novaMatricula(request, response);
        } else if(action.equals("/select")){
            //listarMatricula(request, response);
        } else if(action.equals("/update")){
            //editarMatricula(request, response);
        } else if(action.equals("/delete")){
            //removerMatricula(request, response);
        } else if(action.equals("/login")){
            //login(request, response);
        } else if(action.equals("/insertLogin")){
            //novoLogin(request, response);
        } else if(action.equals("/buscaMat")){
            //buscaMatricula(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }
    
    /*protected void buscaMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        matricula.setId_mat(request.getParameter("id_mat"));
        matricula.setNome_aluno(request.getParameter("nome_aluno"));
        
        JavaBeans matriculaReturn = dao.buscarMatricula(matricula);
        if (matriculaReturn == null) {
            try {
                response.sendRedirect("idMatriculaInvalid.html");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else {
            matriculaReturn = dao.selecionarNome(matricula);
            if (matriculaReturn == null) {
                try {
                    response.sendRedirect("nomeMatriculaInvalid.html");
                } catch (IOException ex) {
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
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }*/
    
    //login
    /*protected void login(HttpServletRequest request, HttpServletResponse response) {
        
        login.setUsername(request.getParameter("username"));
        login.setSenha(request.getParameter("senha"));
        
        JavaBeansLogin loginReturn = dao.selecionarUser(login);
        if (loginReturn == null) {
            try {
                response.sendRedirect("loginFailUser.html");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else {
            loginReturn = dao.selecionarSenha(login);
            if (loginReturn == null) {
                try {
                    response.sendRedirect("loginFailSenha.html");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else {
                try {
                    response.sendRedirect("loginSucess.html");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }*/
    
    /*protected void novoLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        login.setUsername(request.getParameter("username"));
        login.setSenha(request.getParameter("senha"));

        dao.inserirLogin(login);

        response.sendRedirect("index.html");
    }*/
    
    //listar matriculas
    /*protected void matriculas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //criando obj para receber dados JavaBeans
        ArrayList<JavaBeans> lista = dao.listarMatriculas();
        
        //encaminhar lista para doc matriculas_cadastradas.jsp
        request.setAttribute("matriculas", lista);
        RequestDispatcher rd = request.getRequestDispatcher("matriculas_cadastradas.jsp");
        rd.forward(request, response);
        
    }*/
    
    //Nova matricula
    /*protected void novaMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //setar as variaveis no JavaBeans
        matricula.setNome_aluno(request.getParameter("nome"));
        matricula.setFone(request.getParameter("fone"));
        matricula.setEmail(request.getParameter("email"));
        matricula.setCurso(request.getParameter("curso"));
        
        //invocar metodo inserirMatricula passando o objeto matricula
        dao.inserirMatricula(matricula);
        
        //redirecionar para o doc cadastro_matricula.jsp
        response.sendRedirect("main");
    }*/
    
    //Editar matricula
    /*protected void listarMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    }*/
    
    /*protected void editarMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //setar variaveis JavaBeans
        matricula.setId_mat(request.getParameter("id_mat"));
        matricula.setNome_aluno(request.getParameter("nome"));
        matricula.setFone(request.getParameter("fone"));
        matricula.setEmail(request.getParameter("email"));
        matricula.setCurso(request.getParameter("curso"));
        
        //executar metodo alterarContato
        dao.alterarMatricula(matricula);
        
        //redirecionar para doc matriculas_cadastradas.jsp (att as alteraçoes)
        response.sendRedirect("main");
    }*/
    
    //remover uma matricula
    /*protected void removerMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Id matricula a ser removido
        String id_mat = request.getParameter("id_mat");
        
        //setar variavel JavaBeans
        matricula.setId_mat(id_mat);
        
        //executar metodo deletarMatricula
        dao.deletarMatricula(matricula);
        
        //redirecionar para doc matriculas_cadastradas.jsp (att as alteraçoes)
        response.sendRedirect("main");
    }*/
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
