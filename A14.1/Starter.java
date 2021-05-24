
import java.util.Random;
public class Starter
{
    static int diceone; //the first dice initialized
    static int dicetwo; // the second dice intialized
    static int dicethree; // the third dice initialized
    static int count = 1; //set count to one because it is rolled once already when the random number is generates
    static boolean go = true; // have the boolean go for the loop to work be continuous until stopped
    public static void main(String[] args)
    {
        while (go)
        {
            Random random = new Random();
            diceone = random.nextInt(6)+1; //rolls the first dice (get the random number) 6 becomes the maximum and 1 the minimum
            dicetwo = random.nextInt(6)+1; // rolls the second dice (get the random number) 6 becomes the maximum and 1 the minimum
            dicethree = random.nextInt(6) + 1; // rolls the third dice (get the random number) 6 becomes the meximum and 1 the minimum
            System.out.println("Dice 1: " + diceone + " Dice 2: " + dicetwo + " Dice 3: " + dicethree); //print out the results of each dice
            if(diceone == dicetwo) // check the option if the first and second dice are the same number
            {
                count += 1; // change the count which is the dice count
            } else if (diceone == dicethree) //check the option if the first and third dice are the same number
            {
                count += 1; // change the count which is the dice count
            } else if (dicetwo == dicethree) //check the option if the second and third dice are the same number
            {
                count += 1; // change the count which is the dice count
            } else{
                System.out.println( "Count: " + count);//prints the count of rolls
                break; // stop the loop
            }
        }
    }
}
