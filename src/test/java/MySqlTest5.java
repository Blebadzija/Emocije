import jakarta.transaction.Transaction;
import org.etsntesla.it.Emocije;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MySqlTest5 extends JpaMySqlTest{
    @BeforeAll
    static void init(){
        flyway.clean();
        flyway.baseline();
        flyway.migrate();
        session = sessionFactory.openSession();
    }

    @Test
    void test(){
        Transaction transaction = null;
        try {
            Emocije emocije = new Emocije();
            emocije.setId(4);


        }catch (Exception e){
            transaction.rollback();
        }
    }

    @AfterAll
    static void showResult(){
        showTable();
    }
}
