'use strict';
var app = angular.module('itning', ['ngRoute']);

/*路由*/
app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/view_1', {
        controller: 'view_1_Controller',
        templateUrl: 'views/view_1/view_1.html'
    }).when('/view_2', {
        controller: 'view_2_Controller',
        templateUrl: 'views/view_2/view_2.html'
    }).when('/view_3/:type/:page?', {
        controller: 'view_3_Controller',
        templateUrl: 'views/view_3/view_3.html'
    }).when('/view_4', {
        controller: 'view_4_Controller',
        templateUrl: 'views/view_4/view_4.html'
    }).when('/view_5', {
        controller: 'view_5_Controller',
        templateUrl: 'views/view_5/view_5.html'
    }).otherwise({redirectTo: '/view_1'});
}]);
/*/路由*/

/*服务*/
app.service('MainService', [function () {

}]);
/*/服务*/

/*控制器*/
app.controller('indexFrameWork_Controller', ['$scope', '$http', '$location', '$log', function ($scope, $http, $location, $log) {
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
app.controller('view_1_Controller', ['$scope', '$http', function ($scope, $http) {
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
app.controller('view_2_Controller', ['$scope', function ($scope) {

}]);
app.controller('view_3_Controller', ['$scope', '$http', '$routeParams', '$log', function ($scope, $http, $routeParams, $log) {
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
app.controller('view_4_Controller', ['$scope', function ($scope) {

}]);
app.controller('view_5_Controller', ['$scope', function ($scope) {

}]);
/*/控制器*/
