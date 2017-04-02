angular.module('myApp.offers', [ 'ngRoute' ])

.controller(
		'OffersCtrl',
		function($scope, $rootScope, $location, $location, $http, $log) {

			$scope.offers = [];
			$scope.checkboxModel = {
				MAIL : false,
				PDF : false
			};
			$scope.getAllOffers = function() {
				$http.get("http://localhost:8080/getAllOffers").success(
						function(response) {
							$scope.offers = response;
							$log.log($scope.offers);

						}).error(function(error, status) {
					$log.log("error");
				});
			};
			// load all offers on page load
			$scope.getAllOffers();

			$scope.buyTicket = function(index) {
				$log.log(index);
				var offerToBuy = $scope.offers[index];
				$log.log(offerToBuy.route.from);
				var route = {
					"from" : $scope.offers[index].route.from,
					"to" : $scope.offers[index].route.to
				};
				var data;
				if ($scope.checkboxModel.MAIL) {
					data = {
						"accountId" : "",
						"sendByMail" : true,
						"amount" : 1,
						"route" : route
					};

				} else {
					data = {
						"accountId" : "",
						"sendByMail" : false,
						"amount" : 1,
						"route" : route
					};

				}
				$http.post("http://localhost:8080/buyTicket", data).success(
						function(response) {
							if ($scope.checkboxModel.PDF == true) {
								// Default export is a4 paper, portrait, using
								// milimeters for
								// units
								var doc = new jsPDF()
								var ticketDetails = "From: "
										+ response.route.from + " \n To: "
										+ response.route.to + " \n Amount: "
										+ response.amount + " \n Price: "
										+ response.price.amount + " "
										+ response.price.currency
										+ " \n Reserved For User: "
										+ response.user.email
								doc.text(ticketDetails, 10, 10)
								doc.save('ticketDetails.pdf')
							}
							$log.log(response);
						}).error(function(error, status) {
					$log.log("error");
				});
			};

		});
