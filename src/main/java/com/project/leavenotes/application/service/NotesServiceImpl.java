package com.project.leavenotes.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leavenotes.application.dao.NotesDao;
import com.project.leavenotes.application.to.Note;
import com.project.leavenotes.application.to.mapper.NotesMapper;

@Service("notesService")
public class NotesServiceImpl implements NotesService{

	@Autowired
    private NotesDao notesDao;
	
	@Override
	public List<Note> listNotes() {
		return NotesMapper.mapNotes(notesDao.findAll());
	}

	@Override
	public void addNote(Note note) {
		notesDao.save(NotesMapper.mapNoteModel(note));		
	}

	@Override
	public void deleteNote(Long noteId) {
		notesDao.delete(noteId);
		
	}

	@Override
	public Note editNote(Long noteId) {
		return NotesMapper.mapNote(notesDao.findOne(noteId));
		
	}

	@Override
	public void updateNote(Note note) {
		notesDao.save(NotesMapper.mapNoteModel(note));
		
	}

}
