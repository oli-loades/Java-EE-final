package com.qa.controller.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.SubjectService;

@RunWith(MockitoJUnitRunner.class)
public class SubjectControllerTest {
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private SubjectController endpoint;

	@Mock
	private SubjectService service;

	@Before
	public void setup() {
		endpoint.setSubjectServ(service);
	}

	@Test
	public void testGetAllSubject() {
		Mockito.when(service.getAllSubjects()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllSubjects());
	}

	@Test
	public void testCreateSubject() {
		Mockito.when(service.createSubject(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createSubject(MOCK_VALUE2));
		Mockito.verify(service).createSubject(MOCK_VALUE2);
	}

	@Test
	public void testUpdateSubject() {
		Mockito.when(service.updateSubject(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.updateSubject(1L, MOCK_VALUE2));
		Mockito.verify(service).updateSubject(1L, MOCK_VALUE2);
	}

	@Test
	public void testDeleteSubject() {
		Mockito.when(service.deleteSubject(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteSubject(1L));
		Mockito.verify(service).deleteSubject(1L);
	}
}
