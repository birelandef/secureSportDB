package com.birelandef;

import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.SexType;
import com.birelandef.entities.Sportsmen;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.birelandef.dao.*;

import java.util.Date;

public class Main {

    private static Sportsmen getSportsmen() {
        Sportsmen sportsmen = new Sportsmen();
        sportsmen.setDocId("2");
        sportsmen.setBirthDate(new Date(System.currentTimeMillis()));
        sportsmen.setFirstName("Абалымова");
        sportsmen.setSecondName("Александра");
        sportsmen.setSexTypeType(SexType.FEMAIL);
        sportsmen.setStandardClass(ClassType.B);
        return sportsmen;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        DAO dao = (DAO)context.getBean("sprtdao");
        Sportsmen s = getSportsmen();
        dao.addEntity(s);
        System.out.println(dao.findEntityById("2"));
//        dao.removeEntity(s);
        s.setLatinClass(ClassType.D);
        dao.updateEntity(s);
        System.out.println(dao.findEntityById("2"));
        System.out.println("Count "+ dao.getAllEntity().size());
    }
}
