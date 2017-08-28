
angular.module("VenderBender", ["ngRoute"])
angular.module("VenderBender").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
<<<<<<< HEAD
	$routeProvider.when("/store", {
		templateUrl:"store.html",
		controller:"storeController"
	}).when("/albumView", {
		templateUrl:"albumView.html",
		controller:"albumController"
	}).when("/shop", {
		templateUrl:"pages/shop.html",
		controller:"shopController"
	}).otherwise(
	{
		templateUrl: "pages/home.html",
		controller: "homeController"
	})
})