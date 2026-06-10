import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static String realTime;
    public static String filePath  = "src\\alarm.wav";
    public static String alarmTitle;
    public static String alarmTime;
    public static String displayTime;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter your alarm time in this format(HH:mm): ");
        alarmTime = scanner.nextLine().trim();
        System.out.print("what is the title of your alarm: ");
        alarmTitle = scanner.nextLine().trim().toUpperCase();

        while(true){
            time();
            if(alarmTime.equals(realTime)){
                break;
            }
        }
        System.out.println("\n" + alarmTitle + "!!!");
        System.out.println("Alarm will run for 30 seconds only \nclick Enter key to stop alarm");
        getAudio();
    }

    public static void time(){
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

    public static void getAudio(){
        try{
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            countdown timer = new countdown();
            clip.start();
            Thread thread = new Thread(() -> {
                try{
                    timer.run();
                    Thread.sleep(clip.getMicrosecondLength() / 1000);
                }
                catch(InterruptedException e){
                    System.out.println("Interruption occurred");
                }
            });
            thread.start();
            scanner.nextLine();
            System.out.println("Alarm stopped!");
            System.exit(0);
        }
        catch(UnsupportedAudioFileException e ){
            System.out.println("Unsupported audio file");
        }
        catch(LineUnavailableException e){
            System.out.println("Audio system is busy");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }

    }

}
