
function validar(){
     
    var n = document.getElementById('nome');   
    var u = document.getElementById('unidade');   
    var p = document.getElementById('preco');  
    
    if (n.value === '' ){
        alert('O campo nome é obrigatório');
        return false;
    }
    
    if (u.value === '' ){
        alert('O campo unidade é obrigatório');
        return false;
    }
 
    if (p.value <= 0 ||  isNaN(p.value) === true || p.value === '') {  
        alert('O campo preço é obrigatório e deve ser numérico');
        return false;
    }
    
    
    return true;            
 }