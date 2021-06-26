/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PICHAU
 */
public class JavaBeans {
    private String id_mat;
    private String nome_aluno;
    private String fone;
    private String email;
    private String curso;

    public JavaBeans() {
        super();
    }
    
    public JavaBeans(String id_mat, String nome_aluno, String fone, String email, String curso) {
        super();
        this.id_mat = id_mat;
        this.nome_aluno = nome_aluno;
        this.fone = fone;
        this.email = email;
        this.curso = curso;
    }
    
    public String getId_mat() {
        return id_mat;
    }

    public void setId_mat(String id_mat) {
        this.id_mat = id_mat;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
}
