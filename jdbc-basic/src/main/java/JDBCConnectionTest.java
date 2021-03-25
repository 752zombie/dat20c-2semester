import java.sql.*;
import java.util.ArrayList;

public class JDBCConnectionTest {

    //We are not "really" handling the exception for now
    public static void main(String[] args) {
        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            //Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "notperma");

            //Create a PreparedStatement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM dept");

            //Prepared Statement contains a query and returns the rows from DB
            ResultSet rs = stmt.executeQuery();

            //Iterate through the ResultSet
            while(rs.next()){
                int deptNo = rs.getInt(1);
                String dName = rs.getString(2);
                String location = rs.getString(3);

                departments.add(new Department(deptNo,dName,location));
            }

            stmt = conn.prepareStatement("SELECT * FROM emp");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int empNo = rs.getInt("empno");
                String name = rs.getString("ename");
                String job = rs.getString("job");

                employees.add(new Employee(empNo, name, job));
            }

        }
        catch(SQLException e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i));
        }

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }
}
