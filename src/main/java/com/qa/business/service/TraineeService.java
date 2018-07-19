package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeDBRepository;


public class TraineeService {
	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);
	
	@Inject
	private TraineeDBRepository repo;
	
	public TraineeService() {
		
	}
	
	public String getAllTrainees() {
		LOGGER.info("trainee service get all trainees");
		return repo.getAllTrainees();
	}
	
	public Trainee getTrainee(long id) {
		LOGGER.info("trainee service get trainee");
		return repo.findTrainee(id);
	}
	
	public String createTrainee(String trainee) {
		LOGGER.info("trainee service create trainee");
		return repo.createTrainee(trainee);
	}
	
	public String deleteTrainee(long id) {
		LOGGER.info("trainee service delete trainee");
		return repo.deleteTrainee(id);
	}
	
	public String updateTrainee(long id,String trainee) {
		LOGGER.info("trainee service update trainee");
		return repo.updateTrainee(trainee, id);
	}

	public TraineeDBRepository getRepo() {
		return repo;
	}

	public void setRepo(TraineeDBRepository repo) {
		this.repo = repo;
	}
}
