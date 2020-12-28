package Nodes;

public class IncDecNode extends TreeNode {

	// Increments and decrements a variable and returns its value
	public Object Execute() throws Exception
	{
		// Get the first node
		var firstNode = children.get(0);
		
		// Get the second node
		var secondNode = children.get(1);
		
		// Get a boolean for whether the first node is a variable or not for later processing
		var firstIsVar = firstNode instanceof VarNameNode;
		
		// Get the variable name from the appropriate node
		var varName = firstIsVar ? (String)firstNode.Execute() : (String)secondNode.Execute();
		
		// Get the operator from the appropriate node
		var operator = firstIsVar ? (String)secondNode.Execute() : (String)firstNode.Execute();
		
		// Get the value of the variable
		var valueOfVariable = VariablesStore.Get(varName);
		
		// Check if the value of the variable is string
		if (valueOfVariable instanceof String)
			// Throw an exception
			throw ExceptionsCollection.InvalidOperatorException(operator, String.class.getSimpleName());
		
		// Check if the value of the variable is a Boolean
		else if (valueOfVariable instanceof Boolean)
			// Throw an exception
			throw ExceptionsCollection.InvalidOperatorException(operator, Boolean.class.getSimpleName());
		
		// New value of the variable to be set
		Object newValueOfVariable = null;
		
		// if the operator is ++
		if (operator.equals("++")) {
			// Check type if integer
			if (valueOfVariable instanceof Integer) newValueOfVariable = (Integer)valueOfVariable + 1;
			// Check type if double
			else if (valueOfVariable instanceof Double) newValueOfVariable = (Double)valueOfVariable + 1;
		}
		// if the operator is --
		else {
			// Check type if integer
			if (valueOfVariable instanceof Integer) newValueOfVariable = (Integer)valueOfVariable - 1;
			// Check type if double
			else if (valueOfVariable instanceof Double) newValueOfVariable = (Double)valueOfVariable - 1;
		}

		// Set the new value for the variable
		VariablesStore.Set(varName, newValueOfVariable);
		
		// if the variable was first then return its value before the operation, else return after the operation
		return firstIsVar ? valueOfVariable : newValueOfVariable;
	}
}
