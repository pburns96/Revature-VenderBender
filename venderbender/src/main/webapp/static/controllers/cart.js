angular.module("VenderBender").controller("cartController", function($http, $scope,$rootScope) {
	
	console.log($rootScope.cartOrder.orderItems);
	
	$scope.buyOrder = function(){
		$http.post("createOrder", $rootScope.cartOrder).then(function(resp) {
			//empty car order
			$rootScope.cartOrder = resp.data;
	});
	}
	
	$scope.updateOrderItem = function(item){
		$http.post("cart/update", item).then(function(resp) {
			$rootScope.cartOrder = resp.data;
	});
	}
	$scope.removeOrderItem = function(item){
		$http.post("cart/remove", item).then(function(resp) {
			//send user back to the shop
			//empty car order
			$rootScope.cartOrder = resp.data;
	});
	}
		
})