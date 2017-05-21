package com.birelandef;

import com.birelandef.dao.DAO;
import com.birelandef.entities.*;
import com.birelandef.generator.EntityGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Sportsmen> sportsmens = EntityGenerator.generateSportsmens();

            List<Pair> pairs = EntityGenerator.generatePairs(sportsmens);
            List<Trainer> trainers = EntityGenerator.generateTrainers(pairs);
            List<Competition> competitions = EntityGenerator.generateCompetitions(trainers);
            List<CompetitionResult> competitionResults = EntityGenerator.generateResult(competitions, pairs);
            ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");

            DAO sportsmenDao = (DAO)context.getBean("sprtdao");
            DAO pairDao = (DAO)context.getBean("prdao");
            DAO competitionDao = (DAO)context.getBean("cmptdao");
            DAO trainerDao = (DAO)context.getBean("trnrdao");
            DAO resultDao = (DAO)context.getBean("cmprsltdao");
            for (Sportsmen sportsmen : sportsmens)
                sportsmenDao.addEntity(sportsmen);
            System.out.println("Count "+ sportsmenDao.getAllEntity().size());

            for (Pair pair : pairs)
                pairDao.addEntity(pair);
            System.out.println("Count "+ pairDao.getAllEntity().size());


            for (Trainer trainer : trainers)
                trainerDao.addEntity(trainer);
            System.out.println("Count "+ trainerDao.getAllEntity().size());

            for (Competition competition : competitions)
                competitionDao.addEntity(competition);
            System.out.println("Count "+ competitionDao.getAllEntity().size());

            for (CompetitionResult result : competitionResults) {
                resultDao.addEntity(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
