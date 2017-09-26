'use strict';
var view_3_Controller = angular.module('view_3.Controller', ['ngRoute']);
view_3_Controller.controller('view_3_Controller', ['$scope', '$http', '$routeParams', '$log', function ($scope, $http, $routeParams, $log) {
    $scope.type = [];
    $scope.blog = [];
    $scope.page = 1;
    $scope.nowType = "all";
    var page = $routeParams['page'] ? $routeParams['page'] : 1;
    var n_type = $routeParams['type'];
    if (parseInt(page) < 1) {
        page = 1;
    }
    $scope.page = (parseInt(page));
    var url = '/getBlogData?page=' + (parseInt(page) - 1);
    if (n_type !== "all") {
        $scope.nowType = n_type;
        url = '/getBlogEntityByType?type=' + n_type + '&page=' + page;
    }
    $http.get('/getBlogTypeData').then(function (response) {
        if (response.status === 200) {
            $scope.type = response.data;
        } else {
            $log.error("view_3_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
        }
    }, function (err) {
        $log.error(err);
    });

    $http.get(url).then(function (response) {
        if (response.status === 200) {
            $scope.first = response.data.first;
            $scope.last = response.data.last;
            $scope.totalPages = response.data.totalPages;
            $scope.blog = response.data.content;
        } else {
            $log.error("view_3_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
        }
    }, function (err) {
        $log.error(err);
    });
}]);