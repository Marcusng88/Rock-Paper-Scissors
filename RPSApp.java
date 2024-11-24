import javax.swing.*;

public class RPSApp{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                // instantiate a rps obj
                RPSGUI RPSGUI = new RPSGUI();

                //display the GUI
                RPSGUI.setVisible(true);
            }
        });
    }
}