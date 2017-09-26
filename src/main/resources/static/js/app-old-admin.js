'use strict';
var app = angular.module('itning_admin', ['ngRoute']);

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

/*服务*/
app.service('MainService', [function () {
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

/*控制器*/
app.controller('classController', ['$scope', '$location', function ($scope, $location) {
    $scope.$location = $location;
}]);

app.controller('blog_Controller', ['$scope', '$http', '$log', '$window', 'MainService', function ($scope, $http, $log, $window, MainService) {
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

app.controller('view_3_Controller', ['$scope', '$http', '$log', 'MainService', '$window', function ($scope, $http, $log, MainService, $window) {
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
        $log.log(name);
        sendRequestAndRefreshView('/adminApi/updataTypeByID?id=' + id + '&name=' + name);
        $window.location.reload();
    };
    $scope.changeShowID = function (id) {
        $scope.showID = id;
    };
}]);

/*/控制器*/