package com.project.leavenotes.application.to.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.leavenotes.application.model.Notes;
import com.project.leavenotes.application.to.Note;

/**
 * @author sumit
 * 
 *         NoteMapper purpose is to map all the Entity beans to form object and
 *         vice-versa
 */

public class NotesMapper {

	/**
	 * Mapping Entity to Form Object
	 * 
	 * @param note
	 * @return
	 */
	public static Note mapNote(Notes note) {
		return new Note(note.getNoteId(), note.getTitle(), note.getBody(), note.getEntryDate());
	}

	/**
	 * Mapping Form Object to Entity
	 * 
	 * @param note
	 * @return
	 */
	public static Notes mapNoteModel(Note note) {
		return new Notes(note.getNoteId(), note.getTitle(), note.getBody(), new Date());
	}

	/**
	 * Mapping List of Entity to List of Form object
	 * 
	 * @param notes
	 * @return
	 */
	public static List<Note> mapNotes(List<Notes> notes) {
		List<Note> noteList = new ArrayList<Note>();
		for (Notes note : notes) {
			noteList.add(mapNote(note));
		}
		return noteList;
	}
}
