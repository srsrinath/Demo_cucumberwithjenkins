package dbhelper;

import com.jcraft.jsch.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbConfig {
    static CredsLoader credsLoader = new CredsLoader();
    private static final String SSH_HOST = credsLoader.getProperty("SSH_HOST");
    private static final String SSH_USER = credsLoader.getProperty("SSH_USER");
    private static final String SSH_PASSWORD = credsLoader.getProperty("SSH_PASSWORD");
    private static final int SSH_PORT = Integer.parseInt(credsLoader.getProperty("SSH_PORT"));

    // Database connection details
    private static final String DB_HOST = credsLoader.getProperty("DB_HOST");
    private static final int DB_PORT = Integer.parseInt(credsLoader.getProperty("DB_PORT"));
    private static final String DB_USER = credsLoader.getProperty("DB_USER");
    private static final String DB_PASSWORD = credsLoader.getProperty("DB_PASSWORD");
    private static final String DB_NAME = credsLoader.getProperty("DB_NAME");

    private static final String JDBC_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    static Connection conn = null;
    static Session session = null;

    public static void initilizeDb() {

        try {

//            JSch jsch = new JSch();
//            session = jsch.getSession(SSH_USER, SSH_HOST, SSH_PORT);
//            session.setPassword(SSH_PASSWORD);
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.connect();
//
//            int forwardedPort = session.setPortForwardingL(0, DB_HOST, DB_PORT);

            String jdbcUrlWithSSH = "jdbc:mysql://192.168.1.136:3306/ktestdb01";
            conn = DriverManager.getConnection(jdbcUrlWithSSH, DB_USER, DB_PASSWORD);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("JDBC driver is started successfully");
    }

    public static void closeDriver() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (session != null) {
            session.disconnect();
        }
        System.out.println("JDBC driver is closed successfully");
    }

    public static ResultSet executeQuery(String sqlQuery) {
        ResultSet rs = null;

        try {

            PreparedStatement stmt = null;

            stmt = conn.prepareStatement(sqlQuery);

            rs = stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}
