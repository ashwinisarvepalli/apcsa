/**
 * Write a description of class Starter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Starter
{
    public static void main(String[] args)
    {
        //create instance of GameBoard class
        GameBoard gb = new GameBoard();
        //print and solve the knight's tour
        gb.printBoard(gb.solve(0,0));
    }

    public void generatePath(int r, int c) {
    }

}
