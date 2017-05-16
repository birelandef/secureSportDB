package com.birelandef.generator;

import com.birelandef.entities.Pair;
import com.birelandef.entities.Sportsmen;
import com.birelandef.entities.Trainer;
import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.SexType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sophie on 15/05/17.
 */
public class EntityGenerator {

    public static final String MALE_SUFFIX = "ВИЧ";
    public static final Logger log = LoggerFactory.getLogger(EntityGenerator.class);
    public static final int COUNT_OF_PAIR = 200;


    public static List<Trainer> generateTrainers() throws URISyntaxException {
        List<Trainer> trainers = new ArrayList<>();
        URI path = Thread.currentThread().getContextClassLoader().getResource("trainers.txt").toURI();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(value -> trainers.add(createFrameTrainer(value)));
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
            pair.setMalePartnerId(manSportsmens.get(i).getDocId());
            pair.setFemalePartnerId(womanSportsmens.get(i).getDocId());
            pair.setScore(random.nextInt());
            pair.setClub(clubs.get(random.nextInt(clubs.size())));
            pair.setPairId(String.valueOf(random.nextInt()));
            pair.setAverageScore(random.nextDouble());
            pairs.add(pair);
        }
        return pairs;
    }
    
    private static Sportsmen createFrameSportsmen(String fullName){
        Random random = new Random();
        String[] fullNameArr = fullName.split(" ");

        Sportsmen sportsmen = new Sportsmen();
        //todo generate id
        sportsmen.setDocId(String.valueOf(random.nextInt()));
        sportsmen.setFirstName(fullNameArr[0]);
        sportsmen.setSecondName(fullNameArr[1]);
        sportsmen.setSexType(fullNameArr[2].endsWith(MALE_SUFFIX) ? SexType.MALE : SexType.FEMALE);
        //todo generate date
//        sportsmen.setBirthDate(new Date(Math.abs(System.currentTimeMillis() - random.nextLong())));
        sportsmen.setLatinClass(generateClass(random));
        sportsmen.setStandardClass(generateClass(random));

//        System.out.println(sportsmen);
        return sportsmen;
    }

    private static Trainer createFrameTrainer(String fullName){
        Random random = new Random();
        String[] fullNameArr = fullName.split(" ");
        Trainer trainer = new Trainer();
        trainer.settDocId(String.valueOf(random.nextInt()));
        trainer.setFirstName(fullNameArr[0]);
        trainer.setLastName(fullNameArr[1]);
        trainer.setLatin(random.nextBoolean());
        trainer.setStandard(random.nextBoolean());
        return trainer;
    }

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
}