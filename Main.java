import javax.sound.sampled.*;
import java.util.*;

public class Main {

    public static String filePath  = "src\\alarm.wav";
    public static String alarmTitle;
    public static String alarmTime;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter your alarm time in this format(HH:mm): ");
        alarmTime = scanner.nextLine().trim();
        System.out.print("what is the title of your alarm: ");
        alarmTitle = scanner.nextLine().trim().toUpperCase();

        Alarm alarm = new Alarm(alarmTitle, filePath, alarmTime);
        AlarmPlayer audio = new AlarmPlayer();
        Time timer = new Time();

        while(true){
            timer.time();
            if(alarmTime.equals(timer.realTime)){
                break;
            }
        }

        System.out.println("\n" + alarmTitle + "!!!");
        System.out.println("Alarm will run for 30 seconds only \nclick Enter key to stop alarm");
        audio.play();
    }
}
