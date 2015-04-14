/**
 * 
 * 
 */
package sep;
import java.sql.*;
/**
 * @author Apurv
 *
 */
public class dconnection {
	
	String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	String DB_URL = "jdbc:oracle:thin:@localhost:1521/XE";
	String DB_USER = "apurv";
	String DB_PASS = "apurv";
	
	Connection getDBConnection()
	{
		Connection dbconnection = null;
		
		try
		{
			Class.forName(JDBC_DRIVER);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			dbconnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return dbconnection;
	}
	
	

}
