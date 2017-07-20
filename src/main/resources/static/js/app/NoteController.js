'use strict';
 
angular.module('noteApp').controller('NoteController',
    ['NoteService', '$scope',  function( NoteService, $scope) {
 
    	var self = this;
    	self.notes=[];
        self.submit = submit;
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
    	self.note = {};
    	self.getAllNotes = getAllNotes;
    	self.addNote = addNote;
    	self.updateNote = updateNote;
        self.removeNote = removeNote;
        self.editNote = editNote;
        self.reset = reset;


    	
        function getAllNotes(){
            return NoteService.getAllNotes();
        }
        
        function addNote(note) {
            console.log('About to add note');
            NoteService.addNote(note)
                .then(
                    function (response) {
                        console.log('Note added successfully');
                        self.successMessage = 'Note added successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.note={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while adding Note');
                        self.errorMessage = 'Error while adding Note: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
        
        function updateNote(note, noteId){
            console.log('About to update Note');
            NoteService.updateNote(note, noteId)
                .then(
                    function (response){
                        console.log('Note updated successfully');
                        self.successMessage='Note updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.note={};
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Note');
                        self.errorMessage='Error while updating Note '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
 
 
        function removeNote(noteId){
            console.log('About to remove Note with id '+noteId);
            NoteService.removeNote(noteId)
                .then(
                    function(){
                        console.log('Note '+noteId + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Note '+noteId +', Error :'+errResponse.data);
                    }
                );
        }
        
        function editNote(noteId) {
            self.successMessage='';
            self.errorMessage='';
            NoteService.getNote(noteId).then(
                function (note) {
                    self.note = note;
                },
                function (errResponse) {
                    console.error('Error while removing Note ' + noteId + ', Error :' + errResponse.data);
                }
            );
        }
        
        function submit() {
            console.log('Submitting');
            if (self.note.noteId === undefined || self.note.noteId === null) {
                console.log('Saving New Note', self.note);
                addNote(self.note);
            } else {
                updateNote(self.note, self.note.noteId);
                console.log('Note updated with id ', self.note.noteId);
            }
        }
        
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.note={};
            $scope.myForm.$setPristine(); // reset Form
        }
    }
    
    ]);
