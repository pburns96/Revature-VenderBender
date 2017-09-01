/**
 * 
 */
angular.module("VenderBender").controller("ordersController",function($scope,$http){
	
	$http.get("order/all").then(function(response) {
		$scope.orders = response.data;
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