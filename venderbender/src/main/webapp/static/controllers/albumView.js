angular.module("VenderBender").controller("albumViewController",
		function($http, $scope, $location, $rootScope) {
	
	$http.get("isLoggedIn.do").then(function(response) {
		var customer = response.data;
		if(customer.username != null)
		{
			$scope.user = customer
			$rootScope.loggedIn = true;
			$rootScope.notLoggedIn = false;
			$rootScope.isManager = customer.manager;
			$rootScope.isCustomer = !customer.manager;
		}
	})
	
	if($rootScope.albums != null && $rootScope.albums !== undefined){
		if ($rootScope.albums.length > 0) {
			$scope.albums = $rootScope.albums.slice();
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
		}
	}
	$scope.concertLook = function() {
		$http({
			method : "GET",
			url : "ConcertsAll.do"
		}).then(function(response) {
			$rootScope.albums = response.data;
			$location.path("concertView");
			$scope.albums = $rootScope.albums.slice();
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
			$rootScope.albums = response.data;
			$location.path("albumView");
			$scope.albums = $rootScope.albums.slice();
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
			$rootScope.albums = response.data;
			$location.path("albumView");
			$scope.albums = $rootScope.albums.slice();
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
			$rootScope.albums = response.data;
			$location.path("albumView");
			$scope.albums = $rootScope.albums.slice();
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
			$rootScope.albums = response.data;
			$location.path("albumView");
			$scope.albums = $rootScope.albums.slice();
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
			$rootScope.albums = response.data;
			$location.path("concertViewView");
			$scope.albums = $rootScope.albums.slice();
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
		$http({
			method: "GET", url: "validationOrderCheck.do"
		}).then(function(response) {
			$scope.user = response.data
			$rootScope.isManager = response.data.manager;
			$rootScope.isCustomer = !response.data.manager;

			$rootScope.notLoggedIn = false;
			$rootScope.loggedIn = true;
			AddItemToCart(item,isAlbum,$rootScope,$http);
			
		}, function(response) {
			$location.path("/login");
		});
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
			orderItem.concertTicket = item;
		}
		
	console.log(orderItem);
	
	$http.post("cart/add", orderItem).then(function(response) {
		$rootScope.cartOrder = response.data;
		console.log($rootScope.cartOrder.orderItems);
	},function(response){
		console.log(response.data);
	});
	
}