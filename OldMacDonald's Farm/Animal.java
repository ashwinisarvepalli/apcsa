/**
 * Abstract class Animal - write a description of the class here
 *
 * @author Ashwini Sarvepalli
 * @version 10-31-18
 */
public abstract class Animal
{
    private String animalName;
    private String animalFood;
    private String animalHousing;
    private String animalNoise;
    private String song;
    public Animal (String name, String food, String housing, String noise)
    {
        this.animalName = name;
        this.animalFood = food;
        this.animalHousing = housing;
        this.animalNoise = noise;
    }
    public String getName()
    {
        return animalName;
    }
    public String getHousing ()
    {
        return animalHousing;
    }
    public String getFood (){
        return animalFood;
    }
    public void song()
    {
        System.out.println ("Old MacDonald Had a Farm, E-I-E-I-O!, and on his farm he had a " + animalName + "\n" +
        "With a " + animalNoise + " here and a " + animalNoise + " there." + "\n" + "Here a " + animalNoise + ", there a moo " +
        animalNoise + "\n" + "Everywhere a " + animalNoise + "\n" + "Old MacDonald Had a Farm, E-I-E-I-O!");;
    }
}
