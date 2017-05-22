package com.birelandef.generator;

import com.birelandef.entities.*;
import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.CompetitionType;
import com.birelandef.entities.enums.ProgramType;
import com.birelandef.entities.enums.SexType;
import com.birelandef.utils.CompetitionResultId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sophie on 15/05/17.
 */
public class EntityGenerator {

    public static final String MALE_SUFFIX = "ВИЧ";
    public static final Logger log = LoggerFactory.getLogger(EntityGenerator.class);
    public static final int COUNT_OF_PAIR = 200;


    public static List<Trainer> generateTrainers(List<Pair> pairs) throws URISyntaxException {
        List<Trainer> trainers = new ArrayList<>();
        URI path = Thread.currentThread().getContextClassLoader().getResource("trainers.txt").toURI();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(value -> trainers.add(createFrameTrainer(value, pairs)));
        } catch (IOException e) {
            log.error("Error while generateTrainers");
        }
        return trainers;
    }

    public static List<Sportsmen> generateSportsmens() throws URISyntaxException {
        List<Sportsmen> sportsmens = new ArrayList<>();

        URI path = Thread.currentThread().getContextClassLoader().getResource("sportsmens.txt").toURI();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(value -> sportsmens.add(createFrameSportsmen(value)));
        } catch (IOException e) {
            log.error("Error while generateSportsmens");
        }
        return sportsmens;
    }

    public static List<Competition> generateCompetitions(List<Trainer> trainers) throws URISyntaxException {
        List<Competition> competitions = new ArrayList<>();

        URI path = Thread.currentThread().getContextClassLoader().getResource("competitionsName.txt").toURI();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(value -> competitions.add(createFrameCompetition(value, trainers)));
        } catch (IOException e) {
            log.error("Error while generateCompetitions");
        }
        return competitions;
    }

    public static List<Pair> generatePairs(List<Sportsmen> sportsmens) throws URISyntaxException {
        List<String> clubs = new ArrayList<>();
        List<Pair> pairs = new ArrayList<>();

        URI path = Thread.currentThread().getContextClassLoader().getResource("club.txt").toURI();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(value -> clubs.add(value));
        } catch (IOException e) {
            log.error("Error while read clubs");
        }
        List<Sportsmen> manSportsmens = sportsmens.stream().filter(sportsmen -> SexType.MALE.equals(sportsmen.getSexType())).collect(Collectors.toList());
        List<Sportsmen> womanSportsmens = sportsmens.stream().filter(sportsmen -> SexType.FEMALE.equals(sportsmen.getSexType())).collect(Collectors.toList());
        for (int i = 0; i< COUNT_OF_PAIR; i++) {
            Random random = new Random();
            Pair pair = new Pair();
            Sportsmen man = manSportsmens.get(i);
            pair.setMalePartnerId(man);
            pair.setFemalePartnerId(womanSportsmens.get(i));
//            pair.setScore(random.nextInt());
            pair.setClub(clubs.get(random.nextInt(clubs.size())));
//            pair.setAverageScore(random.nextDouble());
            pair.setPairLatinClass(man.getLatinClass());
            pair.setPairStandardClass(man.getStandardClass());
            pairs.add(pair);
        }
        return pairs;
    }

    private static Competition createFrameCompetition(String name, List<Trainer> trainers){
        Random random = new Random();

        Competition competition = new Competition();
        competition.setName(name);
        competition.setScorePerPair(5);
        competition.setLocation("г. Москва ДСЕ ЦСКА, Ленинградский пр-т,     д.39 стр.27");

        LocalDate startDate = LocalDate.of(2016, 9, 1); //start date
        LocalDate endDate = LocalDate.of(2017,5, 20); //end date
        long randomEpochDay = ThreadLocalRandom.current().longs(startDate.toEpochDay(), endDate.toEpochDay()).findAny().getAsLong();
        Instant instant = LocalDate.ofEpochDay(randomEpochDay).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        competition.setDate(Date.from(instant));
        competition.setCompetitionType(CompetitionType.LOCAL);
        competition.setProgram(random.nextBoolean() ? ProgramType.STANDARD : ProgramType.LATIN);
        ClassType cl = generateClass(random);
        competition.setClassType(cl!=null ? cl : ClassType.D);
        competition.setRate(1);
        List<Trainer> judges = new ArrayList<>();
        for (int i =0; i<7; i++){
            Trainer trainer = trainers.get(random.nextInt(trainers.size()));

            if  (ProgramType.LATIN.equals(competition.getProgram()) && trainer.isLatin()){
                judges.add(trainer);
            }
            if  (ProgramType.STANDARD.equals(competition.getProgram()) && trainer.isStandard()){
                judges.add(trainer);
            }
        }
        competition.setInvitedJudgers(judges);
        return competition;
    }


    private static Sportsmen createFrameSportsmen(String fullName){
        Random random = new Random();
        String[] fullNameArr = fullName.split(" ");

        Sportsmen sportsmen = new Sportsmen();
        sportsmen.setFirstName(fullNameArr[0]);
        sportsmen.setSecondName(fullNameArr[1]);
        sportsmen.setSexType(fullNameArr[2].endsWith(MALE_SUFFIX) ? SexType.MALE : SexType.FEMALE);

        LocalDate startDate = LocalDate.of(1980, 1, 1); //start date
        LocalDate endDate = LocalDate.of(1999,12, 31); //end date
        long randomEpochDay = ThreadLocalRandom.current().longs(startDate.toEpochDay(), endDate.toEpochDay()).findAny().getAsLong();
        Instant instant = LocalDate.ofEpochDay(randomEpochDay).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        sportsmen.setBirthDate(Date.from(instant));
        sportsmen.setLatinClass(generateClass(random));
        sportsmen.setStandardClass(generateClass(random));

//        System.out.println(sportsmen);
        return sportsmen;
    }

    private static Trainer createFrameTrainer(String fullName, List<Pair> pairs){
        Random random = new Random();
        String[] fullNameArr = fullName.split(" ");
        Trainer trainer = new Trainer();
        trainer.setFirstName(fullNameArr[0]);
        trainer.setSecondName(fullNameArr[1]);
        trainer.setLatin(random.nextBoolean());
        trainer.setStandard(random.nextBoolean());
        trainer.selectAndSaveTrainingPairs(30, pairs);
        return trainer;
    }

    /*
     latinclass | count
------------+-------
            |   146
          6 |    20 S
          4 |    65 D
          5 |    33 B
          2 |    26 A
          1 |    49 N
          0 |    51 E
          3 |    64 C
     */
    private static ClassType generateClass(Random ran){
        int classInt = (int)Math.round((ran.nextGaussian() + 1) * 6);
        switch (classInt) {
            case 0: return ClassType.S;
            case 1: return ClassType.A;
            case 2: return ClassType.B;
            case 3: return ClassType.N;
            case 4: return ClassType.E;
            case 5: return ClassType.C;
            case 6: return ClassType.D;
            case 7: return ClassType.C;
            case 8: return ClassType.E;
            case 9: return ClassType.N;
            case 10: return ClassType.B;
            case 11: return ClassType.A;
            case 12: return null;
            default: return null;
        }
    }

    public static List<CompetitionResult> generateResult(List<Competition> competitions, List<Pair> pairs) {
        List<CompetitionResult> results = new ArrayList<>();
        // sort pair to program/class
        Map<String, List<Pair>> sortedPairs = sortPairs(pairs);
        Random random = new Random();
        for (Competition competition : competitions) {

            List<Pair> thesePairs =new ArrayList<>();
            thesePairs.addAll(sortedPairs.get(competition.getProgram().name() + competition.getClassType().getClassName()));
//            System.out.println(competition.getProgram().name() + competition.getClassType().getClassName() + " : " + thesePairs.size());
            int countPairs = random.nextInt(12);
//            System.out.println(countPairs);
            for (int i = 0; i < countPairs; i++) {
                if (thesePairs.size() == 0)
                    break;
                CompetitionResult res = new CompetitionResult();
                Pair pair = thesePairs.get(random.nextInt(thesePairs.size()));
                thesePairs.remove(pair);
                res.setPk(new CompetitionResultId(competition, pair));

                res.setPoint(i+1);
                res.setScore((countPairs-1 -i) * competition.getScorePerPair());
                results.add(res);
            }
        }
        return results;
    }

    private static Map<String, List<Pair>> sortPairs(List<Pair> initPairs){
        Map<String, List<Pair>> map = new HashMap<>();
        initPairs.stream().forEach(value -> checkPair(value, map));
        return map;
    }

    private static void checkPair(Pair pair, Map<String, List<Pair>> map ){
        ClassType latinClass = pair.getPairLatinClass();
        ClassType standardClass = pair.getPairStandardClass();
        if (latinClass !=null){
            String key = ProgramType.LATIN.name()+latinClass.getClassName();
            List<Pair> addedPairs = map.get(key);
            if (addedPairs == null)
                addedPairs = new ArrayList<Pair>();
            addedPairs.add(pair);
            map.put(key, addedPairs);
        }
        if (standardClass !=null){
            String key = ProgramType.STANDARD.name()+standardClass.getClassName();
            List<Pair> addedPairs = map.get(key);
            if (addedPairs == null)
                addedPairs = new ArrayList<Pair>();
            addedPairs.add(pair);
            map.put(key, addedPairs);
        }

    }
}
