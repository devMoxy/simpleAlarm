import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter your alarm time in this format(HH:mm): ");
        String time = scanner.nextLine().trim();

        System.out.print("what is the title of your alarm: ");
        String title = scanner.nextLine().trim().toUpperCase();

        Alarm alarm = new Alarm(title, "src\\alarm.wav", time);
        AlarmPlayer audio = new AlarmPlayer(alarm, scanner);
        Time timer = new Time();

        while(true){
            timer.time();
            if(time.equals(timer.realTime)){
                break;
            }
        }

        System.out.println("\n" + alarm.getAlarmTitle() + "!!!");
        System.out.println("Alarm will run for 30 seconds only \nclick Enter key to stop alarm");
        audio.play();
    }
}
