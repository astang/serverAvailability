import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by alice on 04.02.2019.
 */

public class HttpResponseAvailability {
    public static int ping(Server element) {
        //do pingcheck and add the results into the Array too

        try {
            //Sending ping request to element
            URL url = new URL(element.getServername());
            HttpURLConnection connection = (HttpURLConnection)url.openConnection() ;
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            return code;
        } catch (UnknownHostException e) {
            System.err.println( element.getServername() + " does not exist");
            element.setResult("Host Exception");
            return -1;
        } catch (IOException e) {
            System.err.println(element.getServername() + " Error in reaching Host");
            element.setResult("IO Exception");
            return -2;
        }

    }

}
