package com.project.leavenotes.application.to.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.leavenotes.application.model.Notes;
import com.project.leavenotes.application.to.Note;

public class NotesMapper{

	public static Note mapNote(Notes note) {
		return new Note(note.getNoteId(),note.getTitle(),note.getBody(),note.getEntryDate());
	}
	
	public static Notes mapNoteModel(Note note) {
		return new Notes(note.getNoteId(),note.getTitle(),note.getBody(),new Date());
	}
	
	public static List<Note> mapNotes(List<Notes> notes) {
		List<Note> noteList = new ArrayList<Note>();
		for (Notes note : notes) {
			noteList.add(mapNote(note));
		}
		return noteList;
	}
}
