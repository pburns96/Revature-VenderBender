angular.module("VenderBender", ["ngRoute"])
angular.module("VenderBender").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
	$routeProvider.when("/login",{
		templateUrl:"pages/login.html",
		controller:"loginController"
	}).when("/store", {
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
	}).when("/cart",{
		templateUrl:"pages/cart.html",
		controller:"cartController"
	}).when("/createAlbums",{
		templateUrl:"pages/createAlbums.html",
		controller:"createAlbumsController"
	}).when("/createConcerts",{
		templateUrl:"pages/createConcerts.html",
		controller:"createConcertsController"
	}).otherwise(
	{
		templateUrl: "pages/home.html",
		controller: "homeController"
	})
})