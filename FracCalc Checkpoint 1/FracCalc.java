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
        // TODO: Read the input from the user and call produceAnswer with an equation

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        int firstSpaceIndex=input.indexOf(" ");
        String firstOperand=input.substring(0, firstSpaceIndex);
        String secondOperand=input.substring(firstSpaceIndex+3);
        String operator=input.substring(firstSpaceIndex+1, firstSpaceIndex+2);
        return secondOperand;
    }
    /*public static String findOperand1(String input, int firstSpaceIndex){
        return (input.substring(0, firstSpaceIndex));
    }
    public static String findOperand2(String input, int firstSpaceIndex){
        return (input.substring(firstSpaceIndex+3));
    }
    public static String findOperator(String input, int firstSpaceIndex){
        return (input.substring(firstSpaceIndex+1, firstSpaceIndex+2));
    }*/
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
