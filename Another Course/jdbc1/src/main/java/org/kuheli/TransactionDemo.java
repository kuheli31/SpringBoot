import java.sql.*;

public class TransactionDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ORG";
        String username = "root";
        String password = "KuheliBera2004@";

        Connection con = null;

        try {

            con = DriverManager.getConnection(url, username, password);

            con.setAutoCommit(false);

            Statement st = con.createStatement();

            st.executeUpdate(
                    "UPDATE Worker SET SALARY = SALARY + 10000 WHERE WORKER_ID = 1");

            st.executeUpdate(
                    "UPDATE Worker SET SALARY = SALARY + 10000 WHERE WORKER_ID = 2");

            con.commit();

            System.out.println("Transaction Successful");

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Transaction Rolled Back");
            e.printStackTrace();
        }
    }
}