angular.module('myApp.orders', [ 'ngRoute' ])

.controller(
		'OrdersCtrl',
		function($scope, $rootScope, $location, $location, $http, $log) {

			$scope.orders = [];
			$scope.getAllOffers = function() {
				$http.get("http://localhost:8080/getAllOrdersForAdmin").success(
						function(response) {
							$scope.orders = response;
							$log.log($scope.offers);

						}).error(function(error, status) {
					$log.log("error");
				});
			};
			// load all orders on page load
			$scope.getAllOffers();

		});
