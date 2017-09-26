'use strict';
var view_3_Controller = angular.module('admin.view_3.Controller', ['ngRoute']);
view_3_Controller.controller('view_3_Controller', ['$scope', '$http', '$log', 'MainService', '$window', function ($scope, $http, $log, MainService, $window) {
    $scope.type = [];
    $scope.blog = [];
    $scope.typeID = "";
    $scope.newType = "";
    $scope.showID = -1;
    var url = "";
    getBlogType();
    $scope.$watch('typeID', function (now, old) {
        if (now !== "") {
            url = '/getBlogEntityByType?type=' + now + '&size=50';
        } else {
            url = '/getBlogData?size=50';
        }
        getBlogData(url);
    });

    function getBlogType() {
        $http.get('/getBlogTypeData').then(function (response) {
            if (response.status === 200) {
                $scope.type = response.data;
            } else {
                $log.error("view_3_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
            }
        }, function (err) {
            $log.error(err);
        });
    }

    function getBlogData(url) {
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
    }

    function sendRequestAndRefreshView(url) {
        $http.get(url).then(function (response) {
            if (response.status === 200) {
                $scope.newType = "";
                getBlogType();
            } else {
                $log.error("view_3_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
            }
        }, function (err) {
            $log.error(err);
        });
    }

    $scope.updataBlogByID = function (id) {
        for (var i = 0; i < $scope.blog.length; i++) {
            if ($scope.blog[i].id === id) {
                MainService.setblogData($scope.blog[i]);
                $window.location.href = "#!/blog";
            }
        }
    };
    $scope.del = function (what, id) {
        $("#alert").removeClass("hidden");
        MainService.setWhatID(what, id);
    };
    $scope.del_true = function () {
        var what = MainService.getDelWhat();
        var id = MainService.getDelID();
        switch (what) {
            case "blog":
                delBlogByID(id);
                $("#alert").addClass("hidden");
                break;
            case "type":
                deleteType(id);
                $("#alert").addClass("hidden");
                break;
        }
    };

    function delBlogByID(id) {
        $http.get('/adminApi/deleteBlogByID?id=' + id).then(function (response) {
            if (response.status === 200) {
                getBlogData(url);
            } else {
                $log.error("view_3_Controller.$http.get.response.status:" + response.status + "text:" + response.statusText);
            }
        }, function (err) {
            $log.error(err);
        });
    }

    $scope.addType = function () {
        if ($scope.newType !== "") {
            sendRequestAndRefreshView('/adminApi/addType?name=' + $scope.newType);
        }
    };

    function deleteType(id) {
        sendRequestAndRefreshView('/adminApi/deleteTypeByID?id=' + id);
    }

    $scope.updataTypeByID = function (id) {
        var name = $('#' + id).val();
        sendRequestAndRefreshView('/adminApi/updataTypeByID?id=' + id + '&name=' + name);
        $window.location.reload();
    };
    $scope.changeShowID = function (id) {
        $scope.showID = id;
    };
}]);