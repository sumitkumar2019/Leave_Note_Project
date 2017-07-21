package com.project.leavenotes.application.service;

import java.util.List;

import com.project.leavenotes.application.to.Note;

/**
 * @author sumit
 * 
 *         Note Service methods interface for providing the Services required
 *         for Adding, Editing, displaying Notes
 */

public interface NotesService {

	/**
	 * Return List of All Notes
	 * 
	 * @return
	 */
	public List<Note> listNotes();

	/**
	 * Add a Note
	 * 
	 * @param note
	 */
	public void addNote(Note note);

	/**
	 * Delete a Note using noteId
	 * 
	 * @param noteId
	 */
	public void deleteNote(Long noteId);

	/**
	 * Get Note by Id for Edit purpose
	 * 
	 * @param noteId
	 * @return
	 */
	public Note editNote(Long noteId);

	/**
	 * Update a Note
	 * 
	 * @param note
	 */
	public void updateNote(Note note);
}
