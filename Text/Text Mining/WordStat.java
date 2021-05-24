
/**
 * Write a description of class WordStat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordStat
{
    private String word;
    private int count;
    public WordStat(String w)
    {
        word = w;
        count = 1;
    }

    public void incrementCount()
    {
        count++;
    }
}
