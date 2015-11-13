
/**
 * Write a description of class RockPaperScissors here.
 * 
 * @author  Alexis Scheerer and Kathy Zhang
 * @version 11/13/15
 */
import java.util.*;
public class RockPaperScissors
{
    Scanner console=new Scanner(System.in);
    public static void main(String[] args){
        playGame();
    }
    public static void playGame(){
        String playerMove, computerMove;
        String endGame="No";
        while (endGame.toLowerCase()!="yes"){
            System.out.println("What is your move?");
            playerMove=console.next();
            computerMove=computerTurn();
            System.out.println("Your move was "+playerMove+" and the computer's move was "+computerMove)
            if (playerWins(playerMove, computerMove)){
                System.out.println("Congratulations, you win!");
            }
            else if(computerWins(playerMove, computerMove)){
                System.out.println("Sorry, the computer won.");
            }
            else{
                System.out.println("It was a tie!");
            }
        }
    }
    public static void computerWins(String playerMove, String computerMove){
        if (playerMove
        
        
}
