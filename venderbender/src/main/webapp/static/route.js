/**
 * 
 */

angular.module("VenderBender", ["ng-Route"])
angular.module("VenderBender").config(function($locationProvider, $scope){
	locationProvider.hashPrefix("");
	$routeProvider.when("/store", {
		templateUrl:"store.html",
		controller:"storeController"
	}).otherwise(
	{
		templateUrl: "pages/home.html",
		controller: "homeController"
	})
})