import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/newdb";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "Beuganji7@";
   // Connection c = null;

	


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}

