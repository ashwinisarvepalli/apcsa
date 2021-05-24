import java.util.Random;
public class GameBoard
{
    int[][] gB; //create 2D array gB
    int step = 1; //initialize step to 1 (first square visited)
    Random random; //random object instantiated
    int[][] pieceMoves = {{1,-2}, {2,-1}, {2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}}; //negative numbers go top left and positive go bottom right
    public GameBoard()
    {
        gB = new int[8][8]; //initialize new 2D array of ints, all defaulted to 0, make gameboard
        random = new Random(); //initialize random object
    }

    //method to move knight accross gameboard
    public int[][] solve(int row, int col) {
        
        while(gB[row][col] == 0) {     
            gB[row][col] = step++; //as it goes to the next step, change the step number for the next spot

            int times = 0;//variable to time out when generating random moves
            int deltar = 0; //variable for the "x"; change in row for the step
            int deltac = 0; //variable for the "y"; change in column for the step
            do { //do the action at least 1 time before checking the while condition
                times++; //add to times as it is checking the first combination
                int[] randomMove = pieceMoves[random.nextInt(pieceMoves.length)];//chooses a random move
                deltar = randomMove[0]; //the x value of the coordinate which corresponds to the row change
                deltac = randomMove[1]; // the y value of the coordinate which corresponds to the column change                                
            } while((row+deltar<0 || row+deltar>=pieceMoves.length || col+deltac<0 || col+deltac>=pieceMoves.length || gB[row+deltar][col+deltac] != 0) && times < 8);
            //first four condition make sure to not go out of bounds of the gameboard
            //condition for the row and column of gB to not be 0, meaning that a step was not taken in that spot
            //because of the random implementation, times is used so if it's stuck it doesn't keep looking for more move options
            //true and true for times, means the loop continues
            
            // this means that the do-while terminates because it was unable to find a coordinate that works
            if(times >= 8) {
                return gB;
            }
            row += deltar; //change to new row value, and go through code again
            col += deltac; // change to new col value, and go through code again
        }
        return gB; //returns the final 2D array where the knight is unable to continue moving
    }
    
    //print out the 2D array
    public void printBoard(int[][] thearray) {
        //go through each element of the array
        for (int[] x : thearray)
        {
            //gets the "step number" 
            for (int y : x)
            {
                System.out.printf("%-5d", y); //format the gameboard by using printf, and lined with the left side
            }
            System.out.println(); //change to next line
        }

        System.out.println("\n"+ (step-1) + " squares were visited"); //print the number of squares visited

    }
}
