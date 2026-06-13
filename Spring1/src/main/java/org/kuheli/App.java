package org.kuheli;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Alien obj1 = context.getBean("alien1" , Alien.class);
        System.out.println(obj1.getAge());
        obj1.code();

        Alien obj2 =(Alien) context.getBean("alien1");
        //obj2.code();
    }
}
