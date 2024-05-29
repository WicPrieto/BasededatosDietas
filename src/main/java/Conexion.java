import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Conexion {

        public class DatabaseConnection {
            private static final String URL = "jdbc:mysql://localhost:3309/basededatosempresa?allowPublicKeyRetrieval=true";
            private static final String USER = "root";
            private static final String PASSWORD = "1234";

            public static Connection getConnection() throws SQLException {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            }
        }
    }

