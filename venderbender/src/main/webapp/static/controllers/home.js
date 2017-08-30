//TODO ASK PATRICK
angular.module("VenderBender").controller("homeController",function($scope,$http,$rootScope){
	var items = []
	$rootScope.cart = {
	        total : 0,
	        orders : {
	        	items : {
	        		item: {
	        			id:0,
	        			album : null,
	        			concert:null,
	        			quantity:1
	        		}
	        	}
	        }
	    };
	
	//addItem method(item) and check for similarity
	//Adds item to cart.order.items
	$rootScope.addItem = function(item){
		
		//Check and see if the item already exist
		var exist = false;
		angular.forEach($rootScope.car.order.items, function(listItem, index) {
				//If the item already exist then add to the existing quantity
			  if(listItem.id=item.id)
			  	{
				  exist = true;
				  $rootScope.car.order.items[index].quantity += item.quantity;
				}
			});
		
		if(exist ==false)
			{
		$rootScope.car.order.items.push(item);
			}
	}
	//add all functions for adding orders to cart
	//cart should be tracked throughout switching of controllers
	
	
	//
})