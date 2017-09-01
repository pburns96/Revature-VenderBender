angular.module("VenderBender").controller("managerController",function($scope, $http, $location){
	$http({
		method: "GET", url: "getOrderCount.do"
	}).then(function(response) {
		$scope.orderCount = response.data;
	});
});