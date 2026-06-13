package com.kuheli.spring_data_jpa;

import com.kuheli.spring_data_jpa.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);

        s1.setRollNo(101);
        s1.setName("Kuheli");
        s1.setMarks(95);

        s2.setRollNo(102);
        s2.setName("Koyel");
        s2.setMarks(60);

        s3.setRollNo(103);
        s3.setName("Durjoy");
        s3.setMarks(78);

        repo.save(s1);
        repo.save(s2);
        repo.save(s3);
	}

}
