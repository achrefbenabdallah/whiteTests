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
		
		List<String> Mismatch= wtResponse.getCriteriaMismatch();

		
		if((studentRequest.getStudentId()==0)|| (studentRequest.getStudentId()<0)){
			Mismatch.add("Student Id is wrong !");
		}
		if(studentRequest.getExamCode()=="") {
			Mismatch.add("Code Exam is empty!");
		}
		if(Mismatch.isEmpty()) {
			//wtResponse.setStudent(value);
			//wtResponse.setExam(value);
			//wtResponse.setDate(value);
		}
		else
		{
			wtResponse.setIsValid(false);
		}
		
		return wtResponse;
	}
}
