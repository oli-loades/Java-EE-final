package com.qa.business.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.SubjectDBRepository;

@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private SubjectService service;
	
	@Mock
	private SubjectDBRepository repo;
	
	@Test
	public void getAllSubjects() {
		Mockito.when(repo.getAllSubjects()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.getAllSubjects());
	}
	
	@Test
	public void testCreateSubject() {
		Mockito.when(repo.createSubject(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.createSubject(MOCK_VALUE2));
		Mockito.verify(repo).createSubject(MOCK_VALUE2);
	}

	@Test
	public void testUpdateSubject() {
		Mockito.when(repo.updateSubject(MOCK_VALUE2, 1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.updateSubject(1L, MOCK_VALUE2));
		Mockito.verify(repo).updateSubject(MOCK_VALUE2, 1L);
	}

	@Test
	public void testDeleteSubject() {
		Mockito.when(repo.deleteSubject(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.deleteSubject(1L));
		Mockito.verify(repo).deleteSubject(1L);
	}
}
