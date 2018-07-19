package com.qa.controller.rest;

import javax.inject.Inject;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Trainee;
import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeController {

	@Inject
	private TraineeService traineeServ;
	
	private static final Logger LOGGER = Logger.getLogger(TraineeController.class);

	public TraineeController() {

	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		LOGGER.info("trainee controller get all trainee");
		return traineeServ.getAllTrainees();
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public Trainee findTrainee(@PathParam("id") Long id) {
		LOGGER.info("trainee controller find trainee");
		return traineeServ.getTrainee(id);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id, String trainee) {
		LOGGER.info("trainee controller update trainee");
		return traineeServ.updateTrainee(id, trainee);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		LOGGER.info("trainee controller delete trainee");
		return traineeServ.deleteTrainee(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		LOGGER.info("trainee controller create new trainee");
		return traineeServ.createTrainee(trainee);
	}

}
