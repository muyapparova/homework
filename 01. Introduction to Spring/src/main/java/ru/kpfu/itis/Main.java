package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by root on 05.10.15.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Mucician m = (Mucician) context.getBean("oleg");
        System.out.println(m.name);
        System.out.println(m.age);

        Mucician m2 = (Mucician) context.getBean("petr");
        System.out.println(m2.getName());
        System.out.println(m2.getAge());

        Mucician m3 = (Mucician) context.getBean("ivan");
        m3.getInstrument().play();

        Mucician m4 = (Mucician) context.getBean("aidar");
        m4.getInstrument().play();

        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext();
        ac.register(ConfigExample.class);
        ac.refresh();
        Instrument i = ac.getBean(Instrument.class);
        i.play();
//ac.removeBeanDefinition("guitar");
//ac.close();

        i.play();

        Instrument i2 = ac.getBean(Instrument.class);
        i2.play();

        TestService custA = (TestService)context.getBean("testService1");
        custA.setMessage("Message by custA");
        System.out.println("Message : " + custA.getMessage());

//retrieve it again
        TestService custB = (TestService)context.getBean("testService1");
        //custB.setMessage("Message by custB");
        System.out.println("Message : " + custB.getMessage());
        m.print();
    }

}
