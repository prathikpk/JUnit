package com.Aurionpro.model1;

public class Student {
	IStudentService service;

	public Student(IStudentService service) {
		super();
		this.service = service;
	}

	public int getAverageMarks() {
		return service.getTotalMarks() / service.getTotalStudents();
	}

}
