/**
 * 
 */

angular.module("VenderBender", ["ngRoute"])
angular.module("VenderBender").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
	$routeProvider.when("/shop", {
		templateUrl:"pages/shop.html",
		controller:"shopController"
	}).otherwise(
	{
		templateUrl: "pages/home.html",
		controller: "homeController"
	})
})