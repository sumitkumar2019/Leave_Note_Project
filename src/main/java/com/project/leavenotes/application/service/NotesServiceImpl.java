package com.project.leavenotes.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leavenotes.application.dao.NotesDao;
import com.project.leavenotes.application.to.Note;
import com.project.leavenotes.application.to.mapper.NotesMapper;

/**
 * @author sumit
 * 
 *         Note Service methods implementations for providing the Services
 *         required for Adding, Editing, displaying Notes
 */

@Service("notesService")
public class NotesServiceImpl implements NotesService {

	// Auto-wiring DAO classes to use inside service class

	@Autowired
	private NotesDao notesDao;

	/**
	 * Return List of All Notes
	 * 
	 * @return
	 */

	@Override
	public List<Note> listNotes() {
		return NotesMapper.mapNotes(notesDao.findAll());
	}

	/**
	 * Add a Note
	 * 
	 * @param note
	 */

	@Override
	public void addNote(Note note) {
		notesDao.save(NotesMapper.mapNoteModel(note));
	}

	/**
	 * Delete a Note using noteId
	 * 
	 * @param noteId
	 */

	@Override
	public void deleteNote(Long noteId) {
		notesDao.delete(noteId);

	}

	/**
	 * Get Note by Id for Edit purpose
	 * 
	 * @param noteId
	 * @return
	 */

	@Override
	public Note editNote(Long noteId) {
		return NotesMapper.mapNote(notesDao.findOne(noteId));

	}

	/**
	 * Update a Note
	 * 
	 * @param note
	 */

	@Override
	public void updateNote(Note note) {
		notesDao.save(NotesMapper.mapNoteModel(note));

	}

}
