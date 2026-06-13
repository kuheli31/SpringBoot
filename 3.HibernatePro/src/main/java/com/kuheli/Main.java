package com.kuheli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Lenovo");
        l1.setModel("250rock");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(13);
        a1.setAname("Koyel");
        a1.setTech("Java");
        a1.setLaptop(l1);

        /*Student s1 = new Student();
        s1.setsName("Avni");
        s1.setRollNo(1);
        s1.setSage(10);*/

        //Student s2 = null;

        SessionFactory sf = new  Configuration().addAnnotatedClass(com.kuheli.Alien.class)
                                                .addAnnotatedClass(com.kuheli.Laptop.class)
                                                .configure().buildSessionFactory();//cfg.buildSessionFactory();

        Session session = sf.openSession();

        //s2 = session.find(Student.class , 50);//fetching data

        Transaction transaction = session.beginTransaction();
        //session.persist(l1);
        session.persist(a1);
        transaction.commit();
        session.close();
        sf.close();
        //System.out.println(s2);
    }

}