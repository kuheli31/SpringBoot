package org.kuheli;

import java.sql.*;

public class ResultSetMetaDataDemo {

    public static void main(String[] args) throws Exception {

        Connection con =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ORG",
                        "root",
                        "password");

        Statement st =
                con.createStatement();

        ResultSet rs =
                st.executeQuery("SELECT * FROM Worker");

        ResultSetMetaData rsmd =
                rs.getMetaData();

        int count =
                rsmd.getColumnCount();

        System.out.println("Total Columns: "
                + count);

        for(int i=1;i<=count;i++) {

            System.out.println(
                    rsmd.getColumnName(i)
                            + " : "
                            + rsmd.getColumnTypeName(i));
        }
    }
}
