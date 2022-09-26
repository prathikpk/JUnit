package com.Aurionpro.model1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {
	Student st;
	IStudentService service=mock(IStudentService.class);
	
	@BeforeEach
	public void init() {
		st=new Student(service);
	}
	
	@Test
	public void testAverage() {
		when(service.getTotalMarks()).thenReturn(500);
		when(service.getTotalStudents()).thenReturn(10);
		assertEquals(50, st.getAverageMarks());
		
	}
	
}
