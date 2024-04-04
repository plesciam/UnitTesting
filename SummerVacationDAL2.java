

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SummerVacationDAL2
{
    protected Connection connection;


    private void InitializeConnection(String databaseName, String user, String password)
    {
        try
        {
            if(connection == null)
            {
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, user, password);
            }
        } 
        catch (SQLException exception)
        {
            System.out.println("Failed to connect to the database" + exception.getMessage());
        }
    }

    public SummerVacationDAL2(String databaseName, String userName, String password)
    {
        InitializeConnection(databaseName, userName, password);
    }
    public SummerVacationDAL2() {
    
    }

    public List<String> TryGetDestinationForActivity(String activityName) throws SQLException
    {
        List<String> parks = new ArrayList<String>();
        try
        {
            String parkquery = "select * from Park";
            PreparedStatement myStatement = connection.prepareStatement("Select * From Plan Where ActivityName = ?");
            myStatement.setString(1, parkquery);
            ResultSet myRelation = myStatement.executeQuery(parkquery);
            while(myRelation.next()) 
            {
            parks.add(myRelation.getString("ParkName"));                
            }
            
            String activityquery = "select * from Plan where ActivityName = ? ";
            PreparedStatement parkquerystatement = connection.prepareStatement("Select * From Plan Where ParkName = ?");
            parkquerystatement.setString(1, activityquery);
            ResultSet myRel = myStatement.executeQuery();
            while(myRel.next()) 
            {

            }
            String parknamequery = "select * from Plan where ParName = ? ";
            PreparedStatement parknamequerystatement = connection.prepareStatement("Select * From Plan Where ParkName = ?");
            parknamequerystatement.setString(1, parknamequery);
            ResultSet myRelat = myStatement.executeQuery(parknamequery);
            while(myRelat.next()) 
            {

            }
    
            return parks;
        }
        catch(SQLException ex)
        {
            System.out.println("Failed to get activity destinations" + ex.getMessage());
            return parks;
        }
      }
}