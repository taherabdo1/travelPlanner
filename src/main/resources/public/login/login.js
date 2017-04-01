'use strict';

angular
		.module('myApp.login', [ 'ngRoute' ])

		.controller(
				'LoginCtrl',
				function($scope, $http, $rootScope, $location) {
					$scope.login = function() {

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
											$location.path("/offers");


										});

					};
				});