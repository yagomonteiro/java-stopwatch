package Controller;

import Model.StopwatchModel;
import View.StopwatchView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class StopwatchController implements Runnable {

    private StopwatchView view;
    private StopwatchModel model;
    private Timer timer;
    private int InfoUpdateTime;    
    private Thread taskUpdate;
    private boolean startWasPreviouslyPressed;
    private boolean stopWasPreviouslyPressed;


    public StopwatchController(StopwatchView view){
        this.view = view;//lembrar que em java ele recebe um apontador e nao objeto
        this.model = new StopwatchModel();
        this.model.setTimeToCount("00:10:22");
        this.startWasPreviouslyPressed = false;
    }
    
    public void StartButtonAction(){
        
        System.out.println("START!");

        if(!startWasPreviouslyPressed){
            String inputFieldString = this.view.getInputField();
            this.model.setTimeToCount(inputFieldString);
            view.UpdateDisplayInfo(model.getTimeToCount());
            startWasPreviouslyPressed = true;           
            
        }

        else if(startWasPreviouslyPressed && stopWasPreviouslyPressed){
            view.UpdateDisplayInfo(model.getTimeToCount()); 
        }
        
        
        // if(!startWasPreviouslyPressed){
        //     startWasPreviouslyPressed = true;
        //     stopWasPreviouslyPressed = false;
        // } else {
        //     System.out.println("start was poressed before");
        //     if(model.isRunning()){
        //         System.out.println("tava rodando");
        //     }else{
        //         String inputFieldString = this.view.getInputField();
        //         this.model.setTimeToCount(inputFieldString);
        //         view.UpdateDisplayInfo(model.getTimeToCount());
                
        //     }
            
            
        // }
        
        model.startCounting();
        UpdateTask();      
        
           
    }

    public void UpdateTask(){
        taskUpdate = new Thread(this);
        taskUpdate.start();

    }

    public void run(){
        try {
            while(true)
            {
                UpdateDisplay(model.getTimeToCount());
                Thread.sleep(5);
            }
            
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    

    public void StopButtonAction(){
        System.out.println("STOP!");
        model.stopCounting();
        
    } 

    public void ResetButtonAction(){
        System.out.println("RESET!");
        model.setTimeToCount("00:00:00");
        view.UpdateDisplayInfo(model.getTimeToCount());
        startWasPreviouslyPressed = false;
    }

    public void UpdateDisplay(String DisplayString){
        view.UpdateDisplayInfo(DisplayString);
    }
}
