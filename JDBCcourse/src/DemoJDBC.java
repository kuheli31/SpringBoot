/*
        Steps to connect JDBC:
        i) import package
        ii) load and register//optional
        iii)create connection
        iv) create statement
        v) execute statement
        vi) process the results
        vii) close
*/
//step 1
import java.sql.*;
public class DemoJDBC {
    public static void main(String[] args) throws Exception{
        //2. load and register
        Class.forName("org.postgresql.Driver");

        //3. create connection
        String url= "jdbc:postgresql://localhost:5432/study";
        String uname= "postgres";
        String pass="Kuheli@2004";
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established.");

        //4. create statement
        String query= "select * from student where sid=1;";
        Statement st = con.createStatement();

        //5. execute statement
        ResultSet rs = st.executeQuery(query);

        //6. process the result
        //System.out.println(rs.next());// if output is true then we are getting query else no
        rs.next(); // to get datas
        String name = rs.getString("sname");
        Integer mark = rs.getInt("marks");
        System.out.println(name);
        System.out.println(mark);

        //7. close the connection
        con.close();
        System.out.println("Connection closed.");
        //done

    }
}
