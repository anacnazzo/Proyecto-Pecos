function nuevoAjax() {
	/*
	 * Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de
	 * este tipo, por lo que se puede copiar tal como esta aqui
	 */
	var xmlhttp = false;
	try {
		// Creacion del objeto AJAX para navegadores no IE
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			// Creacion del objet AJAX para IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			if (!xmlhttp && typeof XMLHttpRequest != 'undefined')
				xmlhttp = new XMLHttpRequest();
		}
	}
	
	return xmlhttp;
}

function buscarEnArray(array, dato) {
	// Retorna el indice de la posicion donde se encuentra el elemento en el
	// array o null si no se encuentra
	var x = 0;
	while (array[x]) {
		if (array[x] == dato)
			return x;
		x++;
	}
	return null;
}

function cargaContenido(nivelSeleccion, listadoSelects, url) {
	
	
	// Obtengo la posicion que ocupa el select que debe ser cargado en el array
	// declarado mas arriba
	var nivelDestino = buscarEnArray(listadoSelects, nivelSeleccion) + 1;
	// Obtengo el select que el usuario modifico
	var selectOrigen = document.getElementById(nivelSeleccion);
	// Obtengo la opcion que el usuario selecciono
	var opcionSeleccionada = selectOrigen.options[selectOrigen.selectedIndex].value;
	// Si el usuario eligio la opcion "Elige", no voy al servidor y pongo los
	// selects siguientes en estado "Selecciona opcion..."
	if (opcionSeleccionada == 0) {
		var x = nivelDestino, selectActual = null;
		// Busco todos los selects siguientes al que inicio el evento onChange y
		// les cambio el estado y deshabilito
		while (listadoSelects[x]) {
			selectActual = document.getElementById(listadoSelects[x]);
			selectActual.length = 0;

			var nuevaOpcion = document.createElement("option");
			nuevaOpcion.value = 0;
			nuevaOpcion.innerHTML = "Seleccione...";
			selectActual.appendChild(nuevaOpcion);
			selectActual.disabled = true;
			x++;
		}
	}
	// Compruebo que el select modificado no sea el ultimo de la cadena
	else if (nivelSeleccion != listadoSelects[listadoSelects.length - 1]) {
		// Obtengo el elemento del select que debo cargar
		var idSelectDestino = listadoSelects[nivelDestino];
		var selectDestino = document.getElementById(idSelectDestino);
		// Creo el nuevo objeto AJAX y envio al servidor el ID del select a
		// cargar y la opcion seleccionada del select origen
		var ajax = nuevoAjax();
		ajax.open("GET", url + "?select=" + idSelectDestino + "&opcion="
				+ opcionSeleccionada, true);
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 1) {
				// Mientras carga elimino la opcion "Selecciona Opcion..." y
				// pongo una que dice "Cargando..."
				selectDestino.length = 0;
				var nuevaOpcion = document.createElement("option");
				nuevaOpcion.value = 0;
				nuevaOpcion.innerHTML = "Cargando...";
				selectDestino.appendChild(nuevaOpcion);
				selectDestino.disabled = true;
			}
			if (ajax.readyState == 4) {

					selectDestino.innerHTML = ajax.responseText;
					
					selectDestino.disabled = false;
					selectDestino.focus();
					selectDestino.onchange();				
			}
		};
		ajax.send(null);
	}
}

function changeInputType(oldObject, oClass, oType) {
	  var newObject = document.createElement(oClass);
	  newObject.type = oType;
	  if(oldObject.size) newObject.size = oldObject.size;
	  if(oldObject.value) newObject.value = oldObject.value;
	  if(oldObject.name) newObject.name = oldObject.name;
	  if(oldObject.id) newObject.id = oldObject.id;
	  if(oldObject.className) newObject.className = oldObject.className;
	  oldObject.parentNode.replaceChild(newObject,oldObject);
	  return newObject;
	}

function buscarPersona(url, id, idTabla)
{
		var valor = document.getElementById(id).value;
		var tabla = document.getElementById(idTabla);
		
		// Creo el nuevo objeto AJAX y envio al servidor el valor
		var ajax=nuevoAjax();
		ajax.open("GET", url + "?valor=" + valor, true);
		ajax.onreadystatechange=function() 
		{ 
			if (ajax.readyState==1)
			{
				// Mientras carga dehabilito el boton aceptar"
				document.body.style.cursor = 'wait';
			}
			
			if (ajax.readyState==4)
			{
				tabla.innerHTML=ajax.responseText;
				document.body.style.cursor = 'auto';
			} 
		};
		ajax.send();
}

function buscarPersonaPorId(id, idDestino)
{
	
		// Creo el nuevo objeto AJAX y envio al servidor el valor
		var ajax=nuevoAjax();
		ajax.open("GET", "buscarPersonaPorId.do" + "?id=" + id , true);
		ajax.onreadystatechange=function() 
		{ 
			if (ajax.readyState==1)
			{
				// Mientras carga dehabilito el boton aceptar"
				document.body.style.cursor = 'wait';	
			}
			
			if (ajax.readyState==4)
			{
				document.getElementById(idDestino).value=ajax.responseText;
				document.body.style.cursor = 'auto';

			} 
		};
		ajax.send();
}



