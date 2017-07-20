package com.project.leavenotes.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leavenotes.application.model.Notes;

@Repository
public interface NotesDao extends JpaRepository<Notes, Long>{

}
