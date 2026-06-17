import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public String realTime;
    public String displayTime;

    public void time(){
        LocalTime now = LocalTime.now();
        realTime = now.format(DateTimeFormatter.ofPattern("HH:mm"));
        displayTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.print("\r" + "Current time: " + displayTime);
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Interception occurred");
        }
    }
}
