package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Subject;
import com.qa.util.JSONUtility;

@Transactional(SUPPORTS)
public class SubjectDBRepository {
	
	private static final Logger LOGGER = Logger.getLogger(SubjectDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtility util;
	
	public SubjectDBRepository() {
		
	}
	
	public String getAllSubjects() {
		return util.getJSONForObject(em.createQuery("SELECT s FROM Subject s").getResultList());
	}
	
	public Subject findSubject(long id) {
		return em.find(Subject.class, id);
	}
	
	@Transactional(REQUIRED)
	public String createSubject(String subject) {
		LOGGER.info("subject DB repository create subject");
		em.persist(util.getObjectForJSON(subject, Subject.class));
		return "{\"message\": \"subject sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateSubject(String subjectString, long id) {
		LOGGER.info("subject DB repository update subject");
		Subject updateSubject = util.getObjectForJSON(subjectString, Subject.class);
		Subject subject = findSubject(id);
		if (subject != null) {
			subject.setScore(updateSubject.getScore());
			subject.setTitle(updateSubject.getTitle());
			subject.setTraineeId(updateSubject.getTraineeId());
			em.merge(subject);
		}
		return "{\"message\": \"subject sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(long id) {
		LOGGER.info("subject DB repository delete subject");
		Subject subject = findSubject(id);
		if (subject != null) {
			em.remove(subject);
		}
		return "{\"message\": \"subject sucessfully deleted\"}";
	}
	
}
