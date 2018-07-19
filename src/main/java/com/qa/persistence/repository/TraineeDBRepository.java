package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtility;

@Transactional(SUPPORTS)
public class TraineeDBRepository {

	private static final Logger LOGGER = Logger.getLogger(TraineeDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtility util;
	
	public TraineeDBRepository() {
		
	}
	
	public String getAllTrainees() {
		LOGGER.info("trainee DB repository get all accounts");
		return util.getJSONForObject(em.createQuery("SELECT t FROM Trainee t").getResultList());
	}
	
	public Trainee findTrainee(long id) {
		return em.find(Trainee.class, id);
	}
	
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		LOGGER.info("trainee DB repository create trainee");
		em.persist(util.getObjectForJSON(trainee, Trainee.class));
		return "{\"message\": \"trainee sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(String traineeString, long id) {
		LOGGER.info("trainee DB repository update trainee");
		Trainee updateTrainee = util.getObjectForJSON(traineeString, Trainee.class);
		Trainee trainee = findTrainee(id);
		if (trainee != null) {
			trainee.setFirstName(updateTrainee.getFirstName());
			trainee.setSurname(updateTrainee.getSurname());
			em.merge(trainee);
		}
		return "{\"message\": \"trainee sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(long id) {
		LOGGER.info("trainee DB repository delete trainee");
		Trainee trainee = findTrainee(id);
		if (trainee != null) {
			em.remove(trainee);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public JSONUtility getUtil() {
		return util;
	}

	public void setUtil(JSONUtility util) {
		this.util = util;
	}
}
