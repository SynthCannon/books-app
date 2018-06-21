"use strict";

(function() {
    var BookController = function (bookService, $log) {

        var vm = this;

        vm.isHidden = false;

        vm.hideTable = function () {
            vm.isHidden = !vm.isHidden
            if(vm.isHidden)
                document.getElementById('hideBtn').innerText = "Show books";
            else
                document.getElementById('hideBtn').innerText = "Hide books";
        };

        function init() {
            bookService.getBooks().then(function (results) {
                vm.books = results;
                $log.log("In the book controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.books));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };

        init();

        vm.delete = function (bookToDelete) {
            bookService.deleteBook(bookToDelete);
            location.reload();
        }


    };

    angular.module('bookApp').controller('bookController', ['bookService','$log', BookController]);
}());