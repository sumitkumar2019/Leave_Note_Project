package com.project.leavenotes.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leavenotes.application.model.Notes;

/**
 * @author sumit
 * 
 *         All Implementation provided by default by JPA Repository
 */

@Repository
public interface NotesDao extends JpaRepository<Notes, Long>{

}
