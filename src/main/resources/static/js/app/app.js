var app = angular.module('noteApp',['ui.router','ngStorage']);
 
app.constant('urls', {
	 BASE: 'http://leavenoteapp.herokuapp.com/LeaveNoteApp',
	 NOTE_SERVICE_API : 'http://leavenoteapp.herokuapp.com/LeaveNoteApp/api/notes/'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/listNotes',
                controller:'NoteController',
                controllerAs:'ctrl',
                resolve: {
                    notes: function ($q, NoteService) {
                        console.log('Load all notes');
                        var deferred = $q.defer();
                        NoteService.loadAllNotes().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

