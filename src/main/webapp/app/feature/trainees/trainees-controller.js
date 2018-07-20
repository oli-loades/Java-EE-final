(function() {

    var TraineesController =  function(traineeService, $log,$state) {

        var vm = this;

        function init() {
            traineeService.getTrainees().then(function (results) {
                vm.trainees = results;
                $log.log("In the account controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.trainees));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        vm.go = function(trainee){
            vm.selected = trainee;
            traineeService.setData(trainee);
            $state.go("subject",{obj: vm.selected } );
        }

        init();

    };

    angular.module('traineeApp').controller('traineesController', ['traineeService', '$log','$state',TraineesController]);
}());