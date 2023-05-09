import Controller.StopwatchController;
import View.StopwatchView;

public class main {

    public static void main(String[] args) {       
        
        StopwatchView view= new StopwatchView();
        StopwatchController controller = new StopwatchController(view);
        view.setController(controller);
    }
    
}
