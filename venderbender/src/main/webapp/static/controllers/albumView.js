angular.module("VenderBender").controller("albumViewController",
		function($http, $scope) {
			// Will need the http request here.
			$scope.albums = [];
			$http({
				method : "GET",
				url : "AlbumsAll.do"
			}).then(function(response) {
				$scope.albums = response.data;
				$scope.col1 = [];
				$scope.col2 = [];
				$scope.col3 = [];
				while($scope.albums.length > 0){
					$scope.col1.push($scope.albums.pop());
					if($scope.albums.length > 0){
						$scope.col2.push($scope.albums.pop());
					}else{
						break;
					}
					if($scope.albums.length > 0){
						$scope.col3.push($scope.albums.pop());
					}else{
						break;
					}
				}
			});
			$scope.addToCart = function(item) {
				// TODO PAT:Code for adding item to cart here.
			};
		});
/*
 * I need to re write these $(document).ready(function() {
 * $('#list').click(function(event){event.preventDefault();$('#products
 * .item').addClass('list-group-item');});
 * $('#grid').click(function(event){event.preventDefault();$('#products
 * .item').removeClass('list-group-item');$('#products
 * .item').addClass('grid-group-item');}); });
 */