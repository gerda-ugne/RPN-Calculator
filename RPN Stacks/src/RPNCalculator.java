/**
 * Class that contains the RPN calculator.
 * RPN calculator uses stacks in order to calculate given user's input.
 * 
 * @author Gerda Ugne Pupelyte
 * @version 1.0
 */
public class RPNCalculator {
	
	//Initiates stacks
	private Stack stack;

	
	public RPNCalculator() {
		// TODO Auto-generated constructor stub
		stack = new Stack();
		
	}
	
/**
 * Method that evaluates given RPN notation.
 * The String is split and the numbers are moved onto stack,
 * while the operators are read and corresponding calculations are made.
 * 
 * The result is pushed back on stack.
 * @param notation - user's input of RPN
 * @param delimiter - character used to split the String
 * @return true if there was an error and user needs to fix their input, false otherwise
 */
	public boolean evaluateRPN(String notation, String delimiter)
	{
		//Input is split
		String [] splitString = notation.split(delimiter);
		double number;
        String [] operators = {"+","-","*","/"};
        boolean isCharOperator = false;
        boolean retry = false;

        //Runs for the length of string
		for (int i=0; i<splitString.length;i++)
		{			
			try
			{
				if(isNumeric(splitString[i]) == true)
				{
					// If the value is a number, it's pushed on the stack
					number = Double.parseDouble(splitString[i]);
					stack.push(number);
				}
				else //If the value is not a number, it's determined whether it's an operator
				{ 
					for(int j=0; j<operators.length; j++)
					{
						
						//If a matching operator is found, operation is calculated
						if(splitString[i].equals(operators[j])) 
						{
							//Calculations are made
							retry = calculate(operators[j]); 
							isCharOperator = true; 
							
							//If an error has occurred during calculations, process is restarted
							if(retry == true)
							{
								return true;
							}
							else 
							{
								break;
							}
						}

					}
					
					// Else if no valid operators found user is prompted to check their invalid input
					if (isCharOperator == false) {
						System.out.println("Invalid input! Please try again");
						
						//Returns true to prompt to reenter input
						return true;
					}
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("An error has occured. Please try again");
				//Returns true to prompt to reenter input
				return true;
				
			}
		}

		
		//Checks if there is more than one element on the list
		// If yes, means the input was incorrect
		if(stack.calculateStackElements()>1)
		{
			System.out.println("Invalid input. Please try again!");
			
			//Returns user to retry
			return true;
		}
		else
		{
			//Result is printed
			stack.printStack(); 
		}
		// No errors found - returns false to not retry the process 
		return false;
		
	}
	
	/**
	 * Method that checks whether the String value is a number.
	 * @param value - String that is being checked
	 * @return false/true depending on outcome of the test
	 */
	public boolean isNumeric(String value)
	{
		double test = 0;
		
		try
		{	//The system tries to convert String into double
			test = Double.parseDouble(value);
			return true;
		}
		catch (NumberFormatException e)
		{
			// In case of an error we know it was not an number
			return false;
		}
	}
	
	/**
	 * Performs calculations with numbers within the stack.
	 * 
	 * The numbers from stack are popped and then corresponding to the operator,
	 * calculations are made.
	 * 
	 * @param operator - an operator passed from the read input
	 * @return if there is an error, it returns true
	 */
	
	public boolean calculate(String operator)
	{
		double number1 = 0;
		double number2 = 0;
		
		try
		{
			//Two numbers from stack are popped
			number1 = stack.pop();
			number2 = stack.pop();
			
		}
		catch (EmptyStackException e)
		{
			System.out.println("Please check your input.");
			return true;
			
		}
		
		double result = 0;
		
		//Depending on the operator, calculations are completed
		try {
			
			switch(operator)
			{
			case "+": result = number1 + number2; break;
			case "-": result = number2 - number1; break;
			case "*": result = number1 * number2; break;
			case "/": 
			{	if(number1==0) throw new ArithmeticException();
				result = number2/number1; break;
			}
			
			}
			

			
			//Result is pushed back on stack
			stack.push(result);
			
			
			return false;
			
		}
		catch (NullPointerException e)
		{
			System.out.println("An error has occured. Check your input.");
			return true;
		}
		catch (ArithmeticException e)
		{
			System.out.println("Error: Division by 0. Please try again");
			return true;
		}

	}

}
