
/**
 * Write a description of class Tester here.
 *
 * @author Ashwini for internal maniputlation 
 * @version (a version number or a date)
 */
public class Tester
{
    static int[] numValue = {1,5,10,50,100,500,1000};
    static String[] romValue = {"I","V","X","L","C","D","M"};
    //why is everything static? there is no need to create instance field variables
    public static int romanNum_to_int(String s)
    {

        //total value of the roman numeral to be returned
        int total = 0;
        // tracks the previous value 
        int prevValue = 0;

        //if length is 1, return value that corresponds to the letter
        if (s.length() ==1){
            return total += getValue(s);
        }
        //if length greater than 1:
        else{
            //for loop to go through every element of the string
            for(int i = s.length(); i>=1; i--){
                //value of the left
                int valueLeft = getValue(s.substring(i-1,i));
                
                // if value on left is greater than prevValue, add the values
                if (valueLeft>= prevValue){
                    total += valueLeft; //add
                } 
                //otherwise take value on left, subtract from prevValue
                else{
                    total -= valueLeft; //subtract
                }
                //change prevlue to new calculated valueLeft before going to next element on string
                prevValue = getValue(s.substring(i-1,i));
            }
        }
        return total;
    }

    public static int getValue(String r)
    {
        //go through each element of the string
        for (int i=0;i<romValue.length;i++){
            //because both lists stay the same length and are not dynamic the idex of romValue matches the index of the numValue
            //checks the romValue and finds the corresponding numValue to return
            if(romValue[i].equals(r)){
                return numValue[i];
            }

        }
        //if this isn't here there will be a missing return statemnt, the method has to return an integer
        return -1;
    }  
}
