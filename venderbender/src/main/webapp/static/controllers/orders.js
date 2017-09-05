/**
 * 
 */
angular.module("VenderBender").controller("ordersController",function($location, $rootScope, $scope,$http){
	
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
	
	
	$http.get("order/all").then(function(response) {
		$scope.orders = response.data;
		console.log(response.data);
	});

	
	$scope.itemTotal = function(order){
		let total = 0;
		angular.forEach(order.orderItems, function(item, index){
			if(item.concertTicket)
				total = total + item.quantity*item.concertTicket.price;
			if(item.album)
				total = total + item.quantity*item.album.price;
		})
		return total;
	}
})