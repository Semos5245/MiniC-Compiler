package Nodes;

public class AssignNode extends TreeNode {

	public Object Execute() throws Exception {
		// Get the type name
		String typeName = (String)children.get(0).Execute();
		
		// Get the variable name to be created
		String varName = (String)children.get(1).Execute();
		
		// Make sure it does not exist (throw exception if it does)
		VariablesStore.MakeSureNotExists(varName);
		
		// Get the assignment part as a tree node
		var assignValueNode = children.get(2);
		
		// Get the value of the node to be assigned
		var assignValue = assignValueNode.Execute();
		
		// If it is a variable type
		if (assignValueNode instanceof VarNameNode) {
			// Put the value of the variable inside the assign value (Will throw if the variable does not exist)
			assignValue = VariablesStore.Get((String)assignValue);
		}
		
		// Get the simple type name of the value to be assigned
		var assignValueTypeName = assignValue.getClass().getSimpleName();
		
		// Check if the type of the new variable is double and to value to be assigned is integer
		if (typeName.equals("Double") && assignValueTypeName.equals("Integer")) {
			System.out.println("Here");
			// Convert the value to a type of double
			assignValue = Double.valueOf(assignValue.toString());
		}
		// Different types
		else if (!assignValueTypeName.equals(typeName)) {
			throw ExceptionsCollection.WrongTypesException(typeName, assignValueTypeName);
		}
		
		// Add the new variable
		VariablesStore.Add(varName, assignValue);
		return null;
	}
}
