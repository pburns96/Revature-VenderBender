angular.module("VenderBender").controller("cartController", function($http, $location, $scope,$rootScope) {
	$http({
		method: "GET", url: "validationOrderCheck.do"
	}).then(function(response) {
		$scope.user = response.data
		$rootScope.isManager = response.data.manager;
		$rootScope.isCustomer = !response.data.manager;

		$rootScope.notLoggedIn = false;
		$rootScope.loggedIn = true;
		
	}, function(response) {
		$location.path("/login");
	});
	
	
	$scope.buyOrder = function(){
		$http.post("order/create", $rootScope.cartOrder).then(function(resp) {
			//empty car order
			$rootScope.cartOrder = resp.data;
	});
	}
	
	$scope.updateOrderItem = function(item){
		$http.post("cart/update", item).then(function(resp) {
			$rootScope.cartOrder = resp.data;
			$scope.itemTotal = CalcTotal($rootScope.cartOrder,$scope,$rootScope,$http,false);
	});
	}
	$scope.removeOrderItem = function(item){
		$http.post("cart/remove", item).then(function(resp) {
			//empty car order
			$rootScope.cartOrder = resp.data;
			$scope.itemTotal = CalcTotal($rootScope.cartOrder,$scope,$rootScope,$http,false);
	});
	}
	
	$scope.itemTotal = CalcTotal($rootScope.cartOrder,$scope,$rootScope,$http,true);
	
})

CalcTotal = function(order,$scope,$rootScope,$http,doGetRequest){
	
	if(doGetRequest ==true)
		{$http.get("cart/get").then(function(response) {
			$rootScope.cartOrder.orderItems
			$rootScope.cartOrder = response.data;
		});}
	let total = 0;
	
	angular.forEach($rootScope.cartOrder.orderItems, function(item, index){
		if(item.concertTicket)
			total = total + item.quantity*item.concertTicket.price;
		if(item.album)
			total = total + item.quantity*item.album.price;
	})
	$scope.cartTotal = total;
}
	