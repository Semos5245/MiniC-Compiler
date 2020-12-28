package Nodes;

public class SwitchNode extends TreeNode {

	// Executes a switch statement on a variable
	public Object Execute() throws Exception
	{
		// Get the variable name to be checked
		String varName = (String)children.get(0).Execute();
		
		// Get the value of the variable
		Object value = VariablesStore.Get(varName);
		
		// Get the class name of the variable's value
		String className = value.getClass().getSimpleName();
		
		// Verify that all cases have values with types same as the variable to be checked
		for (int i = 1; i < children.size(); i++)
		{
			// Get the current case
			TreeNode currentCase = children.get(i);
			
			// If it is a CaseNode
			if (currentCase instanceof CaseNode)
			{
				// Cast it to Case Node
				CaseNode caseNode = (CaseNode)currentCase;
				
				// Get its value's type name
				var caseValueTypeName = caseNode.getValue().getClass().getSimpleName();
				
				// If the type name is different 
				if (caseValueTypeName != className)
				{
					//Throw Exception
					throw ExceptionsCollection.WrongTypesException(className, caseValueTypeName);
				}
			}
		}
		
		// Loop over all cases
		for (int i = 1; i < children.size(); i++)
		{
			// Cast it to the base type of cases
			var currentCase = (BaseCase)children.get(i);
			
			// If we can execute using the current value that is checked, then execute and break
			if (currentCase.CanExecute(value)) { currentCase.Execute(); break; }
		}
		
		return null;
	}
}
