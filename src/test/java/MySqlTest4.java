import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MySqlTest4 extends FlywayMySqlTest{

    @BeforeAll
    static void init(){
        flyway.clean();
        flyway.baseline();
        flyway.migrate();
    }

    @Test
    void test() throws SQLException {
        statement.execute("DELETE FROM emocije WHERE ID=4;");

    }

    @AfterAll
    static void showResult(){
        showTable();
    }
}
