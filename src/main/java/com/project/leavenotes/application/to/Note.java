package com.project.leavenotes.application.to;

import java.util.Date;

public class Note {

	private Long noteId;
	private String title;
	private String body;
	private Date entryDate;

	public Note() {
	}

	public Note(Long noteId, String title, String body, Date entryDate) {
		this.noteId = noteId;
		this.title = title;
		this.body = body;
		this.entryDate = entryDate;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

}
