import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AlarmPlayer {

    public void play(){
        try{
            File audioFile = new File(Main.filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            Countdown timer = new Countdown(30);
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
            Main.scanner.nextLine();
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
