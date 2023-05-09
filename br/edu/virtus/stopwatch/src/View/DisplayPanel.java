package View;
import javax.swing.*;
import java.awt.Font;

public class DisplayPanel extends JFrame {

    JPanel panel = new JPanel();
    JLabel display = new JLabel();

    /**
     * 
     */
    DisplayPanel(){
        display.setFont(new Font("Arial", Font.BOLD, 36));
        display.setText("00:22:11");        
    }  

    public void UpdateText(String timeToGo){
        this.display.setText(timeToGo);
    }

    public JPanel buildPanel(){
        panel.add(display);
        return this.panel;
    }

    

  



    
}
