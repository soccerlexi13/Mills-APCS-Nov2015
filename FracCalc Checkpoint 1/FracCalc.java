 /* Fraction calculator project (checkpoint 1)
  * 
  * @Author Alexis Scheerer
  * @Version 11/20/15
  */
import java.util.*;
public class FracCalc {
    public static void main(String[] args) 
    {
        Scanner console=new Scanner(System.in);
        System.out.println("What is your equation?");
        String userInput=console.nextLine();
        System.out.println(produceAnswer(userInput));
        //reads the input from the user and call produceAnswer with input

    }
    public static String produceAnswer(String input)
    { 
        //produces the solution to the input for checkpoint 1
        int firstSpaceIndex=input.indexOf(" ");
        String firstOperand=input.substring(0, firstSpaceIndex);
        String secondOperand=input.substring(firstSpaceIndex+3);
        String operator=input.substring(firstSpaceIndex+1, firstSpaceIndex+2);
        return secondOperand;
    }
}