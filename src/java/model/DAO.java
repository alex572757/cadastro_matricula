/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PICHAU
 */
public class DAO {

    //Módulo de conexão
    //Parâmetros de conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://dfkpczjgmpvkugnb.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/qindhlg9wmcjrzdm?useTimezone=true&serverTimezone=UTC";
    private String user = "nlnj5rl7g837tco0";
    private String password = "bzjwf3qmuw5m5fsg";

    //Método de conexão
    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //CRUD CREATE
    public void inserirMatricula(JavaBeans matricula) {
        String create = "insert into matriculas (nome_aluno, fone, email, curso) values (?, ?, ?, ?)";
        try {
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            PreparedStatement pst = con.prepareStatement(create);

            //substituir parâmetros (?) pelo conteúdo das variáveis JavaBeans
            pst.setString(1, matricula.getNome_aluno());
            pst.setString(2, matricula.getFone());
            pst.setString(3, matricula.getEmail());
            pst.setString(4, matricula.getCurso());

            //executar a query
            pst.executeUpdate();

            //encerrar conexão com bd TALVEZ AQUI ENTRE UMA VULNERABILIDADE
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public JavaBeansLogin selecionarUser(JavaBeansLogin login) {
        String query = "select username from logins where username = " + "'" + login.getUsername() + "';";

        try{
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            Statement statement = conectar().createStatement();
            ResultSet rs = statement.executeQuery(query);

            JavaBeansLogin loginRetorno = new JavaBeansLogin();
            //executa enquanto houver logins no bd
            while (rs.next()) {
                loginRetorno.setUsername(rs.getString("username"));
                if (loginRetorno.getUsername().equals(login.getUsername())) {
                    break;
                }
            }
            
            con.close();
            if (loginRetorno.getUsername() == null) {
                return null;
            } else {
                return loginRetorno;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public JavaBeansLogin selecionarSenha(JavaBeansLogin login) {
        String query = "select username, senha from logins where username = " + "'" + login.getUsername() + "'" + " and senha = " + "'" + login.getSenha() + "';";

        try{
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            Statement statement = conectar().createStatement();
            ResultSet rs = statement.executeQuery(query);

            JavaBeansLogin loginRetorno = new JavaBeansLogin();
            //executa enquanto houver logins no bd
            while (rs.next()) {
                loginRetorno.setUsername(rs.getString("username"));
                loginRetorno.setSenha(rs.getString("senha"));
                if (loginRetorno.getUsername().equals(login.getUsername())) {
                    break;
                }
            }
            
            con.close();
            if (loginRetorno.getUsername() == null && loginRetorno.getSenha() == null) {
                return null;
            } else {
                return loginRetorno;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inserirLogin(JavaBeansLogin login) {
        String query = "insert into logins (username, senha) values ('" + login.getUsername() + "','" + login.getSenha() + "');";
        try {
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            Statement statement = conectar().createStatement();

            //executar a query
            statement.executeUpdate(query);

            
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public JavaBeans buscarMatricula(JavaBeans matricula) {
        String read2 = "select id_mat from matriculas where id_mat = '" + matricula.getId_mat()+ "';";
        try {
            //abrir conexão com banco
            Connection con = conectar();

            Statement statement = conectar().createStatement();
            ResultSet rs = statement.executeQuery(read2);

            JavaBeans matRetorno = new JavaBeans();
            //executa enquanto houver matriculas no bd
            while (rs.next()) {
                matRetorno.setId_mat(rs.getString("id_mat"));
                if (matRetorno.getId_mat().equals(matricula.getId_mat())) {
                    break;
                }
            }
            
            con.close();
            if (matRetorno.getId_mat()== null) {
                return null;
            } else {
                return matRetorno;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public JavaBeans selecionarNome(JavaBeans matricula) {
        String query = "select id_mat, nome_aluno from matriculas where id_mat = " + "'" + matricula.getId_mat()+ "'" + " and nome_aluno = " + "'" + matricula.getNome_aluno()+ "';";

        try{
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            Statement statement = conectar().createStatement();
            ResultSet rs = statement.executeQuery(query);

            JavaBeans matRetorno = new JavaBeans();
            //executa enquanto houver matriculas no bd
            while (rs.next()) {
                matRetorno.setId_mat(rs.getString("id_mat"));
                matRetorno.setNome_aluno(rs.getString("nome_aluno"));
                if (matRetorno.getId_mat().equals(matricula.getId_mat())) {
                    break;
                }
            }
           
            con.close();
            if (matRetorno.getId_mat()== null && matRetorno.getNome_aluno()== null) {
                return null;
            } else {
                return matRetorno;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //CRUD UPDATE
    //selecionar a matricula
    public void selecionarMatricula(JavaBeans matricula) {
        String read2 = "select * from matriculas where id_mat = ?";
        try {
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, matricula.getId_mat());
            ResultSet rs = pst.executeQuery();

            //executa enquanto houver matriculas no bd
            while (rs.next()) {
                //setar variáveis JavaBeans
                matricula.setId_mat(rs.getString(1));
                matricula.setNome_aluno(rs.getString(2));
                matricula.setFone(rs.getString(3));
                matricula.setEmail(rs.getString(4));
                matricula.setCurso(rs.getString(5));
            }
          
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //editar matricula
    public void alterarMatricula(JavaBeans matricula) {
        String create = "update matriculas set nome_aluno=?,fone=?,email=?,curso=? where id_mat = ?";

        try {
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            PreparedStatement pst = con.prepareStatement(create);

            //substituir parâmetros (?) pelo conteúdo das variáveis JavaBeans
            pst.setString(1, matricula.getNome_aluno());
            pst.setString(2, matricula.getFone());
            pst.setString(3, matricula.getEmail());
            pst.setString(4, matricula.getCurso());
            pst.setString(5, matricula.getId_mat());

            //executar a query
            pst.executeUpdate();

            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //CRUD DELETE
    public void deletarMatricula(JavaBeans matricula) {
        String delete = "delete from matriculas where id_mat=?";

        try {
            //abrir conexão com banco
            Connection con = conectar();

            //preparar query para execução no bd
            PreparedStatement pst = con.prepareStatement(delete);

            //substituir parâmetros (?) pelo conteúdo das variáveis JavaBeans
            pst.setString(1, matricula.getId_mat());

            //executar a query
            pst.executeUpdate();

           
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
