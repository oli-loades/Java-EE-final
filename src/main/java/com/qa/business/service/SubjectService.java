package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Subject;

import com.qa.persistence.repository.SubjectDBRepository;

public class SubjectService {
	
	private static final Logger LOGGER = Logger.getLogger(SubjectService.class);

	@Inject
	private SubjectDBRepository repo;

	public SubjectService() {

	}

	public String getAllSubjects() {
		LOGGER.info("subject service get all subjects");
		return repo.getAllSubjects();
	}

	public Subject getSubject(long id) {
		LOGGER.info("subject service get subject");
		return repo.findSubject(id);
	}

	public String createSubject(String subject) {
		LOGGER.info("subject service create subject");
		return repo.createSubject(subject);
	}

	public String deleteSubject(long id) {
		LOGGER.info("subject service delete subject");
		return repo.deleteSubject(id);
	}

	public String updateSubject(long id, String subject) {
		LOGGER.info("subject service update subject");
		return repo.updateSubject(subject, id);
	}
}
