package View;
import javax.swing.*;

public class ButtonsPanel {

    JPanel panel = new JPanel();
    JButton botaoStart = new JButton("Start");
    JButton botaoStop = new JButton("Stop");
    JButton botaoReset = new JButton("Reset");

    public JPanel BuildPanel(){

        this.panel.add(botaoStart);
        this.panel.add(botaoStop);
        this.panel.add(botaoReset);
        return this.panel;
    }



    

    
        

    
}
