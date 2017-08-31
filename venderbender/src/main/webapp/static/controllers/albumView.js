angular.module("VenderBender").controller("albumViewController",function($rootScope,$http,$scope){
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
	$scope.numPerPage = 5;
	$scope.maxSize = 5;
	$scope.$watch('currentPage + numPerPage', function() {
	    var begin = (($scope.currentPage - 1) * $scope.numPerPage);
	    var end = begin + $scope.numPerPage;
	    $scope.filteredAlbums = $scope.albums.slice(begin, end);
	  });
	  $scope.addToCart = function(item,isAlbum) {
		  AddItemToCart(item,isAlbum,$rootScope);
		};
});

AddItemToCart = function(item,isAlbum,$rootScope,$http)
{
	
	var orderItem = {
			id:-1,
			album : null,
			concert:null,
			quantity:1,
			owner:null
		};
		if(isAlbum)
		{
			orderItem.album = item;					
		}
		else
		{
			orderItem.concert = item;
		}
	
	http.post("/cart/add", orderItem).then(function(response) {
		$rootScope.cartOrder = response.data;
	});
	/*//addItem method(item) and check for similarity
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
			}*/
	
}
/*
 * I need to re write these $(document).ready(function() {
 * $('#list').click(function(event){event.preventDefault();$('#products
 * .item').addClass('list-group-item');});
 * $('#grid').click(function(event){event.preventDefault();$('#products
 * .item').removeClass('list-group-item');$('#products
 * .item').addClass('grid-group-item');}); });
 */