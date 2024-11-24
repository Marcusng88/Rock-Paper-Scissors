import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
//frontend
public class RPSGUI extends JFrame implements ActionListener{
     //player buttons
    JButton rockButton, paperButton ,scissorButton;

    // will display the choice of the computer 
    JLabel computerChoice;

    //will display the score of the computer and the player
    JLabel computerScoreLabel, playerScoreLabel;

    //backend obj
    RPS rPS;

    public RPSGUI(){


        //invoke jframe constructor and add title to the GUI
        super("ROCK PAPER SCISSOR");
        
        //set the size of the GUI
        setSize(450,574);

        //set layout to null to disable layout management ,so we can absolute positioning for the elements
        //(ie setting x,y coordinates and width/height values)
        setLayout(null);

        // terminate the java virtual machine then closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // load GUI in the center of the screen every time we run the application
        setLocationRelativeTo(null);

        //initialize the backend obj
        rPS = new RPS();

        //add GUI components
        addGuiComponents();
    }
    private void addGuiComponents(){
        //create computer score label
        computerScoreLabel = new JLabel("Computer: 0 ");

        // set x,y coordinates and width/ height values
        computerScoreLabel.setBounds(0,43,450,30);

        // set the font to have a font family of dialog ,front weight of bold ,and a font size of 26
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));

        //place the text in the center 
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add to GUI
        add(computerScoreLabel);

        // create computer choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175,118,98,98);
        computerChoice.setFont(new Font("Dialog",Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add (computerChoice);

        // create player score label
        playerScoreLabel = new JLabel("Player: 0 ");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog",Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player button

        //rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165,387,105,81);
        paperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissor button
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290,387,105,81);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.addActionListener(this);
        add(scissorButton); 

        


    }
    //displays a message dialog which will show the winner and a try again button to play again
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this,"Result",true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);


        //message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        //try again button
        JButton tryagainButton = new JButton("Try Again");
        tryagainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // reset computer choice
                computerChoice.setText("?");

                // close the dialog box
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryagainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e){
        // get player choice
        String playerChoice = e.getActionCommand().toString();

        //play rock paper scissor and store result into string var
        String result = rPS.playRPS(playerChoice);

        //load computer choice
        computerChoice.setText(rPS.getComputerChoice());

        //update score
        computerScoreLabel.setText("Computer: "+ rPS.getComputerScore());
        playerScoreLabel.setText("Player: "+rPS.getPlayerScore());

        //display result dialog
        showDialog(result);
    }
}
