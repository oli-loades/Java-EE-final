"use strict";

(function () {


    function TraineeService (traineeDal) {

        var service = this;
        var data = {
            firstName: "Bob",
            surname: "Smells"
        };

        this.getTrainees = function()
        {
            return traineeDal.getTrainees();
        };

        this.setData = function(newData){
            data = newData;
        }

        this.getData = function(){
            return data;
        }

    }

    angular.module("traineeApp").service("traineeService", ['traineeDal', TraineeService]);

}());