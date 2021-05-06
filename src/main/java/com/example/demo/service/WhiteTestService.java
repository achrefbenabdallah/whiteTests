package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Service
public class WhiteTestService {

	public WhiteTestResponse checkWhiteTestStatus(StudentRequest studentRequest) {
		
		WhiteTestResponse wtResponse =new WhiteTestResponse();
		
		//List<Exam>exams=new ArrayList<Exam>();
		
		//List<Student>students=new ArrayList<Student>();
		
		
		return wtResponse;
	}
}
