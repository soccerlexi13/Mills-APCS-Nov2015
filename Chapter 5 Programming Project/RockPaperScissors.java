/**
 * Rock Paper Scissors partner assignment
 * 
 * @author  Alexis Scheerer and Kathy Zhang
 * @version 11/13/15
 */
import java.util.*;
public class RockPaperScissors
{
    public static Scanner console=new Scanner(System.in);
    public static void main(String[] args){
        playGame();
    }
    public static void playGame(){
        //main method for the program, controls all aspects of game
        String playerMove, computerMove;
        //initializes continueGame so it can be used in the first test for the while loop
        String continueGame="yes";
        while (!continueGame.equals("no")){
            System.out.println("What is your move?");
            playerMove=console.next(); //stores user input in variable playerMove
            playerMove=playerMove.toLowerCase(); //converts playerMove to all lowercase so it is easier to use
            while (!(playerMove.equals("rock")) && !(playerMove.equals("paper")) && !(playerMove.equals("scissors"))){
                //keeps asking for proper input if invalid
                System.out.println("Invalid input, please enter rock, paper, or scissors.");
                playerMove=console.next(); //stores user input in variable playerMove
                playerMove=playerMove.toLowerCase(); //converts playerMove to all lowercase so it is easier to use
            }
            computerMove=computerTurn(); //calls computerTurn to determine the computer's move
            System.out.println("Your move was "+playerMove+" and the computer's move was "+computerMove);
            //prints out tie/win/loss according to the two moves
            if (playerWins(playerMove, computerMove)){
                System.out.println("Congratulations, you win!");
            }
            else if(computerWins(playerMove, computerMove)){
                System.out.println("Sorry, the computer won.");
            }
            else{
                System.out.println("It was a tie!");
            }
            System.out.println("Play again(no to quit)?"); //no acts as sentinel, asking for input here
            continueGame=console.next();
            continueGame=continueGame.toLowerCase(); //converts to lowercase for easier use/comparison
        }
        System.out.println("Okay, thanks for playing!"); //closing message when game over
    }
    public static boolean computerWins(String playerMove, String computerMove){
        //checks all conditions in which the computer would win and returns true if it did, else returns false
        if (computerMove.equals("rock") && playerMove.equals("scissors")){
            return true;
        }
        else if (computerMove.equals("paper") && playerMove.equals("rock")){
            return true;
        }
        else if (computerMove.equals("scissors") && playerMove.equals("paper")){
            return true;
        } else{
            return false;
        }
    }
    public static boolean playerWins(String playerMove, String computerMove){
        //checks all conditions in which the player would win and returns true if it did, else returns false
        if (playerMove.equals("rock") && computerMove.equals("scissors")){
            return true;
        }
        else if (playerMove.equals("paper") && computerMove.equals("rock")){
            return true;
        }
        else if (playerMove.equals("scissors") && computerMove.equals("paper")){
            return true;
        } else{
            return false;
        }
    }
    public static String computerTurn(){
        //picks random number from 0 to 2, returns computer's move that occurs as a result (0 is rock, etc.)
        Random r=new Random();
        int compMove=r.nextInt(3);
        if (compMove==0){
            return "rock";
        }
        else if (compMove==1){
            return "paper";
        }
        else{
            return "scissors";
        }
    }
}