package tools;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class koneksi {

    private static Connection con;

    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3310/mccoc";
    static String user = "root";
    static String pass = "";

    public static Connection getkoneksi() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

}
