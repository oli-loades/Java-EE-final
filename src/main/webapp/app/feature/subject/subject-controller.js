(function() {

    var SubjectController =  function(traineeService, $log,$state) {

        var vm = this;
         vm.trainee = traineeService.getData();

        /*vm.trainee = {
            firstName: "Bob",
            surname: "smells"
        };
        */

        console.log(vm.trainee);

        vm.back = function(){
            $state.go("trainees");
        }

    };

    angular.module('traineeApp').controller('subjectController', ['traineeService', '$log', '$state',SubjectController]);
}());