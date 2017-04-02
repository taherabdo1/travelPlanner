'use strict';

angular
		.module('myApp.login', [ 'ngRoute' ])

		.controller(
				'LoginCtrl',
				function($scope, $http, $rootScope, $location, $log) {

					$scope.isLoggedIn = function() {
						if ($rootScope.isAdmin) {
							$location.path("/users");
						} else if ($rootScope.isUser) {
							$location.path("/offers");
						}

					}
					$scope.login = function() {
						$rootScope.isUser = false;
						$rootScope.isAdmin = false;
						var loginData = {
							"username" : btoa($scope.userName),
							"password" : btoa($scope.pasword)
						};
						$http(
								{
									method : 'POST',
									url : 'http://localhost:8080/login',
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded'
									},
									transformRequest : function(obj) {
										var str = [];
										for ( var p in obj)
											str
													.push(encodeURIComponent(p)
															+ "="
															+ encodeURIComponent(obj[p]));
										return str.join("&");
									},
									data : {
										username : $scope.userName,
										password : $scope.pasword
									}
								})
								.success(
										function(response) {

											console.log("200");
											// get the user role from backend
											$http
													.get(
															"http://localhost:8080/getUserRole")
													.success(
															function(response) {
																// $rootScope.userRole
																// =
																// response.role;
																// $log.log($rootScope.userRole);
																if (response.name == "ROLE_USER_ROLE") {
																	$rootScope.isUser = true;
																	$location
																			.path("/offers");
																} else if (response.name == "ROLE_ADMIN_ROLE") {
																	$rootScope.isAdmin = true;
																	$location
																			.path("/users");
																}
															})
													.error(
															function(error,
																	status) {
																$log
																		.log("user not logged in");
															});

										});

					};
					$scope.logout = function() {
						$log.log("inside logout function");
						$http.get("http://localhost:8080/logout").success(
								function(response) {
									$log.log("inside logout success");
									$rootScope.isUser = false;
									$rootScope.isAdmin = false;

									$location.path("/login");
								}).error(function(error, status) {
							$log.log("user not logged in");
						});

					}
					$scope.isLoggedIn();
				});