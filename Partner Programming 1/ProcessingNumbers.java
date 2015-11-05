/**
 * Takes string of numbers, adds them all together
 * 
 * @author Alexis Scheerer 
 * @version 11/4/2015
 */
import java.util.*;
public class ProcessingNumbers
{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.print("How many numbers will you input? ");
        int numberOfNums=console.nextInt();
        System.out.print("What are your numbers? ");
        double next=console.nextDouble();
        double max=next;
        double min=next;
        double sumOfEven;
        if(next%2==0){
            sumOfEven=next;
        }
        else{
            sumOfEven=0;
        }
        double maxEven=1;
        for (int i=1; i<=numberOfNums-1; i++){
            next=console.nextDouble();
            if(next>max){
                max=next;
            }
            else if(next<min){
                min=next;
            }
            if(next%2==0){
                if(sumOfEven==0 || next>maxEven){
                    maxEven=next;
                }
                sumOfEven+=next;
            }
        }
        if(max==min){
            System.out.println("The biggest and smallest numbers are the same, "+max);
        }
        else{
            System.out.println("The biggest number is "+max+" and the smallest number is "+min);
        }
        System.out.println("The sum of all even numbers is "+sumOfEven);
        if(maxEven==1){
            System.out.println("No even numbers were entered, so there is no largest even number.");
        }
        else{
            System.out.println("The greatest even number is "+maxEven);
        }
    }
}
