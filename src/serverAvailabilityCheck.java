import java.util.ArrayList;

/**
 * Created by alice on 04.02.2019.
 */
public class serverAvailabilityCheck {

    public static void main(String[] args){
        //set the interval frequency
        final long timeInterval = 5000;
        int count = 0;

        while (true){
            count++;
            System.out.println(count);
            //TODO: tasks to run here frequently:


            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO: Check availabilty methode
    public static void check (){}

    //TODO: Output stucture
    public static void tableOutput(ArrayList<Server> devices) {}

}



