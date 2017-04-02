angular
		.module('myApp.signup', [ 'ngRoute' ])

		.controller(
				'SignupCtrl',
				function($scope, $rootScope, $location, $location, $http, $log) {

					$scope.isLoggedIn = function(){
						if ($rootScope.isAdmin) {
							$location.path("/users");
						} else if ($rootScope.isUser) {
							$location.path("/offers");
						}
					};
					$scope.signup = function() {

						signupRequest = {
							"email" : $scope.email,
							"password" : $scope.password,
							"currency" : $scope.currency,
							"role" : "user",
							"accountId" : ""
						};
						$http
								.post("http://localhost:8080/signup",
										signupRequest)
								.success(
										function(response) {
											$scope.successMessage = "User has been created successfully";
											$location.path("/login");
										})
								.error(
										function(error, status) {
											$log.log("error");
											$scope.errorMessage = "Something went wrong";
										});
					};
					$scope.isLoggedIn();
				});
