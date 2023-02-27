

import org.etsntesla.it.Emocije;
import org.etsntesla.it.spring.BeanFactory;
import org.etsntesla.it.spring.FlywayManager;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




import java.util.List;

public class JpaMySqlTest {
    protected static SessionFactory sessionFactory;

    protected static Session session;
    protected static Flyway flyway;

    @BeforeAll
    static void initBase(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanFactory.class);
        flyway = ctx.getBean(FlywayManager.class).getFlyway();
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Emocije.class);
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();


    }

    @AfterAll
    static void close(){
        session.close();
        sessionFactory.close();
    }

    static void showTable(){
        List<Emocije> emocijeList = session.createQuery("FROM Emocije", Emocije.class).list();
        for(Emocije e : emocijeList){
            System.out.println("###############################Id="+e.getId()+"#################################");
            System.out.println("    Vrsta_emocije="+e.getVrstaEmocije());
            System.out.println("    Poruka="+e.getPoruka());

        }
    }
}
