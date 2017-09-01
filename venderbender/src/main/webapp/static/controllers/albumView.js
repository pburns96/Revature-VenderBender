angular.module("VenderBender").controller("albumViewController",
		function($http, $scope, $location, $rootScope, passOver) {
	if(passOver.albums != null && passOver.albums !== undefined){
		$scope.albums = passOver.albums;
		console.log(passOver.albums);
		console.log("Hit the default if statement.");
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
		console.log($scope.col1);
	}
	$scope.concertLook = function($rootScope) {
		$http({
			method : "GET",
			url : "ConcertsAll.do"
		}).then(function(response) {
			passOver.albums = response.data;
			console.log(passOver.albums);
			console.log("Going to switch to concert view");
			$location.path("concertView");
			console.log("Just switched to concert view");
			$scope.albums = passOver.albums;
			$scope.col1 = [];
			$scope.col2 = [];
			$scope.col3 = [];
			while ($scope.albums.length > 0) {
				$scope.col1.push($scope.albums.pop());
				if ($scope.albums.length > 0) {
					$scope.col2.push($scope.albums.pop());
				} else {
					break;
				}
				if ($scope.albums.length > 0) {
					$scope.col3.push($scope.albums.pop());
				} else {
					break;
				}
			}
		});
	};
	$scope.albumLook = function() {
		$http({
			method : "GET",
			url : "AlbumsAll.do"
		}).then(function(response) {
			passOver.albums = response.data;
			console.log("Going to switch to album view");
			$location.path("albumView");
			console.log("Just switched to album view");
			$scope.albums = passOver.albums;
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
			passOver.albums = response.data;
			$location.path("albumView");
			$scope.albums = passOver.albums;
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
			passOver.albums = response.data;
			$location.path("albumView");
			$scope.albums = passOver.albums;
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
			passOver.albums = response.data;
			$location.path("albumView");
			$scope.albums = passOver.albums;
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
	$scope.concertSearch = function() {
		$scope.albums = [];
		$http({
			method : "GET",
			url : "ConcertsByDate.do",
			params : {start: new Date($scope.startDate).getTime(), end: new Date($scope.endDate).getTime()}
		}).then(function(response) {
			passOver.albums = response.data;
			$location.path("concertViewView");
			$scope.albums = passOver.albums;
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