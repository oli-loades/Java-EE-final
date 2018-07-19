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

import com.qa.business.service.SubjectService;
import com.qa.persistence.domain.Subject;

@Path("/subject")
public class SubjectController {
	@Inject
	private SubjectService subjectServ;
	
	private static final Logger LOGGER = Logger.getLogger(SubjectController.class);

	public SubjectController() {

	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllSubjects() {
		LOGGER.info("subject controller get all subjects");
		return subjectServ.getAllSubjects();
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public Subject findSubject(@PathParam("id") Long id) {
		LOGGER.info("subject controller find subject");
		return subjectServ.getSubject(id);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateSubject(@PathParam("id") Long id, String subject) {
		LOGGER.info("subject controller update subject");
		return subjectServ.updateSubject(id, subject);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteSubject(@PathParam("id") Long id) {
		LOGGER.info("subject controller delete subject");
		return subjectServ.deleteSubject(id);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createSubject(String subject) {
		LOGGER.info("subject controller create new subject");
		return subjectServ.createSubject(subject);
	}

	public SubjectService getSubjectServ() {
		return subjectServ;
	}

	public void setSubjectServ(SubjectService subjectServ) {
		this.subjectServ = subjectServ;
	}
}
