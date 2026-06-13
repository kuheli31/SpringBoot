package org.kuheli;
import java.sql.*;

public class DatabaseMetaDataDemo {

    public static void main(String[] args) throws Exception {

        Connection con =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ORG",
                        "root",
                        "password");

        DatabaseMetaData dbmd =
                con.getMetaData();

        System.out.println("Driver Name: "
                + dbmd.getDriverName());

        System.out.println("Driver Version: "
                + dbmd.getDriverVersion());

        System.out.println("Database Product: "
                + dbmd.getDatabaseProductName());

        System.out.println("Database Version: "
                + dbmd.getDatabaseProductVersion());

        System.out.println("User Name: "
                + dbmd.getUserName());
    }
}