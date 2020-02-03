import java.util.Scanner;

/**
 *Tester class for testing the project.
 *Contains menu with options and processes user's choices.
 *
 *@author Gerda Ugne Pupelyte
 *@version 1.0
 */
public class Tester {

	private Stack testStack;
	private RPNCalculator test;
	
	/**
	 * Default constructor for the Tester class
	 */
	public Tester() {
		test = new RPNCalculator();
	}

	/**
	 * Main method of the project
	 * @param args 
	 */
	public static void main(String[] args) {
		
		Tester myTest = new Tester();
		myTest.initialise();
		
		myTest.processUsersChoices();
		

	}
	/**
	 * Initializes an new, empty stack
	 */
	
	public void initialise()
	{
		// Create a List class to run tests on.
		testStack = new Stack();
		test = new RPNCalculator();
	
	}
	
	/**
	 * Runs automated tests with stacks
	 */
	public void stackTest()
	{
		System.out.println("Running tests...");
		System.out.println("Adding one item onto the stack...");
		testStack.push(55);
		testStack.printStack();
		
		System.out.println("Adding more items to the stack...");
		addTest();
		testStack.printStack();
		
		System.out.println("Deleting all items from the stack...");
		deleteTest();
		testStack.printStack();
		
		System.out.println("Trying to delete items from an empty stack...");
		deleteTest();
		testStack.printStack();
		
	}
	
	/**
	 * Adds some test data to the stack
	 */
	public void addTest()
	{
		// Add numbers to the stack
		testStack.push(89);
		testStack.push(52);
		testStack.push(430);
		testStack.push(72);
		testStack.push(59);
	}

	/**
	 * Deletes data from the stack
	 */
	public void deleteTest()
	{
		try
		{
			testStack.pop();
			testStack.pop();
			testStack.pop();
			testStack.pop();
			testStack.pop();
			testStack.pop();
			
		}
		catch (EmptyStackException e)
		{
			System.out.println("Error: the stack is empty!");
		}
		
	}
	
	/**
	 * Method for displaying available menu options to the user
	 */
	public void displayMenu()
	{
		System.out.println("Please choose one of the following options:");
		System.out.println("1. Run RPN Calculator");
		System.out.println("2. Show instructions");
		System.out.println("3. Run automated tests");
		System.out.println("0. Exit");
	}
	
	/**
	 * Method that processes user's choices.
	 * Depending on user's input, appropriate methods are called.
	 * 
	 * 1 - Runs RPN Calculator
	 * 2 - Shows instructions
	 * 3 - Runs automated tests
	 * 0 - Exits the system
	 */
	public void processUsersChoices()
	{
		String choice;
		
		do
		{
			//Menu options displayed
			displayMenu();
			
			//user's input is read
			Scanner s = new Scanner(System.in);			
			choice = s.nextLine();
			
			//Corresponding menu option is executed
			//Runs RPN calculator
			if (choice.equals("1"))
			{
				//Boolean to retry the input process in case user's input is invalid
				boolean retry = false;
				
				do {
					
					initialise();
					
					Scanner input = new Scanner(System.in);
					String RPNValue;
					
					System.out.println("Please enter a RPN value:");
					RPNValue = input.nextLine();
					
					retry = test.evaluateRPN(RPNValue, " ");
					
				} while (retry==true);

				
			}
			// Displays instructions to the user
			else if ((choice.equals("2")))
			{
				System.out.println("In reverse Polish notation, the operators follow their operands;");
				System.out.println("for instance, to add 3 and 4, one would write 3 4 + rather than 3 + 4.");
				System.out.println("If there are multiple operations, operators are given immediately after their second operands;");
				System.out.println("so the expression written 3 - 4 + 5 in conventional notation would be written 3 4 - 5 + in");
				System.out.println("reverse Polish notation: 4 is first subtracted from 3, then 5 is added to it. An advantage of ");
				System.out.println("reverse Polish notation is that it removes the need for parentheses that are required by infix ");
				System.out.println("notation. While 3 - 4 * 5 can also be written 3 - (4 * 5), that means something quite different ");
				System.out.println("from (3 - 4) * 5. In reverse Polish notation, the former could be written 3 4 5 * -, which");
				System.out.println("unambiguously means 3 (4 5 *) - which reduces to 3 20 - (which can further be reduced to -17);");
				System.out.println("the latter could be written 3 4 - 5 * (or 5 3 4 - *, if keeping similar formatting),");
				System.out.println("which unambiguously means (3 4 -) 5 *. ");
			}
			// Runs automated tests
			else if (choice.equals("3"))
			{
				stackTest();
			}
			// Exits the system
			else if (choice.equals("0"))
			{
				System.out.println("Goodbye.");
				System.exit(0);
			}
			else
			{
				System.out.println("Please check your input and try again.");
			}
			
		} while(!(choice.equals("0")));

	}
	
	

}
