/**
 * A class representing staff members for a simple BlueJ demo program.
 *
 * @author  Michael Kölling
 * @version 1.0, January 1999
 */

class Staff extends Person
//keyword extends indicates that staff "IS A TYPE OF" Person
//Staff inherits all internal data and properties, of Person
{
    private String room; // what is specific about staff is that it belongs to a room

    /**
     * Create a staff member with default settings for detail information.
     */
    Staff() // and we have constructor for staff
    {
        //first line in staff must call on the constructor of the parent class
        //super calls the constructor of the Person, superclass
        super("(unknown name)", 0000); // if we don't have this line error, a person 
        //requires string and an int because in the 
        //constructor person requires string and an int
        room = "(unknown room)";
    }

    /**
     * Create a staff member with given name, year of birth and room
     * number.
     */
    Staff(String name, int yearOfBirth, String roomNumber)
    {
        super(name, yearOfBirth);
        room = roomNumber;
    }

    /**
     * Set a new room number for this person.
     */
    public void setRoom(String newRoom)
    {
        room = newRoom;
    }

    /**
     * Return the room number of this person.
     */
    public String getRoom()
    {
        return room;
    }

    /**
     * Return a string representation of this object.
     */
    public String toString()    // redefined from "Person"
    {
        return super.toString() +
               "Staff member\n" +
               "Room: " + room + "\n";
    }

}

