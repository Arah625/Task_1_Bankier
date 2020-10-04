import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static String url = "jdbc:postgresql://localhost:5432/goldpricedb";
    private static String username = "postgres";
    private static String password = "654321";
    private static String dbname = "goldpricedb";

    public static Connection goldDbConncect() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected to database - " + dbname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


}