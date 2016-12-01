/**
 * 
 * Clase usada para administración de recursos de los investigador en las vistas
 */
var app = angular.module('solicitudes');

var servicioGuardarinvestigador = "http://localhost:8080/NeuroLabWs/rest/ServicioInvestigador/registrarInvestigador/";
/**
 * Lista los investigador consumiendo el servicio correspondiente
 * Genera una respuesta con una lista para mostrarla en la vista
 */

/**
 * Guarda un nuevo investigador en la base de datos consumiedo los servicios correspondientes
 */
app.controller('investigador', function($scope, $location, investigador) {
	$scope.investigador = {
		id : '',
		nombre : '',
        apellidos: '',
		correo : '',
        contrasena: ''

	}
	$scope.guardar = function() {
		investigador.guardar($scope.investigador).success(function(data) {
			$location.url('/');
		});
	}
});
/**
 * Lista los investigador obteniéndolos de la base de datos
 */
app.service('investigador', function($http) {

	this.guardar = function(investigador) {
		return $http({
			url : servicioGuardarinvestigador + investigador.id+ '/' + investigador.nombre + '/' + investigador.correo + '/' + investigador.contrasena,
			method : 'POST'

		});
	}
});