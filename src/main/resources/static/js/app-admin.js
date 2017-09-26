'use strict';
var app = angular.module('itning_admin', ['admin.service','admin.Controller','blogeditor.Controller','admin.view_3.Controller','ngRoute']);
/*路由*/
app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/blog', {
        controller: 'blog_Controller',
        templateUrl: 'views/admin/blogeditor/blogeditor.html'
    }).when('/view_3', {
        controller: 'view_3_Controller',
        templateUrl: 'views/admin/view_3/view_3.html'
    }).otherwise({redirectTo: '/view_3'});
}]);
/*/路由*/