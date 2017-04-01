angular.module('myApp.offers', [ 'ngRoute' ])

.controller(
		'OffersCtrl',
		function($scope, $rootScope, $location, $location, $http, $log) {

			$scope.offers = [];
			$scope.getAllOffers = function() {
				$http.get("http://localhost:8080/getAllOffers").success(
						function(response) {
							$scope.offers = response;
							$log.log($scope.offers);
							
						}).error(function(error, status) {
					$log.log("error");
				});
			};
			//load all offers on page load
			$scope.getAllOffers();
			
			$scope.buyTicket = function(index) {
				$log.log(index);
				var offerToBuy = $scope.offers[index];
				$log.log(offerToBuy.route.from);
			};

		});
