var loginApp = angular.module('loginModule');

loginApp.controller('loginController', function($scope, $location, $cookies,
		Usuario) {
	$scope.loginUsuario = '';
	$scope.passUsuario = '';
	$scope.validar = function() {
		Usuario.validar($scope.loginUsuario, $scope.passUsuario).success(
				function(data) {
					if (data == '') {
						alert("Iniciando sesion");
						$cookie.loginUsuario = $scope.nombreUsuario;
					} else {
						alert(data);
						$scope.loginUsuario = '';
						$scope.passUsuario = '';
						return;
					}
				});
	}
});

loginApp.service('loginService', function($http) {
	this.validar = function(usuario, pass) {
		return $http({
			url: 'http://localhost:8080/NeuroLabWs/rest/ServicioInvestigador/validarUsuario/' + usuario + '/' + pass,
			method: 'GET'
		})
	}
});