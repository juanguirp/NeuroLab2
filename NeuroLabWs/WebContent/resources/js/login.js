var appLogin = angular.module("Login", ["ngRoute", "ngCookies"]);

appLogin.service('Investigador', function($http){
	
	this.validar = function(id, contrasena){
		alert("aqui1");
		return $http({
			method: 'GET',
			url: 'http://localhost:8080/NeuroLabWs/rest/ServicioInvestigador/validarUsuario' + '/' + id + '/' +contrasena
			/*params:{
				nombre: id,
				contrasena: contrasena
			}*/
		});
	};
	
});

appLogin.service('Usuario', function($http){
	alert("aqui2");
	this.validarA = function(id, contrasena){
		
		return $http({
			method: 'GET',
			url: 'http://localhost:8080/NeuroLabWs/rest/ServicioAdministrador/'+ id +'/' +contrasena
			/*params:{
				nombre: usuario,
				contrasena: contrasena
			}*/
		});
	};
	
});


appLogin.config(['$routeProvider', function($routeProvider){

	$routeProvider.when('/logininv',{
		
		templateUrl: 'login.html',
		controller: 'contLogin'
	});
	$routeProvider.when('/loginadmin',{
		
		templateUrl: 'adminLogin.html',
		controller: 'contLogin'
	});
	
}]);

appLogin.controller("contLogin", function($scope, $location, $cookies, Investigador){
	
	$scope.id= "";
	$scope.contrasena= "";
	alert("aqui3");
	$scope.validar = function(){
		
		Investigador.validar($scope.id, 
				$scope.contrasena).then(function successCallback(response) {
					if(response.data != ''){
						alert(response.data);
						$scope.id = "";
						$scope.contrasena = "";
						return;						
					}else{
						alert("Datos correctos");
						$cookies.id = $scope.id;
						//$location.url("/solicitud");
					}
				  }, function errorCallback(response) {
				    alert(response.data);
				  });				
	};
});