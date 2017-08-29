angular.module("VenderBender").controller("albumController",function(){
	//Will need the http request here.
	$http({
		method : "GET",
		url : "getAllAlbums.do"
	}).then(function(response) {
		$scope.filteredAlbums = response.data;
		}
	});
	$scope.filteredAlbums = []
	  ,$scope.currentPage = 1
	  ,$scope.numPerPage = 15
	  ,$scope.maxSize = 5;
	  $scope.$watch('currentPage + numPerPage', function() {
	    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
	    , end = begin + $scope.numPerPage;
	    
	    $scope.filteredAlbums = $scope.albums.slice(begin, end);
	  });
	  $scope.addToCart = function(item) {
			//Code for adding item to cart here.
		};
});
$(document).ready(function() {
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
});