angular.module('studentApi', []).controller('studentApiController', function ($scope, dataService) {
    $scope.output = '';
    $scope.getData = function () {
        console.log($scope.inputNumber);
        if ($scope.validInput($scope.inputNumber)) {
            dataService.getData(apiUrl).then(function (r) {
                console.log(r.data);
            })
        }
    }

})

angular.module('numberapi')
    .factory('dataService', function ($http) {
        var apiUrl = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students";
        var obj = {};
        obj.getData = function () {
            return $http.get(apiUrl);
        }
        return obj;
    });

