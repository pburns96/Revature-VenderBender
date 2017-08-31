/**
 * 
 */
angular.module("VenderBender").controller("ordersController",function($scope,$http){
	
	$http.get("getAllOrders.do").then(function(response) {
		console.log(response.data);
		$scope.orders = response.data;
	});
	
	$('#myModal').on('shown.bs.modal', function () {
		  console.log("MODAL")
		  $('#myInput').focus()
		})
	
		$scope.getOrder = function(order){
		$modalOrder = order.orderItems;
		console.log($modalOrder);
		//var url = "getOrder?id:" +order.id;
		//$http({
		//	url:"getOrder",
		//	param: {id:order.id}
		//}).then(function(response) {
		//	$modalOrder = response.data;
		//});
	};
})