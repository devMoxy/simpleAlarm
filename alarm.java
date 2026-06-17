import java.util.Scanner;

public class Alarm {
    private String filePath  = "src\\alarm.wav";
    private final String alarmTitle;
    private final String alarmTime;

    public Alarm(String alarmTitle, String filePath, String alarmTime){
        this.alarmTitle = alarmTitle;
        this.filePath = filePath;
        this.alarmTime = alarmTime;
    }

    public String getFilePath(){
        return filePath;
    }

    public String getAlarmTime(){
        return alarmTime;
    }

    public String getAlarmTitle(){
        return alarmTitle;
    }
}
