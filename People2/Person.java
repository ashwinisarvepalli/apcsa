/**
 * A person class for a simple BlueJ demo program. Person is used as
 * an abstract superclass of more specific person classes.
 *
 * @author  Michael Kölling
 * @version 1.0, January 1999
 */

abstract class Person// the keyword abstract indicates that we will not be 
//constructing instances of this class only its subclasses
{
    private String name; // name is the instance field variable
    private int yearOfBirth;
    private Address address;

    /**
     * Create a person with given name and age.
     */
    Person(String name, int yearOfBirth)
    {
        this.name = name; //this.name means the name that belongs to this 
        //object, the object that we are constructing, this name is the 
        //explicit parameter
        //have parameter variable name to be set ot the instance field variable
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Set a new name for this person.
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Return the name of this person.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set a new birth year for this person.
     */
    public void setYearOfBirth(int newYearOfBirth)
    {
        yearOfBirth = newYearOfBirth;
    }

    /**
     * Return the birth year of this person.
     */
    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /**
     * Set a new address for this person.
     */
    public void setAddress(String street, String town, String postCode)
    {
        address = new Address(street, town, postCode);
    }

    /**
     * Return the address of this person.
     */
    public Address getAddress()
    {
        return address;
    }

    /**
     * Return a string representation of this object.
     */
    public String toString()    // redefined from "Object"
    {
        return "Name: " + name + "\n" +
               "Year of birth: " + yearOfBirth + "\n";
    }
}
