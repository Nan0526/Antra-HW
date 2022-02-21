package AdvancedDay1JDBCHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
    static final String DB_URL = "jdbc:mysql://localhost/mydb";
    static final String USER = "root";
    static final String PASS = "Guonan666";
    static final String QUERY = "SELECT id, first, last, age FROM Employees";
    static final String INSERT_QUERY = "INSERT INTO Employees (first, last, age) values('Rita', 'Tez', 20)";
    static final String INSERT_QUERY_2 = "INSERT INTO Employees (first, last, age) values('Sita', 'Singh', 20)";

    public static void printResultSet(ResultSet rs) throws SQLException{
        // Ensure we start with first row
        rs.beforeFirst();
        while(rs.next()){
            // Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try{
            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // Set auto commit as false.
            conn.setAutoCommit(false);

            // Execute a query to create statment with
            // required arguments for RS example.
            System.out.println("Creating statement...");
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            // INSERT a row into Employees table
            System.out.println("Inserting one row....");
            stmt.executeUpdate(INSERT_QUERY);

            // INSERT one more row into Employees table
            stmt.executeUpdate(INSERT_QUERY_2);

            // Commit data here.
            System.out.println("Commiting data here....");
            conn.commit();

            // Now list all the available records.
            String sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("List result set for reference....");
            printResultSet(rs);

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
            // If there is an error then rollback the changes.
            System.out.println("Rolling back data here....");
            try{
                if(conn!=null)
                    conn.rollback();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}