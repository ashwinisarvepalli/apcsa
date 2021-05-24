import java.util.ArrayList;
import java.io.File;
import java.io.IOException; //input output exception
import java.util.Scanner; // scanner is a utility class that scans a file and extracts tokens

//Note about exceptions : your program crashes when an exception is thrown

//Important points:
//1.look through the API, which packages in API deal with reading files
//2. If exception can be thrown, include a try/catch statement 

public class Starter
{
    // file name for the file we will read throguh
    private static String fileName = "MLKDream.txt";
    //note to self: I'll need to download the above file from schoology
    
    private static ArrayList<WordStat> list_of_words = new ArrayList<WordStat>();
    
    //import the file
    public static void importFile(String fN) throws IOException
    // this methd might throw an IOException --> so add a catch statment at the end of this method
    {
        //this method might throw an IO exception, so we will provide instructions on how to handle this potential scenaria
        try{
            Scanner in = new Scanner(new File(fN));
            //read throguh text file, line by line
            String line = "";
            while(in.hasNextLine()) {
                line = in.nextLine(); //grabs the line, stroes it to a line variable
                System.out.println(line);
                /*
                 * read throguh each line
                 * remove punctuation
                 * convert to lower case
                 * grab each word
                 * if word is not already in list, add it to list
                 * if word is in list, increment counter for word
                 */
                
                //^Not, so regex below means "anything that is not a standard character"
                line.replaceAll("^[a-zA-Z]",""); 
                String[] arrayOfWords = line.split(" ");
                for (int i = 0; i<arrayOfWords.length; i++)
                {
                    arrayOfWords[i] = arrayOfWords[i].toLowerCase();
                    // this changes each word to lower case version
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("There was a problem reading in the file: " + e);
        }
    }
    

}
