package Nodes;

public class BooleanExpressionNode extends TreeNode {

	// Returns the final boolean result
	public Object Execute()  throws Exception 
	{
		// Evaluate the first condition
		Boolean expressionResult = (Boolean)children.get(0).Execute();
		
		// Loop over all conditions including the operators between them
		for (int i = 2; i < children.size(); i += 2) 
		{
			// Evaluate the current condition
			Boolean conditionResult = (Boolean)children.get(i).Execute();
			
			// If the node before it has an && then AND the main result
			if (children.get(i - 1).Execute().toString() == "&&") expressionResult = expressionResult && conditionResult;
			// Else just OR it
			else expressionResult = expressionResult || conditionResult;
		}
		
		// Return the final result
		return expressionResult;
	}
}
