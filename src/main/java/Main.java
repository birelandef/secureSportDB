import com.birelandef.dao.DAOImpl;
import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.SexType;
import com.birelandef.entities.Sportsmen;
import com.birelandef.dao.SService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.birelandef.dao.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Main {

    private static Sportsmen getSportsmen() {
        Sportsmen sportsmen = new Sportsmen();
        sportsmen.setDocId(new BigInteger("2"));
        sportsmen.setBirthDate(new Date(System.currentTimeMillis()));
        sportsmen.setFirstName("Абалымова");
        sportsmen.setSecondName("Александра");
        sportsmen.setSexTypeType(SexType.FEMAIL);
        sportsmen.setStandardClass(ClassType.B);
        return sportsmen;
    }

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
//        DAO dao = (DAO)context.getBean("DAOImpl");
//        dao.save(getSportsmen());
//        System.out.println("Список всех элементов библиотеки:");
//        for (Sportsmen sportsmen : (List<Sportsmen>)dao.getAll() /*service.getAll()*/)
//            System.out.println(sportsmen);
    }
}
