angular.module("VenderBender").controller("albumViewController",function($http,$scope){
	// Will need the http request here.
	$scope.albums = [];
	$http({
		method : "GET",
		url : "AlbumsAll.do"
	}).then(function(response) {
		$scope.albums = response.data;
	});
	$scope.filteredAlbums = [];
	$scope.currentPage = 1;
	$scope.numPerPage = 15;
	$scope.maxSize = 5;
	$scope.$watch('currentPage + numPerPage', function() {
	    var begin = (($scope.currentPage - 1) * $scope.numPerPage);
	    var end = begin + $scope.numPerPage;
	    $scope.filteredAlbums = $scope.albums.slice(begin, end);
	  });
	  $scope.addToCart = function(item) {
			// TODO PAT:Code for adding item to cart here.
		};
});
/*I need to re write these
$(document).ready(function() {
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
});*/