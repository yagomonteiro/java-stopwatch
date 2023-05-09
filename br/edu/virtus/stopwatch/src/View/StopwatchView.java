package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.StopwatchController;

public class StopwatchView extends JFrame {

    private StopwatchController Controller;
    private ButtonsPanel actionButtonsPanel;
    private DisplayPanel timeDisplayPanel;
    private JTextField TimeInput;

    public void setController(StopwatchController controller){
        this.Controller = controller;
    }

    public StopwatchView(){

        super("Stopwatch");

        actionButtonsPanel= new ButtonsPanel();
        timeDisplayPanel = new DisplayPanel();
        TimeInput = new JTextField("Insert Time to count in format 00:22:11");

        
        this.setStartButtonListener();
        this.setStopButtonListener();
        this.setResetButtonListener();

        this.add(actionButtonsPanel.BuildPanel(), BorderLayout.SOUTH);
        this.add(TimeInput);
        this.add(timeDisplayPanel.buildPanel(),BorderLayout.NORTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    public String getInputField(){
        return TimeInput.getText();

    }

    public void UpdateDisplayInfo(String TimeDisplay){
        this.timeDisplayPanel.UpdateText(TimeDisplay);       

    }

    private void setStartButtonListener(){
        if(actionButtonsPanel != null){
            this.actionButtonsPanel.botaoStart.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                Controller.StartButtonAction();
             }    
            });
        }
    }

    private void setStopButtonListener(){
        if(actionButtonsPanel != null){
            this.actionButtonsPanel.botaoStop.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                Controller.StopButtonAction();
             }    
            });
        }
    }

    private void setResetButtonListener(){
        if(actionButtonsPanel != null){
            this.actionButtonsPanel.botaoReset.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                Controller.ResetButtonAction();
             }    
            });
        }
    }
    
}
