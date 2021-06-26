/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validar(){
    let id_mat = frmBuscaMat.id_mat.value
    let nome_aluno = frmBuscaMat.nome_aluno.value
    
    if(id_mat === ""){
        alert('Preencha o campo Id Matrícula')
        frmBuscaMat.id_mat.focus()
        return false
    } else if(nome_aluno === ""){
        alert('Preencha o campo Nome Aluno')
        frmBuscaMat.nome_aluno.focus()
        return false
    } else{
        document.forms["frmBuscaMat"].submit()
    }
}