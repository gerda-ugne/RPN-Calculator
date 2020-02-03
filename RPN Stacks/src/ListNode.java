
/**
 * A class that contains List Nodes contained in List class
 * 
 * @author Gerda Ugne Pupelyte
 * @version 1.0
 */
public class ListNode    
{
    // fields to store the data being held in this list node
	private double number;
    private ListNode next;

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    {
        // set number to an empty value
    	number = 0;
    	
        // set next node to null 
        next = null;
    }

    /**
     * Alternative constructor. Set fields to given values.
     *
     * @param number - the number from calculations
     */
    public ListNode(double number)
    {
        // set number to value provided
    	this.number = number;

        // set next node to null 
        next = null;
    }

    /**
     * Get the number contained in this list node
     * 
     * @return The number as a double
     */
    public double getNumber()
    {
        return number;
    }


    /**
     * Get the next node in the list after this one
     * 
     * @return A reference to the next node (or null if
     *         there is no next node)
     */
    public ListNode getNext()
    {
      return next;
    }

    /**
     * Set the next node in the list after this one
     * 
     * @param next A reference to a ListNode object which 
     *             represents the next node in the list after
     *             this one.
     */
    public void setNext(ListNode next)
    {
    	this.next = next;
    }

}
