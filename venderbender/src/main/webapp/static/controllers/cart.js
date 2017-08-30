angular.module("VenderBender").controller("cartController", function($http, $scope,$rootScope) {
	
	$buyOrder = $http.post("/createOrder", cart.order).then(function(resp) {
		
		//send user back to the shop
		//empty car order
	})
})