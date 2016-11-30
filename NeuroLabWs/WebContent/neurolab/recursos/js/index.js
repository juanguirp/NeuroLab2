/**
 * 
 */

var modulo = angular.module('loginUsuarios', ["ngRoute", "ngCookies"]);

modulo.service('logearUsuario', function($http) {
	
	this.validarUsuario = function(id, contrasena) {
		
		return $http({
			method: GET,
			url: 'http://localhost:8080/NeuroLabWs/rest/ServicioInvestigador/validarUsuario' + '/' + id + '/' + contrasena
		});
	}
	
});

modulo.controller('formularioLogin', function($scope, $location, $cookies, logearUsuario){
	
	$scope.validarUsuario = function() {
		logearUsuario.validarUsuario($scope.nombreUsuario, $scope.contrasenaUsuario).then(function successCallback(response){
			alert("-----------------");
			if(response.data != ''){
				
				$scope.nombreUsuario = "";
				$scope.contrasenaUsuario = "";
				return;						
			}else{
				alert("Datos correctos");
				$cookies.id = $scope.nombreUsuario;
				//$location.url("/solicitud");
			}
			
		}, function errorCallback(response) {
		    alert(response.data);
		  });	
	}
	
});