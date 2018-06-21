
angular.module('student-api-app', ['ngRoute', 'studentApiControllers'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', { templateUrl: 'partial/displayStudents.html', controller: 'DisplayController' })
            .when('/displayStudents', { templateUrl: 'partial/displayStudents.html', controller: 'DisplayController' })
            .when('/addStudent', { templateUrl: 'partial/addStudent.html', controller: 'AddStudentController' })
            .when('/updateStudent/:rollNo', { templateUrl: 'partial/updateStudent.html', controller: 'UpdateStudentController' })
            .when('/deleteStudent/:rollNo', { template: '', controller: 'DeleteStudentController' })
            .when('/login', { templateUrl: 'partial/login.html', controller: 'LoginController' })

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
        var registeredUser = {
            "sachin": "sachin@123",
            "sarvesh": "123"
        }
        var path = "";

        this.isLogged = function () {
            if (localStorage.getItem("userName") == null)
                return false;
            else
                return true;
        }

        this.checkLogin = function ($username, $password) {
            if (registeredUser[$username] == $password)
                return true;
            return false;
        }

        this.setUser = function ($username) {
            localStorage.setItem("userName", $username);
        }
        this.getCurrentUser = function () {
            return localStorage.getItem("userName");
        }

        this.setRedirectPath = function ($path) {
            path = $path;
        }

        this.getRedirectPath = function () {
            return path;
        }
        this.setCredentials = function ($id, $password) {
            credential = {
                "id": $id,
                "password": $password
            }
            localStorage.setItem("credential", JSON.stringify(credential));
        }

        this.getCredentials = function () {
            return JSON.parse(localStorage.getItem("credential"));
        }
        this.setRemember = function ($value) {
            localStorage.setItem("isRemember", $value);
        }

        this.isRemember = function () {
            if (localStorage.getItem("isRemember")=="true")
                return true;
            else
                return false;

        }
    });

angular.module('studentApiControllers', [])
    .controller('DisplayController', ['$scope', '$log', 'dataService', 'loginService', function ($scope, $log, dataService, loginService) {

        $log.info("Inside display controller");
        dataService.getData().then(function (r) {
            $scope.student = r.data;
        })

        if (loginService.isLogged()) {
            console.log(loginService.getCurrentUser());
            $scope.userName = loginService.getCurrentUser();
            $scope.logoutButton = true;
        }
    }])
    .controller('AddStudentController', ['$scope', '$log', '$location', 'loginService', 'dataService', function ($scope, $log, $location, loginService, dataService) {
        $log.info("Inside add student controller");
        loginService.setRedirectPath($location.path());
        if (loginService.isLogged()) {
            $scope.stud;
            $scope.submit = function () {
                console.log($scope.stud.isMale);
                dataService.addStudent($scope.stud).then(function (r) {
                    $scope.studentAdded = true;
                })
            }

        }
        else {
            $location.path("/login");
        }
    }])
    .controller('UpdateStudentController', ['$scope', '$log', 'dataService', '$routeParams', '$location', 'loginService', function ($scope, $log, dataService, $routeParams, $location, loginService) {
        $log.info("Inside update student controller");
        loginService.setRedirectPath($location.path());
        if (loginService.isLogged()) {
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
        }
        else {
            $location.path("/login");
        }
    }])
    .controller('DeleteStudentController', ['$scope', '$log', 'dataService', '$routeParams', '$location', 'loginService', function ($scope, $log, dataService, $routeParams, $location, loginService) {
        $log.info("Inside delete student controller");
        loginService.setRedirectPath($location.path());
        if (loginService.isLogged()) {
            console.log($routeParams.rollNo);
            if (confirm("are you sure you want to delete " + $routeParams.rollNo))
                dataService.deleteStudent($routeParams.rollNo).then(function (r) {
                    $location.path("/");
                })
            $location.path("/");
        }
        else
            $location.path("/login");

    }])
    .controller('LoginController', ['$scope', '$log', 'loginService', '$location','$rootScope', function ($scope, $log, loginService, $location,$rootScope) {
        $log.info("inside login controller");
        $rootScope.viewLogin=false;
        if (loginService.isRemember()) {
            console.log("inside remember me");
            $scope.loggedIn = true;
            credential = loginService.getCredentials();
            $scope.id = credential["id"];
            $scope.password = credential["password"];
        }
        else
            $scope.loggedIn = false;
        $scope.check = function () {
            if (loginService.checkLogin($scope.id, $scope.password)) {

                loginService.setUser($scope.id);
                loginService.setCredentials($scope.id, $scope.password);
                console.log(loginService.getRedirectPath());
                console.log(loginService.getCurrentUser());
                $location.path(loginService.getRedirectPath());
                loginService.setRemember($scope.loggedIn);
                
                $rootScope.viewLogout=true;

            }
            else{
                
            }
        }
    }])
    
    .run(function($rootScope,loginService,$location){
        $rootScope.login=function(){
            loginService.setRedirectPath($location.path());
            $location.path("/login");
        }
        
        if(loginService.isLogged()){
            $rootScope.viewLogin=false;
            $rootScope.viewLogout=true;
        }
        else
        {
            $rootScope.viewLogin=true;
            $rootScope.viewLogout=false;
        }
        
        $rootScope.logout=function(){
            localStorage.removeItem("userName");
            $rootScope.viewLogout=false;
            $rootScope.user="";
            $location.path("/");
            $rootScope.viewLogin=true;
        }
    })



    .filter('gender', function () {
        return function (item) {
            if (item == true)
                return "male";
            else
                return "female";
        }
    })

