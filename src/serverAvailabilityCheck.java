import java.util.ArrayList;
import java.util.EnumMap;

/**
 * Created by alice on 04.02.2019.
 */
public class serverAvailabilityCheck {

    public static void main(String[] args) {
        //run in 5seconds
        final long timeInterval = 5000;
        int count = 0;

        while (true) {
            count++;
            System.out.println("Server check round number: "+ count);
            //task to run here:
            check();
            //and task to run ends here
            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void check() {
        //iterate through all server devises and check Host response
        ArrayList<Server> devices = new ArrayList<>();
        //SmokeTest: check if IP address can handle HTTP
        devices.add(new Server("http://8.8.8.8"));
        devices.add(new Server("https://code.while-false.de/alice/bachelor-thesis"));
        devices.add(new Server("https://code.while-false.de"));
        devices.add(new Server("https://github.com/"));
        devices.add(new Server("https://www.youtube.com"));
        devices.add(new Server("https://stackoverflow.com"));

        EnumMap<ServerStatus, String> result = new EnumMap<>(ServerStatus.class);
        result.put(ServerStatus.SUCCESSFUL, "reachable");
        result.put(ServerStatus.REDIRECT, "redirected");
        result.put(ServerStatus.CLIENTERROR, "client error");
        result.put(ServerStatus.SERVERERROR, "server error");
        result.put(ServerStatus.UNCLEARERROR, "error");

        //HttpResponse
        for (Server element : devices) {
            int code = HttpResponseAvailability.ping(element);

            if (code > 0 && code < 300) {
                element.setResult(result.get(ServerStatus.SUCCESSFUL));
            } else if (code >= 300 && code < 400) {
                element.setResult(result.get(ServerStatus.REDIRECT));
            } else if (code >= 400 && code < 500) {
                element.setResult(result.get(ServerStatus.CLIENTERROR));
            } else if (code >= 500) {
                element.setResult(result.get(ServerStatus.SERVERERROR));
            } else if (code < 0) {
                //take the value from ping method
            } else {
                element.setResult(result.get(ServerStatus.UNCLEARERROR));
            }
        }
        tableOutput(devices);
    }

    public static void tableOutput(ArrayList<Server> devices) {
        //Output of the result per each server
        System.out.println("\n" + "--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-50s %30s", "SERVER NAME", "RESULT");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        for (Server server : devices) {
            System.out.printf("%-50s %30s", server.getServername(), server.getResult());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------" + "\n");
    }
}

