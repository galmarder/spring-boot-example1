angular.module('myApp',  ['restangular'])
.controller('CourseController', function($scope, Restangular) {
  var peopleServices = Restangular.all('people');
  $scope.trainologic = "Trainologic";
  peopleServices.getList().then(function(data) {
    $scope.people = data;
  });
});
