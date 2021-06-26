/* 
 * Validação de formulário
 */

function validar(){
    let nome = frmMatricula.nome.value
    let fone = frmMatricula.fone.value
    let curso = frmMatricula.curso.value
    
    if(nome === ""){
        alert('Preencha o campo Nome')
        frmMatricula.nome.focus()
        return false
    } else if(fone === ""){
        alert('Preencha o campo Fone')
        frmMatricula.fone.focus()
        return false
    } else if(curso === ""){
        alert('Preencha o campo Curso')
        frmMatricula.curso.focus()
        return false
    }else{
        document.forms["frmMatricula"].submit()
    }
}
