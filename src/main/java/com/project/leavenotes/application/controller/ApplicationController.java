package com.project.leavenotes.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.leavenotes.application.service.NotesService;
import com.project.leavenotes.application.to.Note;

/**
 * @author sumit
 * 
 *         Configured Rest API based Controller for Add, Edit, List and Delete
 *         note operation
 */

@RestController
@RequestMapping("/api")
public class ApplicationController {


	@Autowired
	private NotesService noteService;

	// -------------------List all Note-------------------------------------------
	
	@RequestMapping(value = "/notes/", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> listAllNotes() {
		List<Note> notes = noteService.listNotes();
		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}
 
    // -------------------Add a Note-------------------------------------------
 
    @RequestMapping(value = "/notes/", method = RequestMethod.POST)
    public ResponseEntity<?> addNote(@RequestBody Note note, UriComponentsBuilder ucBuilder) {
    	noteService.addNote(note);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/notes/{id}").buildAndExpand(note.getNoteId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // -------------------Retrieve Single Note------------------------------------------
    
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getNotes(@PathVariable("id") long noteId) {
        Note note = noteService.editNote(noteId);
        if (note == null) {
            return new ResponseEntity("Note with id " + noteId + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Note>(note, HttpStatus.OK);
    }
    
    
    
    // ------------------- Update a Note ------------------------------------------------
 
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateNote(@PathVariable("id") long noteId, @RequestBody Note note) {
        Note currentNote = noteService.editNote(noteId);
        currentNote.setTitle(note.getTitle());
        currentNote.setBody(note.getBody());
        noteService.updateNote(note);
        return new ResponseEntity<Note>(currentNote, HttpStatus.OK);
    }
 
    // ------------------- Delete a Note-----------------------------------------
 
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNote(@PathVariable("id") long noteId) {
        Note note = noteService.editNote(noteId);
        noteService.deleteNote(noteId);
        return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
    }
 
}
