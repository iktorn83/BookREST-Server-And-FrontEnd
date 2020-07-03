(function () {
    'use strict';
    angular
        .module('app')
        .controller('BookController', BookController);

    BookController.$inject = ['$http'];

    function BookController($http) {
        var vm = this;

        vm.books = [];
        vm.getAll = getAll;
        vm.deleteBook = deleteBook;
        vm.addBook = addBook;
        init();

        function init() {
            getAll();
        }

        function getAll() {
            let url = "/books";
            let booksPromise = $http.get(url);
            booksPromise.then(function (response) {
                vm.books = response.data;
            });
        }

        function deleteBook(id) {
            let url = "/books/" + id;
            $http.delete(url).then(function (response) {
                vm.books = response.data;
                getAll();
            });
        }

        function addBook(author, year, title) {
            let url = "/books";
            console.log(author+year+title);

            let data = {
                author: author,
                year: year,
                name: title
            };

            let booksPromise = $http.post(url, JSON.stringify(data));
            booksPromise.then(function (response) {
                vm.books = response.data;
                getAll();
            });
        }
    }
})();