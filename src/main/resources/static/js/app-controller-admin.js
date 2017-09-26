'use strict';
var controller = angular.module('admin.Controller', ['ngRoute']);
controller.controller('classController', ['$scope', '$location', function ($scope, $location) {
    $scope.$location = $location;
}]);