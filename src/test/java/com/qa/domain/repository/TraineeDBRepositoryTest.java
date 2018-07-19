package com.qa.domain.repository;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtility;

@RunWith(MockitoJUnitRunner.class)
public class TraineeDBRepositoryTest {
	@InjectMocks
	private TraineeDBRepository repo;

	@Mock
	private EntityManager manager;

	private JSONUtility util;

	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"secondName\":\"Doe\"}";

	@Before
	public void setup() {
		repo.setEm(manager);
		util = new JSONUtility();
		repo.setUtil(util);
	}

	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"trainee sucessfully added\"}");
	}

	@Test
	public void testUpdateTrainee() {
		String reply = repo.updateTrainee(MOCK_OBJECT, 1L);
		Assert.assertEquals(reply, "{\"message\": \"trainee sucessfully updated\"}");
	}

	@Test
	public void testDeleteTrainee() {
		String reply = repo.deleteTrainee(1L);
		Assert.assertEquals(reply, "{\"message\": \"trainee sucessfully deleted\"}");
	}
}
