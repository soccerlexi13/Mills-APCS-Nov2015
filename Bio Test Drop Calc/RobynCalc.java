
/**
 * Calculate which test grade Robyn should drop for bio
 * 
 * @author Alexis Scheerer
 * @version 12/9/15
 */
public class RobynCalc
{
    public static void main(String[] args){
        double[] testNum= {47.5, 32.0, 45.0, 50.0, 43.5, 60.0, 30.5};
        double[] testDen= {50.0, 33.0, 46.0, 50.0, 45.0, 67.0, 34.0};
        System.out.println(findGradeToDrop(testNum, testDen));
    }
    public static String findGradeToDrop(double[] nums, double[] dens){
        double numTotal=0;
        double denTotal=0;
        double biggestGrade=0;
        double bigNum=0;
        double bigDen=0;
        for (int i=0; i<nums.length; i++){
            numTotal=0;
            denTotal=0;
            for (int j=0; j<i; j++){
                numTotal+=nums[j];
                denTotal+=dens[j];
            }
            for (int j=i+1; j<nums.length; j++){
                numTotal+=nums[j];
                denTotal+=dens[j];
            }
            System.out.println(numTotal/denTotal);
            if(numTotal/denTotal>biggestGrade){
                biggestGrade=numTotal/denTotal;
                bigNum=nums[i];
                bigDen=dens[i];
            }
        }
        return("The biggest grade possible is: "+biggestGrade+" when you remove the grade "+bigNum+"/"+bigDen);
    }
}
