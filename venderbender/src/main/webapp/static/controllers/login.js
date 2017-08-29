angular.module("VenderBender").controller("loginController",function($scope, $http, $location){
	$scope.login = function(){
		console.log($scope.customer);
		$http({
			method: "POST", url: "login.do", data: $scope.customer 
		}).then(function(response) {
			console.log(response.data);
			$location.path("/home");
		});
	};
});