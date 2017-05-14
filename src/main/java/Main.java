import com.birelandef.ClassType;
import com.birelandef.Sex;
import com.birelandef.Sportsmen;
import com.birelandef.dao.SService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.Date;

public class Main {


    private static Sportsmen getSportsmen() {
        Sportsmen sportsmen = new Sportsmen();
        sportsmen.setDocId(new BigInteger("1"));
        sportsmen.setBirthDate(new Date(System.currentTimeMillis()));
        sportsmen.setFirstName("Москаленко");
        sportsmen.setSecondName("Илья");
        sportsmen.setSexType(Sex.MAlE);
        sportsmen.setStandardClass(ClassType.B);
        return sportsmen;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        SService service = (SService) context.getBean("storageService");
        service.save(getSportsmen());
        System.out.println("Список всех элементов библиотеки:");
        for (Sportsmen sportsmen : service.getAll())
            System.out.println(sportsmen);
    }
}
