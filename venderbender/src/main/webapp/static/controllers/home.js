angular.module("VenderBender").controller("homeController",function($rootScope, $scope, $http, $location){
	
	$http.get("isLoggedIn.do").then(function(response) {
		var customer = response.data;
		if(customer.username != null)
		{
			$scope.user = customer
			$rootScope.loggedIn = true;
			$rootScope.notLoggedIn = false;
			$rootScope.isManager = customer.manager;
			$rootScope.isCustomer = customer.manager;
		}
	})
var items = []
	$rootScope.cart = {
	        total : 0,
	        order : {
	        	items : [
	  
	        	]
	        }
	    };
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