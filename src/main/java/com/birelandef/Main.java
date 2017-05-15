package com.birelandef;

import com.birelandef.dao.DAO;
import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.SexType;
import com.birelandef.entities.Sportsmen;
import com.birelandef.generator.EntityGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Sportsmen> sportsmens = EntityGenerator.generateSportsmens();
            ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
            DAO sportsmenDao = (DAO)context.getBean("sprtdao");
            for (Sportsmen sportsmen : sportsmens)
                sportsmenDao.addEntity(sportsmen);
            System.out.println("Count "+ sportsmenDao.getAllEntity().size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
