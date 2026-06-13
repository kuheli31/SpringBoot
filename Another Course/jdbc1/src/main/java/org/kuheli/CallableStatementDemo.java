import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStatementDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ORG";
        String username = "root";
        String password = "KuheliBera2004@"; // Change according to your MySQL password

        try {
            // Load Driver (optional in JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con =
                    DriverManager.getConnection(url, username, password);

            // Create CallableStatement
            CallableStatement cs =
                    con.prepareCall("{call getWorkerName(?, ?)}");

            // Set IN parameter
            cs.setInt(1, 3);

            // Register OUT parameter
            cs.registerOutParameter(2, Types.VARCHAR);

            // Execute Procedure
            cs.execute();

            // Get OUT parameter value
            String workerName = cs.getString(2);

            System.out.println("Worker Name: " + workerName);

            // Close Resources
            cs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}