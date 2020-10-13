<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Ingreso de jugadores</title>
        <LINK REL="StyleSheet" HREF="estilo.css" TYPE="text/css" MEDIA="all" />
    </head>
    <body>

        <div id="stylized" class="myform">
            <form id="form" name="form" method="post" action="add_reg.php">
                <h1>Introduzca datos del jugador</h1>
                <p>Aca debera introducir los datos del nuevo jugador</p>

                <label>Nombre
                    <span class="small">Agrega el nombre</span>
                </label>
                <input type="text" name="name" id="name" />

                <label>Apellido
                    <span class="small">Agrega el apellido</span>
                </label>
                <input type="text" name="lastname" id="name" />

                <label>Posicionn
                    <span class="small">Posicion del jugador</span>
                </label>
                <input type="text" name="position" id="position" />

                <label>Numero 
                    <span class="small">Numero del jugador</span>
                </label>
                <input type="text" name="number" id="number" />

                <button type="submit" name="enviar">Agregar</button>
                <div class="spacer"></div>
            </form>
        </div>
    </body>
</html>

