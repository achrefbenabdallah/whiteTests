package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Address;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Service
public class WhiteTestService {

	/*public WhiteTestResponse checkWhiteTestStatus(StudentRequest studentRequest) {
		
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
	}*/
	
	public WhiteTestResponse checkWhiteTestStatus(StudentRequest studentRequest) throws DatatypeConfigurationException {
		Boolean testId=false;
		Boolean testCode=false;
		int id=0;
		int code=0;
		List<Student> students = new ArrayList<>() ;
		List<Exam> exams = new ArrayList<>() ;
		for (int i=1; i<11;i++) {
			Student s = new Student();
			s.setId(i);
			s.setName("Student"+i);
			Address a = new Address();
			a.setCity("city"+i);
			a.setPosteCode(1140+i);
			a.setStreet("street"+i);
			s.setAddress(a);
			students.add(s);
		}
		for (int i=1; i<11;i++) {
			Exam e = new Exam();
			e.setCode("exam"+i);
			e.setName("OCA");
			exams.add(e);
		}
		//tester si l'id de studient existe dans la liste ou non 
		for (int i=0;i<students.size();i++) {
			if(students.get(i).getId()==studentRequest.getStudentId()) {
				testId=true;
				id=i;
				break;
			}
		}
		//tester si le code de l'exam existe dans la liste ou non 
		for (int i=0;i<exams.size();i++) {
			if(exams.get(i).getCode().equalsIgnoreCase(studentRequest.getExamCode())) {
				testCode=true;
				code=i;
				break;
			}
		}

		WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
		List<String> mismatchs =whiteTestResponse.getCriteriaMismatch();
		if(studentRequest.getStudentId()==0 || studentRequest.getStudentId()<0 || !(testId)) {
			mismatchs.add("wrong student id");
		}
		if(studentRequest.getExamCode().isEmpty()) {
			mismatchs.add("exam code must be not empty");
		}
		if(!(testCode))
		{
			mismatchs.add("wrong exam code");
		}
		if(mismatchs.isEmpty()) {
			Student student = new Student();
			student.setId(studentRequest.getStudentId());
			student.setName(students.get(id).getName());
			student.setAddress((students.get(id).getAddress()));
			Exam exam = new Exam();
			exam.setCode(studentRequest.getExamCode());
			exam.setName(exams.get(code).getName());
			whiteTestResponse.setStudent(student);
			whiteTestResponse.setExam(exam);
			LocalDateTime localDate = LocalDateTime.now().plusDays(3);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
			whiteTestResponse.setDate(xmlGregorianCalendar);
			whiteTestResponse.setIsValid(true);
			
		}else {
			whiteTestResponse.setIsValid(false);
		}
		return whiteTestResponse;
	}
}
