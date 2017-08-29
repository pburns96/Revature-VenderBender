
angular.module("VenderBender", ["ngRoute"])
angular.module("VenderBender").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
	$routeProvider.when("/store", {
		templateUrl:"store.html",
		controller:"storeController"
	}).when("/albumView", {
		templateUrl:"albumView.html",
		controller:"albumController"
	}).when("/shop", {
		templateUrl:"pages/shop.html",
		controller:"shopController"
	}).when("/concertView", {
		templateUrl:"pages/concertView.html",
		controller:"concertViewController"
	}).otherwise(
	{
		templateUrl: "pages/home.html",
		controller: "homeController"
	})
})