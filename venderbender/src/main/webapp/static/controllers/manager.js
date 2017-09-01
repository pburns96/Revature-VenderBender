angular.module("VenderBender").controller("managerController",function($rootScope, $scope, $http, $location){
	$http({
		method: "GET", url: "validationManagerCheck.do"
	}).then(function(response) {
		$scope.user = response.data
		$rootScope.isManager = response.data.manager;
		$rootScope.isCustomer = !response.data.manager;

		$rootScope.notLoggedIn = false;
		$rootScope.loggedIn = true;
		
	}, function(response) {
		$location.path("/login");
	});
	
	$http({
		method: "GET", url: "getOrderCount.do"
	}).then(function(response) {
		$scope.orderCount = response.data;
	});
});