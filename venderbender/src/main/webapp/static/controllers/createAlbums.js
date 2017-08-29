angular.module("VenderBender").controller("createAlbumsController",function($scope, $http, $location){
	$scope.createAlbums = function(){
		$http({
			method: "POST", url: "createAlbums.do", data: $scope.album 
		}).then(function(response) {
			$location.path(response.headers('newPath'));
		});
	};
});