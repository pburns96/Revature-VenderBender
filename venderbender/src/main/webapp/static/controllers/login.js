angular.module("VenderBender").controller("loginController",function($scope, $rootScope, $http, $location){
	
	$scope.login = function(){
		$http({
			method: "POST", url: "login.do", data: $scope.customer 
		}).then(function(response) { 
			if(response.data.username != null){
				$scope.user = response.data
				$rootScope.isManager = response.data.manager;
				$rootScope.isCustomer = !response.data.manager;
	
				$rootScope.notLoggedIn = false;
				$rootScope.loggedIn = true;
				$location.path("/home");
			}
			else{
				$location.path("/login");
			}
		});
	};

});