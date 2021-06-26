/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar(){
    let username = frmLogin.username.value
    let senha = frmLogin.senha.value
    
    if(username === ""){
        alert('Preencha o campo Username')
        frmLogin.username.focus()
        return false
    } else if(senha === ""){
        alert('Preencha o campo Senha')
        frmLogin.senha.focus()
        return false
    } else{
        document.forms["frmLogin"].submit()
    }
}
