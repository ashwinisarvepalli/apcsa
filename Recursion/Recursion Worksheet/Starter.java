
/**
 * Write a description of class Starter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Starter
{
    //CLASS PSEUDO CODE:
    //Declare empty string to stare reversed string
    // loop through original string, end to beginning
    //take each character, concatenate into reversed string
    public static String reverse (String s)
    {
        String reversed = " ";
        for (int  i = s.length()-1; i >=0; i--)
        {
            reversed += s.charAt(i);
        }
        return reversed;
    }
    
    public static boolean palindrome (String s)
    {
        boolean verdict;
        String reversed = " ";
        for (int  i = s.length()-1; i >=0; i--)
        {
            reversed += s.charAt(i);
        }
        if (reversed == s){
            verdict = true;
        }
        else{
            verdict = false;
        }
        return verdict;
    }
    
    public static boolean isPal(String s)
    {   // base case: if length is 0 or 1 then String is palindrome
        // if length is 0 or 1 then String is palindrome
        if(s.length() == 0 || s.length() == 1){
            return true; 
        }
        //recursive call
        if(s.charAt(0) == s.charAt(s.length()-1))
        /* check for first and last char of String:
         * if they are same then do the same thing for a substring
         * with first and last char removed. and carry on this
         * until you string completes or condition fails
         * Function calling itself: Recursion
         */
        {
            return isPal(s.substring(1, s.length()-1));
        }
        /* If program control reaches to this statement it means
         * the String is not palindrome hence return false.
         */
        return false;
    }
}
