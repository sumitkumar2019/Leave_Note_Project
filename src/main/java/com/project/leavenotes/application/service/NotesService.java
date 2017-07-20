package com.project.leavenotes.application.service;

import java.util.List;

import com.project.leavenotes.application.to.Note;

public interface NotesService {

	public List<Note> listNotes();
	public void addNote(Note note);
	public void deleteNote(Long noteId);
	public Note editNote(Long noteId);
	public void updateNote(Note note);
}
