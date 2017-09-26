'use strict';
var app = angular.module('itning', ['main.Service', 'main.Controller','view_1.Controller','view_2.Controller','view_3.Controller','view_4.Controller','view_5.Controller', 'ngRoute']);
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