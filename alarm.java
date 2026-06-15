import java.util.Scanner;

public class Alarm {
    public String filePath  = "src\\alarm.wav";
    public String alarmTitle;
    public String alarmTime;

    public Alarm(String alarmTitle, String filePath, String alarmTime){
        this.alarmTitle = alarmTitle;
        this.filePath = filePath;
        this.alarmTime = alarmTime;
    }
}
