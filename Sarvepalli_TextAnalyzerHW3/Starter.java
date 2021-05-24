import java.util.ArrayList;
import java.io.File;
import java.io.IOException;  //input output exception
import java.util.Scanner; // scanner is a utility class that scans a file and extracts tokens
//Note about exceptions : your program crashes when an exception is thrown
import java.util.Collections; // used for storing groups of objects
//Important points:
//1.look through the API, which packages in API deal with reading files
//2. If exception can be thrown, include a try/catch statement 

//Order:
//1.Need to store all the words
//2.Analyze and sort the list of words based off frequency
//3.And then since he wants the count averaged over the all the words, keep a counter for the number of words in the text

public class Starter
{
    //file name for the file we will read through
    private static String fileName = "MLKDream.txt";
    private static ArrayList<WordStat> list_of_words = new ArrayList<WordStat>();
    //import the file
    public static void importFile(String fN) throws IOException
    {
        //this method might throw an IO Exception, so we will provide instructions on how to handle this potential scenario
        try 
        {
            int wordCount = 0; //number of total words to later calcuate the percentage
            Scanner in = new Scanner(new File(fN));
            //read through text file, line by line
            String line = "";
            while(in.hasNextLine())
            {
                line = in.nextLine();//grabs the line, stores it to line variable
                //^: NOT, so regex below means "anything that is not a standard character"
                line.replaceAll("^[a-zA-Z]", "");
                String[] arrayOfWords = line.split(" ");
                for(int i = 0; i<arrayOfWords.length; i++)
                {
                    wordCount++; //add to the total word count
                    arrayOfWords[i] = arrayOfWords[i].toLowerCase();
                    //this changes each word to lower case version
                    int wordInList = checkWordInList(arrayOfWords[i]); //checks the word in the list
                    if (wordInList == -1) { //if there is no count for the word, then add the word to the list
                        list_of_words.add(new WordStat(arrayOfWords[i]));
                    } else{ //if the word exists in the list then increment the count of the word
                        list_of_words.get(wordInList).incrementCount();
                    }
                }
            }
            Collections.sort(list_of_words);// sorts the words into order
            for (int i=0; i<20; i++) { //prints out the top 20 words
                WordStat word = list_of_words.get(i);
                System.out.println(word + " is " + (word.getCount()*1./wordCount) + " of all the words");
            }
        }
        catch(IOException e) //the exception
        {
            System.out.println("There was a problem reading in the file: " + e);
        }
    }
    //helper method that would check if a word is already in list
    public static int checkWordInList(String w)
    {
        //go thorugh list of words that has been generated
        for (int i=0; i<list_of_words.size();i++){
            if(list_of_words.get(i).toString().equalsIgnoreCase(w)){
                return i; //gets the item of the list and compares it with the input while applying the equalsignorecase ignoring capitalization
            }
        }
        return -1; //if word is not on the list, return -1 in order for this method to be called upon in the method adding words to the list_of_words
    }
}
