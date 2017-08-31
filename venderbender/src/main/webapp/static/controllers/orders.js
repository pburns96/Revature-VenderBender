/**
 * 
 */
angular.module("VenderBender").controller("ordersController",function($scope,$http){
	
	$http.get("getAllOrders.do").then(function(response) {
		$orderHistory.orders = response.data;
	});
	
	$('#myModal').on('shown.bs.modal', function () {
		  $('#myInput').focus()
		})
	
		$getOrder = function(order){
		var url = "/getOrder?id:" +order.id;
		$http.get(url).then(function(response) {
			$modalOrder = response.data;
		});
	};
})