public class countdown implements Runnable{

    @Override
    public void run(){
        for(int i = 1; i <= 30; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception!");;
            }
            if(i == 30){
                System.exit(0);
            }
        }
    }
}
