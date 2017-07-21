'use strict';

// services defined using factory &scope not allowed hence used $localstorage
angular.module('noteApp').factory('NoteService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
            		loadAllNotes: loadAllNotes,
            		getAllNotes: getAllNotes,
            		getNote: getNote,
                    addNote: addNote,
                    updateNote: updateNote,
                    removeNote: removeNote
            };
            return factory;
 
            /**
			 * method to List all notes
			 */
            function loadAllNotes() {
                console.log('Fetching all notes');
                var deferred = $q.defer();
                $http.get(urls.NOTE_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all notes');
                            $localStorage.notes = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading notes');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            /**
			 * method to add note
			 */
            function addNote(note) {
                console.log('Adding Note');
                var deferred = $q.defer();
                $http.post(urls.NOTE_SERVICE_API, note)
                    .then(
                        function (response) {
                            loadAllNotes();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while adding Note : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            /**
			 * method to update note after getting using its id
			 */
            function updateNote(note, noteId) {
                console.log('Updating Note with id '+noteId);
                var deferred = $q.defer();
                $http.put(urls.NOTE_SERVICE_API + noteId, note)
                    .then(
                        function (response) {
                            loadAllNotes();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Note with id :'+noteId);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            /**
			 * method to delete a note
			 */
            function removeNote(noteId) {
                console.log('Removing Note with id '+noteId);
                var deferred = $q.defer();
                $http.delete(urls.NOTE_SERVICE_API + noteId)
                    .then(
                        function (response) {
                            loadAllNotes();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Note with id :'+noteId);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            /**
			 * method to get a list of note
			 */
            function getAllNotes(){
                return $localStorage.notes;
            }
            
            /**
			 * method to get a single note
			 */
            function getNote(noteId) {
                console.log('Fetching Note with id :'+noteId);
                var deferred = $q.defer();
                $http.get(urls.NOTE_SERVICE_API + noteId)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Note with id :'+noteId);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Note with id :'+noteId);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
    }
   ]);