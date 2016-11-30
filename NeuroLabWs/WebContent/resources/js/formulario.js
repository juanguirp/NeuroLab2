/**
 * 
 */

var modulo = angular.module('formulario', []);

modulo.controller('form', ['$scope', function($scope) {
	
	$scope.lista = 
			[
				{texto: 'Prueba 1', seleccionado:true},
				{texto: 'Prueba 2', seleccionado:false}
			];
	
	
}] );
