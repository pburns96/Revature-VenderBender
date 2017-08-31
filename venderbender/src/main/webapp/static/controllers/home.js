angular.module("VenderBender").controller("homeController",function($rootScope, $scope, $http, $location){
	$rootScope.notLoggedIn = !$rootScope.loggedIn;
	$scope.manager = function(){
		if($rootScope.isManager){
			$location.path('/manager');
		}
	};
	$scope.orders = function(){
		if($rootScope.isCustomer){
			$location.path('/orders');
		}
	}
	
	
	$scope.logout = function(){
		$http({
			method: "GET", url: "logout.do"
		}).then(function(respoe){
			$location.path("/home");
			$rootScope.isManager = false;
			$rootScope.isCustomer = false;
			$rootScope.loggedIn = false;
			$rootScope.notLoggedIn = true;
		});
	};
})