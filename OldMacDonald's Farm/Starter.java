import java.util.ArrayList;
/**
 * Write a description of class Starter here.
 *
 * @author Ashwini Sarvepalli
 * @version 10-31-18
 */
public class Starter {
    public static void main (String[] args){
        ArrayList<Animal> animals = new ArrayList<Animal>();
        Horse hoe = new Horse();
        Cow coe = new Cow();
        Pig poe = new Pig();
        Chicken cho = new Chicken ();
        animals.add(hoe);
        animals.add(coe);
        animals.add(poe);
        animals.add(cho);
        for (Animal a: animals){
            if ( a instanceof Horse)
            {
                a.song();
            }
            else if ( a instanceof Cow)
            {
                a.song();
            }
            else if ( a instanceof Pig)
            {
                a.song();
            }
            else if ( a instanceof Chicken)
            {
                a.song();
            }
        }
        for (int i = 0; i < animals.size(); i++){
            System.out.println("\n" + "Name: " + (animals.get(i)).getName() + "\n" + "Feed: " + (animals.get(i)).getFood() + "\n" +
            "Housing: " + (animals.get(i)).getHousing());
        }
    }
}
