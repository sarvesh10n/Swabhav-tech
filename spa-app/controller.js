angular.module('swabhav.controllers',[])
    .controller('HomeController',['$scope','$log',function($scope,$log){
        $log.info("Inside home controller");
        $scope.homeData="Inside home controller";
    }])
    .controller('AboutController',['$scope','$log',function($scope,$log){
        $log.info("Inside about controller");
        $scope.aboutData="Inside about controller";
    }])
    .controller('CareerController',['$scope','$log',function($scope,$log){
        $log.info("Inside career controller");
        $scope.careerData="Inside career controller";
    }])
    