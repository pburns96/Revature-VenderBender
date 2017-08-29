angular.module("VenderBender").controller("concertViewController",function(){
	//Will need the http request here.
	$scope.filteredConcerts = []
	  ,$scope.currentPage = 1
	  ,$scope.numPerPage = 15
	  ,$scope.maxSize = 5;
	  
	  
	  $scope.$watch('currentPage + numPerPage', function() {
	    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
	    , end = begin + $scope.numPerPage;
	    
	    $scope.filteredConcerts = $scope.concerts.slice(begin, end);
	  });
});