
angular.module('student-api-app', ['ngRoute', 'studentApiControllers'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', { templateUrl: 'partial/displayStudents.html', controller: 'DisplayController' })
            .when('/displayStudents', { templateUrl: 'partial/displayStudents.html', controller: 'DisplayController' })
            .when('/addStudent', { templateUrl: 'partial/addStudent.html', controller: 'AddStudentController' })
            .when('/updateStudent/:rollNo', { templateUrl: 'partial/updateStudent.html', controller: 'UpdateStudentController' })
            .when('/deleteStudent/:rollNo', { template: '', controller: 'DeleteStudentController' })

    }])

angular.module('student-api-app')
    .service('dataService', function ($http) {
        var apiUrl = "http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students";

        this.getData = function () {
            return $http.get(apiUrl);
        }


        this.addStudent = function ($student) {
            return $http.post(apiUrl, $student);
        }

        this.deleteStudent = function ($id) {
            return $http.delete(apiUrl + '/' + $id);
        }

        this.fetchSingleStudent = function ($student) {
            return $http.get(apiUrl + "/" + $student);
        }

        this.updateStudent = function ($id, $stud) {
            return $http.put(apiUrl + '/' + $id, $stud);
        }
        return this;

    });

angular.module('student-api-app')
    .service('loginService', function () {
        this.checkLogin = function ($username, $password) {
        
        }
    });

angular.module('studentApiControllers', [])
    .controller('DisplayController', ['$scope', '$log', 'dataService', function ($scope, $log, dataService) {
        $log.info("Inside display controller");
        dataService.getData().then(function (r) {
            $scope.student = r.data;
        })
    }])
    .controller('AddStudentController', ['$scope', '$log', 'dataService', function ($scope, $log, dataService) {
        $log.info("Inside add student controller");
        $scope.stud;
        $scope.submit = function () {
            console.log($scope.stud.isMale);
            dataService.addStudent($scope.stud).then(function (r) {
                $scope.studentAdded = true;
            })
        }

    }])
    .controller('UpdateStudentController', ['$scope', '$log', 'dataService', '$routeParams', function ($scope, $log, dataService, $routeParams) {
        $log.info("Inside update student controller");
        $log.info($routeParams.rollNo);
        dataService.fetchSingleStudent($routeParams.rollNo).then(function (r) {
            $scope.stud = {
                "rollNo": '',
                "name": '',
                "age": '',
                "email": '',
                "date": '',
                "isMale": ''
            }
            $scope.stud.rollNo = r.data.rollNo;
            $scope.stud.name = r.data.name;
            $scope.stud.age = r.data.age;
            $scope.stud.email = r.data.email;
            $scope.stud.date = new Date(r.data.date);
            $scope.stud.isMale = r.data.isMale.toString();
        })

        $scope.update = function () {
            dataService.updateStudent($routeParams.rollNo, $scope.stud).then(function (r) {
                $scope.resetForm();
            })
        }

        $scope.resetForm = function () {
            $scope.stud.rollNo = "";
            $scope.stud.name = "";
            $scope.stud.age = "";
            $scope.stud.email = "";
            $scope.stud.date = "";
            $scope.stud.isMale = "";
        }
    }])
    .controller('DeleteStudentController', ['$scope', '$log', 'dataService', '$routeParams', '$location', function ($scope, $log, dataService, $routeParams, $location) {
        $log.info("Inside delete student controller");
        console.log($routeParams.rollNo);
        dataService.deleteStudent($routeParams.rollNo).then(function (r) {
            $location.path("/");
        })

    }])

    .filter('gender', function () {
        return function (item) {
            if (item == true)
                return "male";
            else
                return "female";
        }
    })

