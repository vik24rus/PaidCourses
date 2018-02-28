package app.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TODO Pools connections? что бы постоянно не открывать коннекшины при каждом запросе ?
public class ConnectionFactory{
        public static final String SQlite_DRIVER = "org.sqlite.JDBC";
        public static final String DB_URL = "jdbc:sqlite:src/main/java/resources/db/pc.db";


        private static ConnectionFactory instance; // Singleton

        private ConnectionFactory() {
            try {
                Class.forName(SQlite_DRIVER);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Not found class " + SQlite_DRIVER, e);
            }
        }

        public static synchronized ConnectionFactory getInstance() {
            if (instance == null) {
                instance = new ConnectionFactory();
            }
            return instance;
        }

        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL);
        }
}
