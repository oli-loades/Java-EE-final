package com.qa.business.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.TraineeDBRepository;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTest {
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private TraineeService service;
	
	@Mock
	private TraineeDBRepository repo;
	
	@Before
	public void setup() {
		service.setRepo(repo);
	}

	@Test
	public void testGetAllTrainee() {
		Mockito.when(repo.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.getAllTrainees());
	}

	@Test
	public void testCreateTrainee() {
		Mockito.when(repo.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.createTrainee(MOCK_VALUE2));
		Mockito.verify(repo).createTrainee(MOCK_VALUE2);
	}

	@Test
	public void testUpdateTrainee() {
		Mockito.when(repo.updateTrainee(MOCK_VALUE2, 1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.updateTrainee(1L, MOCK_VALUE2));
		Mockito.verify(repo).updateTrainee(MOCK_VALUE2, 1L);
	}

	@Test
	public void testDeleteTrainee() {
		Mockito.when(repo.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.deleteTrainee(1L));
		Mockito.verify(repo).deleteTrainee(1L);
	}
}
