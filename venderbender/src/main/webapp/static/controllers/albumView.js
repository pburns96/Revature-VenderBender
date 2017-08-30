angular.module("VenderBender").controller("albumViewController",
		function($http, $scope) {
			// Will need the http request here.
			$scope.albums = [];
			$http({
				method : "GET",
				url : "AlbumsAll.do"
			}).then(function(response) {
				$scope.albums = response.data;
				$scope.data = $scope.albums;
				$scope.viewby = 10;
				$scope.totalItems = $scope.data.length;
				$scope.currentPage = 1;
				$scope.itemsPerPage = $scope.viewby;
				$scope.maxSize = 5; // Number of pager buttons to show
				
				$scope.setPage = function(pageNo) {
					$scope.currentPage = pageNo;
				};
				
				$scope.pageChanged = function() {
					console.log('Page changed to: ' + $scope.currentPage);
				};
				
				$scope.setItemsPerPage = function(num) {
					$scope.itemsPerPage = num;
					$scope.currentPage = 1; // reset to first paghe
				};
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