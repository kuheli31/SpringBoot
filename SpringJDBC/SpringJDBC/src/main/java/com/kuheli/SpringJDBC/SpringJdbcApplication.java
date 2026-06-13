package com.kuheli.SpringJDBC;

import com.kuheli.SpringJDBC.model.Student;
import com.kuheli.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Student s = context.getBean(Student.class);
        s.setRollNo(52);
        s.setName("Kuheli");
        s.setMarks(95);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> students = service.getStudents();
        System.out.println(students);
	}

}
