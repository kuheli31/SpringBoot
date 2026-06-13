import java.sql.*;

public class BatchDemo {

    public static void main(String[] args) throws Exception {

        Connection con =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ORG",
                        "root",
                        "password");

        Statement st = con.createStatement();

        st.addBatch(
                "UPDATE Worker SET SALARY = SALARY + 1000 WHERE WORKER_ID = 1");

        st.addBatch(
                "UPDATE Worker SET SALARY = SALARY + 1000 WHERE WORKER_ID = 2");

        st.addBatch(
                "UPDATE Worker SET SALARY = SALARY + 1000 WHERE WORKER_ID = 3");

        int[] result = st.executeBatch();

        System.out.println("Batch Executed");

        con.close();
    }
}