//backend

import java.util.Random;

public class RPS {
    // all of the choices that a computer can choose
    private static final String[] computerChoices = {"Rock","Paper","Scissors"};

    public String getComputerChoice(){
        return computerChoice;
    }

    public int getComputerScore(){
        return computerScore;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    //store the computer choice so that we can retrieve the value and display it to the frontend
    private String computerChoice;

    //store the scores so that we can retrieve the values and display it to the frontend
    private int computerScore,playerScore;

    //use to generate a random number to randomly choose an option for the computer
    private Random random;

    //constructor to initialize random object
    public RPS(){
        random = new Random();
    }

    // call this method to begin playing rock paper scissor
    //playerChoice is the choice made by the player (ie rock ,paper ,or scissor)
    //this method will return the result of the game(ie computer win,player win ,draw)
    public String playRPS(String playerChoice){
        // generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        
        // will contain the returning message indicating the result of the game
        String result;

        //evaluate the winner
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result = "Player wins";
                playerScore++;

            }else if (playerChoice.equals("Scissors")){
                result = "Computer wins";
                computerScore ++;
            }else{
                result = "Draw";
            }
        }else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissors")){
                result = "Player wins";
                playerScore++;

            }else if (playerChoice.equals("Rock")){
                result = "Computer wins";
                computerScore ++;
            }else{
                result = "Draw";
            }
        }else{
            //computer chooses scissors

                if(playerChoice.equals("Rock")){
                    result = "Player wins";
                    playerScore++;
    
                }else if (playerChoice.equals("Paper")){
                    result = "Computer wins";
                    computerScore ++;
                }else{
                    result = "Draw";
                
            }

        }
        return result;
    }

}
