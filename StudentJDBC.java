import java.sql.*;

public class StudentJDBC {

    static final String URL =
            "jdbc:mysql://localhost:3306/college";

    static final String USER = "studentuser";

    static final String PASSWORD = "studentpass";

    public static void main(String args[]) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            Statement stmt = con.createStatement();

            // Insert Records

            stmt.executeUpdate(
                    "INSERT INTO student VALUES(101,'Ravi','Hyderabad')");

            stmt.executeUpdate(
                    "INSERT INTO student VALUES(102,'Priya','Chennai')");

            stmt.executeUpdate(
                    "INSERT INTO student VALUES(103,'Rahul','Bangalore')");

            System.out.println("Records Inserted");

            // Update

            stmt.executeUpdate(
                    "UPDATE student SET address='Delhi' WHERE rollno=102");

            System.out.println("Record Updated");

            // Delete

            stmt.executeUpdate(
                    "DELETE FROM student WHERE rollno=103");

            System.out.println("Record Deleted");

            // Display

            ResultSet rs =
                    stmt.executeQuery("SELECT * FROM student");

            System.out.println();

            System.out.println("Student Details");

            while(rs.next())
            {
                System.out.println(
                        rs.getInt("rollno")
                        +" "
                        +rs.getString("name")
                        +" "
                        +rs.getString("address"));
            }

            rs.close();
            stmt.close();
            con.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

