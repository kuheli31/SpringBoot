//1. package imported
import java.sql.*;

public class JDBCdemo
{
    public static void main(String[] args) throws Exception{
        /*
        1) import package
        2) load and register
        3) create connection
        4) create statement
        5) execute statement
        6) process the results
        7) close
         */

        //2. load and register
        Class.forName("org.postgresql.Driver");

        //3. create connection
        String url= "jdbc:postgresql://localhost:5432/Demo";
        String uname= "postgres";
        String pass="Kuheli@2004";
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established.");

        //4. create statement
        String query= "select name from student where id=3;";
        Statement st = con.createStatement();

        //5. execute statement
        ResultSet rs = st.executeQuery(query);

        //6. process the result
        //System.out.println(rs.next());// if output is true then we are getting query else no
        rs.next(); // to get datas
        String name = rs.getString("name");
        System.out.println(name);


        //7. close the connection
        con.close();
        System.out.println("Connection closed.");
        //done
    }
}
