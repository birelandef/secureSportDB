package com.birelandef;

import com.birelandef.dao.DAO;
import com.birelandef.entities.Competition;
import com.birelandef.entities.Pair;
import com.birelandef.entities.Sportsmen;
import com.birelandef.entities.Trainer;
import com.birelandef.generator.EntityGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Sportsmen> sportsmens = EntityGenerator.generateSportsmens();

            List<Pair> pairs = EntityGenerator.generatePairs(sportsmens);
            ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
            DAO sportsmenDao = (DAO)context.getBean("sprtdao");
            DAO pairDao = (DAO)context.getBean("prdao");
            DAO competitionDao = (DAO)context.getBean("cmptdao");
            DAO trainerDao = (DAO)context.getBean("trnrdao");
            for (Sportsmen sportsmen : sportsmens)
                sportsmenDao.addEntity(sportsmen);
            System.out.println("Count "+ sportsmenDao.getAllEntity().size());

            for (Pair pair : pairs)
                pairDao.addEntity(pair);
            System.out.println("Count "+ pairDao.getAllEntity().size());

            for (Competition competition : EntityGenerator.generateCompetitions())
                competitionDao.addEntity(competition);
            System.out.println("Count "+ competitionDao.getAllEntity().size());

            for (Trainer trainer : EntityGenerator.generateTrainers())
                trainerDao.addEntity(trainer);
            System.out.println("Count "+ trainerDao.getAllEntity().size());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
