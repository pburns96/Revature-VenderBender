angular.module("VenderBender").controller("createConcertsController",function($scope, $http, $location){
	$scope.createConcerts = function(){
		console.log($scope.concert);
		$http({
			method: "POST", url: "createConcerts.do", data: $scope.concert 
		}).then(function(response) {
			$location.path("/home");
		});
	};
});