/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    //Infraestructura
    $(function() {

        document.getElementById("formdata:file-input").onchange = function(e) {
            addImage(e);
        };

        function addImage(e) {
            var file = e.target.files[0],
                    imageType = /image.*/;

            if (!file.type.match(imageType))
                return;

            var reader = new FileReader();
            reader.onload = fileOnload;
            reader.readAsDataURL(file);
        }

        function fileOnload(e) {
            var result = e.target.result;
            document.getElementById("formdata:imgSalida").src = result;
        }
    });

    $('#cargar').click(function() {
        document.getElementById("formdata:file-input").click();
    });

    $('#eliminar').click(function() {
        document.getElementById("formdata:imgSalida").src =  "/TesisAplication/faces/javax.faces.resource/image.png?ln=plugins/images";
        document.getElementById("formdata:file-input").value = "";
    });
    
    //Cultura
    
        $(function() {

        document.getElementById("formCul:file-inputCul").onchange = function(e) {
            addImage(e);
        };

        function addImage(e) {
            var file = e.target.files[0],
                    imageType = /image.*/;

            if (!file.type.match(imageType))
                return;

            var reader = new FileReader();
            reader.onload = fileOnload;
            reader.readAsDataURL(file);
        }

        function fileOnload(e) {
            var result = e.target.result;
            document.getElementById("formCul:imgSalidaCul").src = result;
        }
    });

    $('#cargarCul').click(function() {
        document.getElementById("formCul:file-inputCul").click();
    });

    $('#eliminarCul').click(function() {
        document.getElementById("formCul:imgSalidaCul").src =  "/TesisAplication/faces/javax.faces.resource/image.png?ln=plugins/images";
        document.getElementById("formCul:file-inputCul").value = "";
    });
    
    //Maestrias
    
        $(function() {

        document.getElementById("formMa:file-inputMa").onchange = function(e) {
            addImage(e);
        };

        function addImage(e) {
            var file = e.target.files[0],
                    imageType = /image.*/;

            if (!file.type.match(imageType))
                return;

            var reader = new FileReader();
            reader.onload = fileOnload;
            reader.readAsDataURL(file);
        }

        function fileOnload(e) {
            var result = e.target.result;
            document.getElementById("formMa:imgSalidaMa").src = result;
        }
    });

    $('#cargarMa').click(function() {
        document.getElementById("formMa:file-inputMa").click();
    });

    $('#eliminarMa').click(function() {
        document.getElementById("formMa:imgSalidaMa").src =  "/TesisAplication/faces/javax.faces.resource/image.png?ln=plugins/images";
        document.getElementById("formMa:file-inputMa").value = "";
    });
    
    
    //Planes
    
      $(function() {

        document.getElementById("formPlan:file-inputPlan").onchange = function(e) {
            addImage(e);
        };

        function addImage(e) {
            var file = e.target.files[0],
                    imageType = /image.*/;

            if (!file.type.match(imageType))
                return;

            var reader = new FileReader();
            reader.onload = fileOnload;
            reader.readAsDataURL(file);
        }

        function fileOnload(e) {
            var result = e.target.result;
            document.getElementById("formPlan:imgSalidaPlan").src = result;
        }
    });

    $('#cargarPlan').click(function() {
        document.getElementById("formPlan:file-inputPlan").click();
    });

    $('#eliminarPlan').click(function() {
        document.getElementById("formPlan:imgSalidaPlan").src =  "/TesisAplication/faces/javax.faces.resource/image.png?ln=plugins/images";
        document.getElementById("formPlan:file-inputPlan").value = "";
    });
    
        //Oferta
    
      $(function() {

        document.getElementById("formOfer:file-inputOfer").onchange = function(e) {
            addImage(e);
        };

        function addImage(e) {
            var file = e.target.files[0],
                    imageType = /image.*/;

            if (!file.type.match(imageType))
                return;

            var reader = new FileReader();
            reader.onload = fileOnload;
            reader.readAsDataURL(file);
        }

        function fileOnload(e) {
            var result = e.target.result;
            document.getElementById("formOfer:imgSalidaOfer").src = result;
        }
    });

    $('#cargarOfer').click(function() {
        document.getElementById("formOfer:file-inputOfer").click();
    });

    $('#eliminarOfer').click(function() {
        document.getElementById("formOfer:imgSalidaOfer").src =  "/TesisAplication/faces/javax.faces.resource/image.png?ln=plugins/images";
        document.getElementById("formOfer:file-inputOfer").value = "";
    });
	  		
	  		
});
