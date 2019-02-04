/**
 * Created by alice on 04.02.2019.
 */
public class Server  {
    private String servername;
    private String result;
    private int port;

    // Parameterized Constructor for Host- and Http-Check
    public Server(String servername) {
        this.servername = servername;
    }

    // Parameterized Constructor for Application-Check
    public Server(String servername, int port) {
        this.servername = servername;
        this.port = port;
    }

    // Getter and Setter methods
    public String getServername() {return servername; }
    public String getResult() {return result;}
    public void setResult(String result) {this.result = result;}
    public int getPort(){return  port;}
}

