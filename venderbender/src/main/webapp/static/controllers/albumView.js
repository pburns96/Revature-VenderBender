angular.module("VenderBender").controller("albumViewController",
		function($http, $scope, $location, $rootScope) {
			$scope.concertLook = function() {
				$scope.albums = [];
				$http({
					method : "GET",
					url : "ConcertsAll.do"
				}).then(function(response) {
					$location.path("concertView");
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
					$location.path("albumView");
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
			$scope.artistLook = function(search) {
				$scope.albums = [];
				$http({
					method : "GET",
					url : "AlbumByArtist.do",
					params :{artist: $scope.search}
				}).then(function(response) {
					$location.path("albumView");
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
					$location.path("albumView");
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
					params : {type: 1}
				}).then(function(response) {
					$location.path("albumView");
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
			$scope.concertSearch = function($location) {
				$scope.albums = [];
				$http({
					method : "GET",
					url : "ConcertsByDate.do",
					params : {start: new Date($scope.startDate).getTime(), end: new Date($scope.endDate).getTime()}
				}).then(function(response) {
					$location.path("concertViewView");
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
			$scope.addToCart = function(item,isAlbum){
				AddItemToCart(item,isAlbum,$rootScope,$http);
		};
});

AddItemToCart = function(item,isAlbum,$rootScope,$http)
{
	console.log(item);
	var orderItem = {
			id:-1,
			quantity:1
		};
		if(isAlbum)
		{
			orderItem.album = item;					
		}
		else
		{
			orderItem.concert = item;
		}
		
	console.log(orderItem);
	
	$http.post("cart/add", orderItem).then(function(response) {
		$rootScope.cartOrder = response.data;
		console.log($rootScope.cartOrder.orderItems);
	});
	
}