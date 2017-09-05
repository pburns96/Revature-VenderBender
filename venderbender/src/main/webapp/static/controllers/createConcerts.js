angular.module("VenderBender").controller("createConcertsController",function($scope, $http, $location){
	$scope.createConcerts = function(){
		$http({
			method: "POST", url: "createConcerts.do", data: $scope.concert 
		}).then(function(response) {
			$location.path("/home");
		});
	};
});