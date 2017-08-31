angular.module("VenderBender").controller("albumViewController",
		function($http, $scope) {
			$scope.concertLook = function() {
				$scope.albums = [];
				$http({
					method : "GET",
					url : "ConcertsAll.do"
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

			};
			$scope.albumLook = function() {
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
				
			};
			$scope.cdLook = function() {
				$scope.albums = [];
				$http({
					method : "GET",
					url : "AlbumsByType.do",
					params :{type: 0}
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
				
			};
			$scope.lpLook = function() {
				$scope.albums = [];
				$http({
					method : "GET",
					url : "AlbumsByType.do",
					params :{type: 1}
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
				
			};
			$scope.addToCart = function(item) {
				// TODO PAT:Code for adding item to cart here.
			};
		});