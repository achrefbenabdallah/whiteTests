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
	
	/*public WhiteTestResponse checkWhiteTestStatus(StudentRequest studentRequest) throws DatatypeConfigurationException {
		Boolean testId=false;
		Boolean testCode=false;
		int id=0;
		int code=0;
		List<Student> students = new Student().getAllStudents() ;
		List<Exam> exams = new Exam().getAllExams() ;
		/*for (int i=1; i<11;i++) {
			Student s = new Student();
			s.setId(i);
			s.setName("Student"+i);
			Address a = new Address();
			a.setCity("city"+i);
			a.setPosteCode(1140+i);
			a.setStreet("street"+i);
			s.setAddress(a);
			students.add(s);
		}*/
		/*for (int i=1; i<11;i++) {
			Exam e = new Exam();
			e.setCode("exam"+i);
			e.setName("OCA");
			exams.add(e);
		}*/
	
		/*for (int i=0;i<students.size();i++) {
			if(students.get(i).getId()==studentRequest.getStudentId()) {
				testId=true;
				id=i;
				break;
			}
		}
		
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
		else if(studentRequest.getExamCode().isEmpty()) {
			mismatchs.add("exam code must be not empty");
		}
		else if(!(testCode))
		{
			mismatchs.add("wrong exam code");
		}
		else if(mismatchs.isEmpty()) {
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
	}*/
	public WhiteTestResponse checkWhiteTestStatus(StudentRequest studentRequest) throws DatatypeConfigurationException {
        Boolean testStudent=false;
        Boolean testExam=false;
        int id=0;
        int code=0;
        List<Student> students = new Student().getAllStudents() ;
        List<Exam> exams = new Exam().getAllExams() ;
 
        
        for (int i=0;i<students.size();i++) {
            if(students.get(i).getId()==studentRequest.getStudentId()) {
            	testStudent=true;
                id=i;
                break;
            }
        }
      
        for (int i=0;i<exams.size();i++) {
            if(exams.get(i).getCode().equalsIgnoreCase(studentRequest.getExamCode())) {
                testExam=true;
                code=i;
                break;
            }
        }
 
        WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
        List<String> mismatchs =whiteTestResponse.getCriteriaMismatch();
        if(studentRequest.getStudentId()==0 || studentRequest.getStudentId()<0 || !(testStudent)) {
            mismatchs.add("Student Id ghalet");
        }
        if(studentRequest.getExamCode().isEmpty()) {
            mismatchs.add("Exam code feragh");
        }
        if(!(testExam))
        {
            mismatchs.add("Exam code ghalet");
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
