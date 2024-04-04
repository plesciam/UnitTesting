

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SummerVacationDALTest extends SummerVacationDAL2 
{
    public List<String> TryGetDestinationForActivity(String activityName) throws SQLException
    {
        List<String> parks = new ArrayList<String>();
        
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
    }
