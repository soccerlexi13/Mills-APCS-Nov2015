 /* Fraction calculator project (checkpoint 3)
  * 
  * @Author Alexis Scheerer
  * @Version 11/20/15
  */
import java.util.*;
public class FracCalc {
    /*
       NOTES: TESTS DO NOT WORK WITH NEGATIVES WHEN THE WHOLE NUMBER IS NEGATIVE
       IT'S BECAUSE WHEN THE WHOLE IS NEGATIVE YOU SUBTRACT FROM THE NUMERATOR WHEN YOU MAKE IT IMPROPER
       */
    public static void main(String[] args) 
    {
       Scanner console=new Scanner(System.in);
       String userInput;
       String keepGoing="yes";
       while (! (keepGoing.toLowerCase()).equals("quit")){
           //while loop to keep receiving input until user decides to quit
           System.out.println("What is your equation?");
           userInput=console.nextLine();
           System.out.println(produceAnswer(userInput));
           System.out.println("Do you want to continue? (quit to exit)");
           keepGoing=console.nextLine();
       }
        //reads the input from the user and calls produceAnswer with an equation
    }
    public static String produceAnswer(String input){ 
        //produces the solution to the input
        //index of first spaces needed to separate into two operands and operator
        String answer;
        int firstSpaceIndex=input.indexOf(" ");
        String firstOperand=input.substring(0, firstSpaceIndex);
        String secondOperand=input.substring(firstSpaceIndex+3);
        String operator=input.substring(firstSpaceIndex+1, firstSpaceIndex+2);
        //need indices of slashes and underscores to use in parsing methods
        int firstSlash=firstOperand.indexOf("/");
        int firstUnder=firstOperand.indexOf("_");
        int secondSlash=secondOperand.indexOf("/");
        int secondUnder=secondOperand.indexOf("_");
        //variables for each operand's parts found by calling methods
        int secondWhole=findWhole(secondOperand, secondSlash, secondUnder);
        int secondNumerator=findNumerator(secondOperand, secondSlash, secondUnder);
        int secondDenominator=findDenominator(secondOperand, secondSlash);
        int firstWhole=findWhole(firstOperand, firstSlash, firstUnder);
        int firstNumerator=findNumerator(firstOperand, firstSlash, firstUnder);
        int firstDenominator=findDenominator(firstOperand, firstSlash);
        firstNumerator+=wholeAsNumerator(firstWhole, firstDenominator);
        secondNumerator+=wholeAsNumerator(secondWhole, secondDenominator);
        if(operator.equals("+")){
            answer=addOrSubtractNums(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
        }
        else if(operator.equals("-")){
            answer=addOrSubtractNums(firstNumerator, firstDenominator, secondNumerator*(-1), secondDenominator);
        }
        else if(operator.equals("/")){
            answer=multiplyOrDivideNums(firstNumerator, firstDenominator, secondDenominator, secondNumerator);
        }
        else{
            answer=multiplyOrDivideNums(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
        }
        return (answer);
    }
    public static int findNumerator(String operand, int slashIndex, int underIndex){
        //method to find numerator and convert it to int
        int numerator=0; //initialized to 0 so if no numerator, it returns 0
        if (slashIndex>=0){
            //slash must be present for numerator to exist
            if(underIndex>=0){
                //if _ exists, numerator must come after
                numerator=Integer.parseInt(operand.substring(underIndex+1, slashIndex), 10);
            }
            else{
                //if no _, numerator is first number
                numerator=Integer.parseInt(operand.substring(0, slashIndex), 10);
            }
        }
        return(numerator);
    }
    public static int findDenominator(String operand, int slashIndex){
        int denominator=1; //if no fraction, denom is always 1
        if (slashIndex>=0){
            //if slash, then there is a denom other than one, comes after slash
            denominator=Integer.parseInt(operand.substring(slashIndex+1), 10);
        }
        return(denominator);
    }
    public static int findWhole(String operand, int slashIndex, int underIndex){
        int whole=0; //if not found, there is no whole so it is 0
        if (underIndex>=0){
            //is there is an _, whole is up until then
            whole=Integer.parseInt(operand.substring(0, underIndex), 10);
        }
        else if(slashIndex==-1){
            //if no fraction, whole is entire operand
            whole=Integer.parseInt(operand, 10);
        }
        return(whole);
    }
    public static String addOrSubtractNums(int numerator1, int denominator1, int numerator2, int denominator2){
        numerator1*=denominator2;
        numerator2*=denominator1;
        int answerNumerator=numerator1+numerator2;
        int answerDenominator=denominator1*denominator2;
        return(simplifySolution(answerNumerator, answerDenominator));
    }
    public static String multiplyOrDivideNums(int numerator1, int denominator1, int numerator2, int denominator2){
        int answerNumerator=numerator1*numerator2;
        int answerDenominator=denominator1*denominator2;
        return(simplifySolution(answerNumerator, answerDenominator));
    }
    public static int wholeAsNumerator(int whole, int denominator){
        return(whole*denominator);
    }
    public static String simplifySolution(int numerator, int denominator){
        int whole=numerator/denominator;
        numerator %= denominator;
        int greatestCF=1;
        String answer;
        for (int i=1; i<=Math.abs(denominator); i++){
            if (denominator%i==0 && numerator%i==0){
                greatestCF=i;
            }
        }
        numerator /= greatestCF;
        denominator /= greatestCF;
        if (numerator>0){
            answer= numerator+"/"+denominator;
            if (whole>0){
                answer=whole+"_"+answer;
            }
        }
        else{
            answer=Integer.toString(whole);
        }
        return answer;
    }
}
