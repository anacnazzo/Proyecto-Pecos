/**
 * 
 *  crea el array con los niveles para los selects dependientes, luego llama 
 *         a cargacontenido (en el archivo acciones_ajax.js)
 *  @param nivelSeleccion me indica en qué select se produjo la accipón 
 *  
 */
function crearContenidoLugar(nivelSeleccion) {
	// Declaro los selects que componen el documento HTML. Su atributo ID debe figurar aqui.
	var listadoSelects = new Array();
	listadoSelects[0] = "paises";
	listadoSelects[1] = "provincias";
	listadoSelects[2] = "localidades";
	listadoSelects[3] = "calles";
	cargaContenido(nivelSeleccion, listadoSelects, 'cambiarProvinciaLocalidad');
}
