package dbmanager;

import resources.Utilities;

import java.io.IOException;
import java.sql.*;

public class DataBaseConnection extends Utilities {
    public void database() throws ClassNotFoundException, IOException {
        String JDBC_DRIVER = getGlobalValues("jdbcDriver");
        String DB_URL = getGlobalValues("dbUrl");

        //DataBase Credentials
        final String user = getGlobalValues("userName") ;
        final String pass = getGlobalValues("pass");

        Connection conn = null;
        Statement stmt = null;

        try {
            //Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            //open Connenction
            try {
                conn = DriverManager.getConnection(DB_URL, user, pass);

                //Execute query
                stmt = conn.createStatement();
                String sql = "Select * from Products";
                ResultSet executeQuery = stmt.executeQuery(sql);
                ResultSetMetaData rsmd = executeQuery.getMetaData();
                int columncount = rsmd.getColumnCount();

                //Extract Result from Result set
                while(executeQuery.next()){
                    for (int i = 1; i <= columncount; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = executeQuery.getString(i);
                        System.out.print(columnValue + " " + rsmd.getColumnName(i));
                    }
                    System.out.println("");
                }

                //Close all connections
                executeQuery.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
