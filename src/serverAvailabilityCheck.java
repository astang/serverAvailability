import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Scanner;
import java.io.*;
/**
 * Created by alice on 04.02.2019.
 */
public class serverAvailabilityCheck {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //Set the server list
        ArrayList<Server> devices = new ArrayList<>();

        System.out.println("Choose your option:"+"\n" +" 1. Read a .csv file "+ "\n" +" 2. Use manual input function");
        int option = scanner.nextInt();
        if (option == 1 ){
            //Throw Exception in Main Head method
            System.out.println("Enter your file path "+"\n"+"(i.e. 'C:/serverlist.csv') ");
            Scanner readfilepath = new Scanner(System.in);
            String filepath = readfilepath.nextLine();
            if (!filepath.isEmpty()) {
                Scanner scanner_readcsv = new Scanner(new File(filepath));
                scanner_readcsv.useDelimiter(",");
                while (scanner_readcsv.hasNext()) {
                    String server = scanner_readcsv.next();
                    devices.add(new Server(server));
                }
                scanner_readcsv.close();
            }
        }else if (option == 2){
            //Set the server list with manual input
            System.out.println("Enter the number of server to check: ");
            int amountserver = scanner.nextInt();
            System.out.println("\n" + "Add your server name: ");
            //enable user input: add server list manually to device list
            for (int i = 0; i <= amountserver; i++) {
                String servername = scanner.nextLine();
                if (!servername.equals("")) {
                    devices.add(new Server(servername));
                    System.out.println(i + " server added! ");
                }
            }
        }else{
            System.out.println("Invalid option!");
        }


        //Set the interval time
        System.out.println("\n" + "Enter time update interval: "+"\n"+"(i.e. 1 for 1 second) ");
        int userinputtime = scanner.nextInt();
        final long timeInterval = userinputtime * 1000;
        System.out.println("\n" + "Your server will be checked each " + userinputtime + " seconds ");
        int count = 0;

        //Set server status dictionary
        EnumMap<ServerStatus, String> result = new EnumMap<>(ServerStatus.class);
        result.put(ServerStatus.SUCCESSFUL, "reachable");
        result.put(ServerStatus.REDIRECT, "redirected");
        result.put(ServerStatus.CLIENTERROR, "client error");
        result.put(ServerStatus.SERVERERROR, "server error");
        result.put(ServerStatus.UNCLEARERROR, "error");

        //Check each server-url
        while (true) {
            count++;
            System.out.println("Server check number: " + count);
            for (Server element : devices) {
                int code = HttpResponseAvailability.ping(element);
                //Set the server availability result
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

            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Console Output structure
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