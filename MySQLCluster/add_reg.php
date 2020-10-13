<?php

// Primero comprobamos que ningÃºn campo estÃ© vacÃ­o y que todos los campos existan.
if(isset($_POST['name']) && !empty($_POST['lastname']) && isset($_POST['position']) && !empty($_POST['number'])) {

	// Si entramos es que todo se ha realizado correctamente

	$link = mysql_connect("localhost","root","admin");
	mysql_select_db("equipo",$link);

	// Con esta sentencia SQL insertaremos los datos en la base de datos
	mysql_query("INSERT INTO eugador (Numero,Nombres,Apellidos,Posicion) VALUES ('{$_POST['number']}','{$_POST['name']}','{$_POST['lastname']}','{$_POST['position']}')",$link);

	// Ahora comprobaremos que todo ha ido correctamente
	$my_error = mysql_error($link);

	if(!empty($my_error)) {

		echo "Ha habido un error al insertar los valores. $my_error";

	} else {

		echo "Los datos han sido introducidos satisfactoriamente";

	}

} else {

	echo "Error, no ha introducido todos los datos";

}

?>
