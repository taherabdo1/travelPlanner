angular.module('myApp.users', [ 'ngRoute' ])

.controller(
		'UsersCtrl',
		function($scope, $rootScope, $location, $location, $http, $log) {

			$scope.users = [];
			$scope.getAllUsers = function() {
				$http.get("http://localhost:8080/getAllUsersForAdmin").success(
						function(response) {
							$scope.users = response;
							$log.log($scope.users);

						}).error(function(error, status) {
					$log.log("error");
				});
			};
			// load all offers on page load
			$scope.getAllUsers();

		});
