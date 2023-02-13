import org.etsntesla.it.MySqlManager;
import org.etsntesla.it.RunShellCommand;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseMySqlTest {

    private static String resDir;

    private static String emptyDumpMySqlFile;

    private static String dataDumpMySqlFile;
    protected static Connection conn;
    protected static Statement statement;


    @BeforeAll
    static void baseInit() throws SQLException{
        conn = MySqlManager.getConnection();
        statement = conn.createStatement();
        resDir="db_dump";
    }



    static void showTable(){
       try {
           ResultSet resultSet = statement.executeQuery("SELECT * FROM emocije;");
           while (resultSet.next()){
               System.out.println("###############################Id="+resultSet.getInt(1)+"#################################");
               System.out.println("    Vrsta_emocije="+resultSet.getString(2));
               System.out.println("    Poruka="+resultSet.getString(3));
           }
       }catch (SQLException e){
           throw new RuntimeException(e.getMessage());
       }
    }


    protected static boolean executeDumpFile(String dumpSqlFile) {

        try {
            String path = BaseMySqlTest.class.getClassLoader().getResource(dumpSqlFile).getPath().replaceAll("^/", "");
            return RunShellCommand.execute(new String[]{"mysql", "-u", "root","db_emocije_ah","<", path});
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    protected static void  fillData(){

        executeDumpFile(getDataDumpMySqlFile());
    }

    protected static void emptyData(){
        executeDumpFile(getEmptyDumpMySqlFile());
    }

    public static String getResDir() {
        return resDir;
    }

    public static void setResDir(String resDirdir) {
        BaseMySqlTest.resDir = resDirdir.replaceAll("^/|/$","");
    }

    public static String getEmptyDumpMySqlFile() {
        return resDir+"/"+emptyDumpMySqlFile;
    }

    public static void setEmptyDumpMySqlFile(String emptyDumpMySqlFile) {
        BaseMySqlTest.emptyDumpMySqlFile = emptyDumpMySqlFile;
    }

    public static String getDataDumpMySqlFile() {
        return resDir+"/"+dataDumpMySqlFile;
    }

    public static void setDataDumpMySqlFile(String dataDumpMySqlFile) {
        BaseMySqlTest.dataDumpMySqlFile = dataDumpMySqlFile;
    }

}
