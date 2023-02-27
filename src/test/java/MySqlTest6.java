import org.etsntesla.it.Emocije;
import org.etsntesla.it.VrstaEmocije;
import org.etsntesla.it.spring.BeanFactory;
import org.etsntesla.it.spring.EmocijeManager;
import org.etsntesla.it.spring.FlywayManager;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MySqlTest6 {

    static EmocijeManager emocijeManager;

    static Emocije item;

    static int testOrder = 1;

    @BeforeAll
    static void init(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanFactory.class);
        Flyway flyway = ctx.getBean(FlywayManager.class).getFlyway();
        flyway.clean();
        flyway.baseline();
        flyway.migrate();
        emocijeManager = ctx.getBean(EmocijeManager.class);
        item = new Emocije();
        item.setVrstaEmocije(VrstaEmocije.Radost);
        item.setPoruka("Bogatim te cini, ne bogatstvo, nego radost.");
    }

    @BeforeEach
    void naslov(){
        System.out.println("#####################################" +
                            "\n#                  TEST"+(testOrder++)+
                            "                  #\n");
    }

    @Test
    @DisplayName("READ")
    void test1(){
        Assertions.assertEquals(VrstaEmocije.Tuga,emocijeManager.getById(3).getVrstaEmocije());
    }

    @Test
    @DisplayName("CREATE")
    void test2(){
        emocijeManager.create(item);
        showTable();
    }

    @Test
    @DisplayName("UPDATE")
    void test3(){
        item.setId(1);
        item.setPoruka("Sreca Sreca radost");
        emocijeManager.update(item);
        showTable();
    }

    @Test
    @DisplayName("DELETE")
    void test4(){
        item.setId(4);
        emocijeManager.delete(item);
        showTable();
    }

    static void showTable(){
        List<Emocije> emocijeList = emocijeManager.getAll();
        for(Emocije e : emocijeList){
            System.out.println("###############################Id="+e.getId()+"#################################");
            System.out.println("    Vrsta_emocije="+e.getVrstaEmocije());
            System.out.println("    Poruka="+e.getPoruka());

        }
    }
}
