'use strict';
var blogeditor = angular.module('blogeditor.Controller', ['ngRoute']);
blogeditor.controller('blog_Controller', ['$scope', '$http', '$log', '$window', 'MainService', function ($scope, $http, $log, $window, MainService) {
    $scope.title = "";
    $scope.author = "";
    $scope.typeID = "";
    $scope.type = [];
    $scope.md = "";
    //post请求的地址
    var url = "adminApi/saveBlog";
    var id = -1;
    var blog = MainService.getblogData();
    if (blog.length !== 0) {
        $scope.title = blog.aTitle;
        $scope.author = blog.author;
        $scope.typeID = blog.type.id;
        $scope.md = blog.md;
        id = blog.id;
        url = "adminApi/updataBlogByID";
    }
    $http.get('/getBlogTypeData').then(function (response) {
        if (response.status === 200) {
            $scope.type = response.data;
        } else {
            $log.error("addblog_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
        }
    }, function (err) {
        $log.error(err);
    });
    $scope.submit = function () {
        var token = $("meta[name='_csrf']").attr("content");
        var value = angular.element("#md_textarea").val();
        if ($scope.title !== "" && $scope.author !== "" && $scope.typeID !== "" && value !== "") {
            //要通过post传递的参数
            var data = {
                    'id': id,
                    'md': value,
                    'title': $scope.title,
                    'author': $scope.author,
                    'typeID': $scope.typeID
                },
                //将参数传递的方式改成form
                postCfg = {
                    headers: {'Content-Type': 'application/x-www-form-urlencoded', "X-CSRF-TOKEN": token},
                    transformRequest: function (data) {
                        return $.param(data);
                    }
                };
            //发送post请求，获取数据
            $http.post(url, data, postCfg).then(function (reponse) {
                if (reponse.data[0] === "success") {
                    $window.location.reload();
                }
            }, function (err) {
                $log.error(err);
            });
        } else {
            $log.warn("null");
        }
    };
}]);