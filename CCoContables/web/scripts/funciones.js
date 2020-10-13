/*function validarLogin(elemento){
    if(elemento.value  != "" ){
        var dato = elemento.value
    }else{
        alert('ingrese usuario y contraseña')
    }
}*/

function validar(e) {
    tecla = (document.all)?e.keyCode:e.which;
    if (tecla==8) return true;
    patron = /\w/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
} 

function obligatorio(elemento){
    if(elemento.value==""){
        elemento.className='error';
    }
    elemento.className='';
}

function entroEnfoco(elemento){
    elemento.className="enfoco";
}

function salioEnfoco(elemento){
    elemento.className="";
}

function emailValidator(elem){
    var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
    if(elem.value.match(emailExp)){
        return true;
    }else{
        elem.className='error';
        return false;
    }
}

function isAlphabet(elem){
    var alphaExp = /^[a-zA-Z]+$/;
    if(elem.value.match(alphaExp)){
        return true;
    }else{
        return false;
    }
}				