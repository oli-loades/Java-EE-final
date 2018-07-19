package com.qa.domain.repository;

import javax.persistence.EntityManager;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.SubjectDBRepository;
import com.qa.util.JSONUtility;


@RunWith(MockitoJUnitRunner.class)
public class SubjectDBRepositoryTest {
	
	@InjectMocks
	private SubjectDBRepository repo;

	@Mock
	private EntityManager manager;

	private JSONUtility util;

	private static final String MOCK_OBJECT = "{\"title\":\"JAVA\",\"score\":\"3\",\"trainee_id\":\"1\"}";

	@Before
	public void setup() {
		repo.setEm(manager);
		util = new JSONUtility();
		repo.setUtil(util);
	}


	@Test
	public void testCreateSubject() {
		String reply = repo.createSubject(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"subject sucessfully added\"}");
	}

	@Test
	public void testUpdateSubject() {
		String reply = repo.updateSubject(MOCK_OBJECT, 1L);
		Assert.assertEquals(reply, "{\"message\": \"subject sucessfully updated\"}");
	}

	@Test
	public void testDeleteSubject() {
		String reply = repo.deleteSubject(1L);
		Assert.assertEquals(reply, "{\"message\": \"subject sucessfully deleted\"}");
	}
}
