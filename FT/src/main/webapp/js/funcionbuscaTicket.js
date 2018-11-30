/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function busca() {
    document.location.href = "/ConsultarTicket";
    var url = document.location.href = "/ConsultarTicket";
    if (url.indexOf("Resultado..") > -1) {
        alert("em teste (1)");
    } else {
        alert("em teste (2)");
    }
}