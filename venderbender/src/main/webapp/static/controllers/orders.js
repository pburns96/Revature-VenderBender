/**
 * 
 */
angular.module("VenderBeder").controller("ordersController",function($scope,$http){
	
	$http.get("/getAllOrders").then(function(response) {
		$orderHistory.orders = response.data;
	});
	
	$('#myModal').on('shown.bs.modal', function () {
		  $('#myInput').focus()
		})
	
		var url = "/getOrder?id:" +order.id;
		$getOrder = function(order){
		$http.get(url).then(function(response) {
			$modalOrder = response.data;
		});
	};
})