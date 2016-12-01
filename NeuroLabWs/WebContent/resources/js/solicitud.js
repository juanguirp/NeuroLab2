/**
 * 
 */
var solicitud = angular.module('solicitudes', [ 'ngRoute', 'ngCookies' ]);

var servicioLista = "http://localhost:8080/NeuroLabWs/rest/ServicioSolicitudPrestamo/listarSolicitudesPrestamo/";
var servicioGuardarSolicitud = "http://localhost:8080/NeuroLabWs/rest/ServicioPrestamo/registrarPrestamo/";
/**
 * Método para verificación de los datos de entrada del servicio como Json object o un Json array
 */
var toType = function(obj) {
	return ({}).toString.call(obj).match(/\s([a-z|A-Z]+)/)[1].toLowerCase()
}

var solicitudAResponder = '';
/**
 * Determina la navegación entre páginas
 * Conforme a la opción seleccionada en la barra de navegación
 */
solicitud.config([ '$routeProvider', function($routeProvider, $cookies) {
	
	$routeProvider.when('/solicitudes', {
		templateUrl : 'listaSolicitud.html',
		controller : 'listaSolicitudes'
	});
	$routeProvider.when('/enviarSolicitud', {
		templateUrl : 'solicitudes.html',
		controller : 'solicitudCrear'
	});
	$routeProvider.when('/inicioSesion', {
		templateUrl : 'login.html',
		controller : 'iniciarSesion'
	});
	$routeProvider.when('/investigador', {
		templateUrl : 'investigadorCrear.html',
		controller : 'investigador'
	});
} ]);
/**
 * Controlador que se encarga del listado de solicitudes existentes en la base de datos
 * Muestra solo las solicitudes del empleado logueado
 */
solicitud.controller('listaSolicitudes', function($scope, $location,solicitudesService, 
		$cookies, auth) {
	solicitudesService.listaSolicitud().success(function(data) {
		if(toType(data.SolicitudPrestamoWs) == 'array'){
			$scope.solicitudes = data.SolicitudPrestamoWs;
		}else if(toType(data.SolicitudPrestamoWs) == 'object'){
			$scope.solicitudes = [data.SolicitudPrestamoWs];
		}

	});

});
/**
 * Controlador que gestiona las operaciones para la creación de solicitudes
 */
solicitud.controller('solicitudCrear',
		function($scope, $location, solicitudesService) {
			$scope.solicitud = {
				id : '',
				solicitudAsociada : '',
				horaEntrega : new Date(),
				horaDevolucion : '',
				horasSolicitadas : ''
					
            }
/**
 * Función que implementa el guardado de una solicitud
 * Consume los servicios correspondientes
 */
			$scope.guardarSolicitud = function() {
				var today = $scope.solicitud.fecha;
				var dd = today.getDate();
				var mm = today.getMonth() + 1;
				var yyyy = today.getFullYear();
				if (dd < 10) {
					dd = '0' + dd
				}
				if (mm < 10) {
					mm = '0' + mm
				}
				var today = dd + '/' + mm + '/' + yyyy;
				$scope.solicitud.fecha = today;
				solicitudesService.registrarPrestamo($scope.solicitud).success(
						function(data) {
							$location.url('/');
						});
			}
		});
/**
 * Crea la conexión con los servicios existentes en el proyecto 
 * Describe elementos para la creación de solicitudes y para 
 */
solicitud.service('solicitudesService', function($http, $cookies) {
	this.listaSolicitud = function() {
		return $http({
			method : 'GET',
			url : servicioLista + $cookies.nombreUsuario
		});
	}
/**
 * Describe el elemento correspondiente a la creación de una nueva solicitud
 */
	this.registrarPrestamo = function(solicitud) {
		return $http({
			url : servicioGuardarSolicitud + solicitud.id +'/'+ solicitud.solicitudAsociada + '/'+ solicitud.horaEntrega + '/'+ solicitud.horaDevolucion  + '/' +solicitud.horasSolicitadas,
			method : 'POST',
		});
	}
});