package com.project.leavenotes.application.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Notes")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noteId;
	private String title;
	private String body;
	private Date entryDate;

	public Notes() {
	}

	public Notes(Long noteId, String title, String body, Date entryDate) {
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

	@Override
	public String toString() {
		return "Notes [noteId=" + noteId + ", title=" + title + ", body=" + body + ", entryDate=" + entryDate + "]";
	}

}