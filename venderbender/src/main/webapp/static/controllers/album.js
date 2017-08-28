angular.module("VenderBender").controller("albumController",function(){
	//Will need the http request here.
	$scope.filteredAlbums = []
	  ,$scope.currentPage = 1
	  ,$scope.numPerPage = 15
	  ,$scope.maxSize = 5;
	  
	  
	  $scope.$watch('currentPage + numPerPage', function() {
	    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
	    , end = begin + $scope.numPerPage;
	    
	    $scope.filteredTodos = $scope.todos.slice(begin, end);
	  });
});