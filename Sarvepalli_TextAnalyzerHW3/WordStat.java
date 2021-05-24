import java.lang.Comparable;
/**keeps track of each word and the amount of times it is shown in the text */
public class WordStat implements Comparable<WordStat>
//comparable interface that orders the objects of the class "natural ordering"
{
    private String word;
    private int count;
    public WordStat(String w) //object location for each word with information of word and the cout of appearance in the text
    {
        word = w;
        count = 1;
    }

    public void incrementCount() //changes the count of the number of times the word is in the text
    {
        count++;
    }
    
    public int getCount() //gets thte count of the word in the text
    {
        return count;
    }
    
    public String toString() //gets the string of the word in the text
    {
        return word;
    }
    
    public int compareTo(WordStat b) //compares the word count to determine the words that appears more
    {
        return b.getCount() - this.getCount();
    }
}
