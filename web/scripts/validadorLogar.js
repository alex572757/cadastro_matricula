/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar(){
    let username = frmLoginAut.username.value
    let senha = frmLoginAut.senha.value
    
    if(username === ""){
        alert('Preencha o campo Username')
        frmLoginAut.username.focus()
        return false
    } else if(senha === ""){
        alert('Preencha o campo Senha')
        frmLoginAut.senha.focus()
        return false
    } else{
        document.forms["frmLoginAut"].submit()
    }
}
