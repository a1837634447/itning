'use strict';
var myController = angular.module('main.Controller', ['ngRoute']);
/*控制器*/
myController.controller('indexFrameWork_Controller', ['$scope', '$http', '$location', '$log', function ($scope, $http, $location, $log) {
    $scope.$location = $location;
    $scope.navbar = [];
    $scope.viewTitle = [];
    $http.get('/getIndexFrameWorkData').then(function (response) {
        if (response.status === 200) {
            $scope.navbar = response.data.navbarList;
            $scope.viewTitle = response.data.viewTitle;
        } else {
            $log.error("indexFrameWork_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
        }
    }, function (err) {
        $log.error(err);
    });
}]);