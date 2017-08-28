/**
 * 
 */

angular.module("VenderBender", ["ngRoute"])
angular.module("VenderBender").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
	$routeProvider.when("/store", {
		templateUrl:"store.html",
		controller:"storeController"
	}).otherwise(
	{
		templateUrl: "pages/home.html",
		controller: "homeController"
	})
})