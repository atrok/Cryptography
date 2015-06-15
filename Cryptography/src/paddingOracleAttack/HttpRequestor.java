package paddingOracleAttack;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpRequestor {

	public static Logger log=Logger.getLogger(HttpRequestor.class.getName());
	
	public static String execute(String targetURL, String urlParameters) {
		
		
		
		  HttpURLConnection connection = null;  
		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("GET");
		    connection.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");

		    
		    connection.setRequestProperty("Content-Language", "en-US");  

		    connection.setUseCaches(false);
		    connection.setDoOutput(true);

		    int resp=connection.getResponseCode();
		    
		    log.log(Level.FINE,"URL: "+targetURL+"\n"+"Response code: "+HttpCodes.getHttpCodeDescr(resp));
		    return Integer.toString(resp);
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if(connection != null) {
		      connection.disconnect(); 
		    }
		  }
		}
	
}
