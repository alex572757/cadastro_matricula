/* 
 * Confirmação de exclusão de uma matricula
 */

function confirmar(id_mat){
    let resposta = confirm("Confirma a exclusão desta matrícula ?")
    if(resposta === true){
        //alert(id_mat)
        window.location.href = "deleteMatricula.jsp?id_mat=" + id_mat
    }
}
