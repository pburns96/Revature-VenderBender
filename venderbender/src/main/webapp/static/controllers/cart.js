angular.module("VenderBender").controller("cartController", function($http, $scope,$rootScope) {
	
	$buyOrder = function(){
		$http.post("/createOrder", $rootScope.cartOrder).then(function(resp) {
			//empty car order
			$rootScope.cartOrder = resp.data;
	});
	}
	
	$updateOrderItem = function(item){
		$http.post("/cart/update", item).then(function(resp) {
			//send user back to the shop
			//empty car order
			$rootScope.cartOrder = resp.data;
	});
	}
	$removeOrderItem = function(item){
		$http.post("/cart/update", item).then(function(resp) {
			//send user back to the shop
			//empty car order
			$rootScope.cartOrder = resp.data;
	});
	}
		
})