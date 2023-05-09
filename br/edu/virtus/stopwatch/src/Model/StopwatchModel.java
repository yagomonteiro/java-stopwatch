package Model;
import java.util.concurrent.TimeUnit;


/**
 * stopwatchModel
 */
public class StopwatchModel implements Runnable{

    private  String TimeToCount;
    private  double TimeInSeconds;
    private  boolean running;
    private  Thread counter;
       


    public StopwatchModel(){
        TimeToCount ="";
        running = false;                 
        
    }

    public void setTimeToCount(String Time){
        if(validateInput(Time)){
            TimeToCount = Time;
            convertToSeconds();
            this.running = true;
        }
        else{
            System.out.println("input invalid");
        }       
    }

    public String getTimeToCount() {
        return TimeToCount;
    }

    public boolean isRunning(){
        return this.running;
    }

    private boolean validateInput(String input){
        boolean isValid = false;
        String regex = "^[0-9]{2}:[0-9]{2}:[0-9]{2}$";

        if(input.matches(regex)){
            isValid = true;
        }
        return isValid;
    }

    private void convertToSeconds(){
        String[] slices = this.TimeToCount.split(":");
        double minute = Integer.parseInt(slices[0]);
        double second = Integer.parseInt(slices[1]);
        double centSecond = Integer.parseInt(slices[2]);        
        this.TimeInSeconds = minute*60 +second+centSecond/100;        
    }

    private String convertToDisplay(){
        long segundosArredondados = Math.round(TimeInSeconds);
        long minutos = TimeUnit.SECONDS.toMinutes(segundosArredondados);
        long segundosRestantes = segundosArredondados - TimeUnit.MINUTES.toSeconds(minutos);
        long centesimos = Math.round((TimeInSeconds - segundosArredondados) * 100);

        return String.format("%02d:%02d:%02d", minutos, segundosRestantes, Math.abs(centesimos));
    }

    public void startCounting(){
        
            System.out.println("entrei");
            this.running = true;
            counter = new Thread(this);
            counter.start();
        
        

    }
    public void stopCounting(){
        if (running){
            counter.interrupt();
            running = false;
        }        
        
    }
    
    @Override
    public void run(){             

        try {
            while(this.TimeInSeconds >0 && this.running ==true){
                // synchronized(lock){
                    this.TimeInSeconds = TimeInSeconds - 0.01;
                    this.TimeToCount = convertToDisplay();
                    System.out.println(TimeInSeconds);
                // }
                
                counter.sleep(10);           
            }
            System.out.println("finalizou a thread");
            counter.interrupt();
            running = false;

        } catch (Exception e) {
            // TODO: handle exception
        }
            

       
    }

}