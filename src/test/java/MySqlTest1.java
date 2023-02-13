import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MySqlTest1 extends BaseMySqlTest{
    @BeforeAll
    static void init1(){
        setDataDumpMySqlFile("emocije_data_dump.sql");
        setEmptyDumpMySqlFile("emocije_drop_dump.sql");
        emptyData();
        fillData();
    }

    @Test
    void test() throws SQLException {
        //statement.executeUpdate("INSERT INTO emocije VALUES(NULL, 'Radost', \" Nema ništa sumnjivo u životu. On treba biti neprestana radost… pozvani smo na trajnu sreću u Gospodinu čija je radost naša snaga – Amy Carmichael  \")");
        statement.execute("DELETE FROM emocije WHERE ID=4;");

    }

    @AfterAll
    static void showResult(){
        showTable();
        emptyData();
    }
}
