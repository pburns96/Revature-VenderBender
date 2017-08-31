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
					params : {type: 1}
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
			$scope.addToCart = function(item,isAlbum){
				AddItemToCart(item,isAlbum,$rootScope);
		};
});

AddItemToCart = function(item,isAlbum,$rootScope)
{
	//addItem method(item) and check for similarity
	//Adds item to cart.order.items
		console.log("Attempting to add to cart!");
		console.log($rootScope.cart.order.items.length)
		
		var orderItem = {
			id:-1,
			album : null,
			concert:null,
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
		//Check and see if the item already exist
		var exist = false;
		if($rootScope.cart.order.items.length > 0)
			{
		angular.forEach($rootScope.cart.order.items, function(listItem, index) {
				//If the item already exist then add to the existing quantity
			if(isAlbum)
			{
			  if(listItem.album.id==orderItem.album.id)
			  	{
				  exist = true;
				  console.log("found already added item! adding to quantity to cart!");
				  $rootScope.cart.order.items[index].quantity += 1;
				}
			}
			else
			{
				if(listItem.concert.id==orderItem.concert.id)
				  {
					  exist = true;
					  console.log("found already added item! adding to quantity to cart!");
					  $rootScope.cart.order.items[index].quantity += 1;
					}
			}
			});
			}
		
		if(exist ==false)
			{
			console.log("added New Item to cart!");
		$rootScope.cart.order.items.push(orderItem);
			}
	
}