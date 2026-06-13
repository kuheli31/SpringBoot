import java.sql.*;

public class PreparedStatementDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ORG";
        String username = "root";
        String password = "KuheliBera2004@";

        try {

            Connection con =
                    DriverManager.getConnection(url, username, password);

            String query =
                    "SELECT * FROM Worker WHERE WORKER_ID = ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, 1);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("ID: " +
                        rs.getInt("WORKER_ID"));

                System.out.println("Name: " +
                        rs.getString("FIRST_NAME"));

                System.out.println("Salary: " +
                        rs.getInt("SALARY"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}