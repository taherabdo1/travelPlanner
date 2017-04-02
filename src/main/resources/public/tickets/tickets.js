angular.module('myApp.tickets', [ 'ngRoute' ])

.controller(
		'TicketsCtrl',
		function($scope, $rootScope, $location, $location, $http, $log) {

			$scope.tickets = [];
			$scope.showOffers = function() {
				$location.path("/offers");
			}
			$scope.getAllTickets = function() {

				$http.get("http://localhost:8080/getAllPurchasedTickets")
						.success(function(response) {
							$scope.tickets = response;
							$log.log($scope.tickets);

						}).error(function(error, status) {
							$log.log("error");
						});
			};
			// load all offers on page load
			$scope.getAllTickets();

		});
