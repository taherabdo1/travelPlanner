'use strict';

// Declare app level module which depends on views, and components
angular.module(
		'myApp',
		[ 'ngRoute', 'myApp.view1', 'myApp.view2', 'myApp.login',
				'myApp.offers', 'myApp.tickets', 'myApp.orders','myApp.users',
				'myApp.signup', 'myApp.version' ]).config(
		[ '$locationProvider', '$routeProvider',
				function($locationProvider, $routeProvider) {
					$locationProvider.hashPrefix('!');

					 $routeProvider.otherwise({
					 redirectTo : '/login'
					 });
				} ]).config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/login', {
		templateUrl : 'login/login.html',
		controller : 'LoginCtrl'
	}).when('/view1', {
		templateUrl : 'view1/view1.html',
		controller : 'View1Ctrl'
	}).when('/view2', {
		templateUrl : 'view2/view2.html',
		controller : 'View2Ctrl'
	}).when('/signup', {
		templateUrl : 'signup/signup.html',
		controller : 'SignupCtrl'
	}).when('/offers', {
		templateUrl : 'offers/offers.html',
		controller : 'OffersCtrl'
	}).when('/tickets', {
		templateUrl : 'tickets/tickets.html',
		controller : 'TicketsCtrl'
	}).when('/orders', {
		templateUrl : 'orders/orders.html',
		controller : 'OrdersCtrl'
	}).when('/users', {
		templateUrl : 'users/users.html',
		controller : 'UsersCtrl'
	})
} ]);
