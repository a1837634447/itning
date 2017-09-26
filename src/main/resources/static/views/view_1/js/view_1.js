'use strict';
var view_1_Controller = angular.module('view_1.Controller', ['ngRoute']);
view_1_Controller.controller('view_1_Controller', ['$scope', '$http', function ($scope, $http) {
    $scope.carousel = [];
    $scope.blog = [];
    $http.get('/getCarouselData').then(function (response) {
        if (response.status === 200) {
            $scope.carousel = response.data;
        } else {
            $log.error("view_1_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
        }
    }, function (err) {
        $log.error(err);
    });
    $http.get('/getBlogData?size=4').then(function (response) {
        if (response.status === 200) {
            $scope.blog = response.data.content;
        } else {
            $log.error("view_1_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
        }
    }, function (err) {
        $log.error(err);
    });
}]);