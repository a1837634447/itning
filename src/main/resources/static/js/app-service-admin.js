'use strict';
var service = angular.module('admin.service', []);
/*服务*/
service.service('MainService', [function () {
    var blog = [];
    var delID = -1;
    var delWhat = "";
    this.getblogData = function () {
        return blog;
    };
    this.setblogData = function (blog_) {
        blog = blog_;
    };
    this.setWhatID = function (what, id) {
        delID = id;
        delWhat = what;
    };
    this.getDelWhat = function () {
        return delWhat;
    };
    this.getDelID = function () {
        return delID;
    };

}]);
/*/服务*/