package Nodes;

import java.util.Arrays;

public class ModificationNode extends TreeNode {

	// Modifies a variables value, returns the variable value if it was an Increment Decrement statement
	public Object Execute() throws Exception
	{
		// If children are of size 1 then it is an IncDecNode, return its execution
		if (children.size() == 1) return children.get(0).Execute();
		
		// Get the variable name
		var varName = (String)children.get(0).Execute();
		
		// Get the variable value
		var currentVarValue = VariablesStore.Get(varName);
		
		// Get the variable value type name
		var currentVarTypeName = currentVarValue.getClass().getSimpleName();
		
		// Get the operator
		var operator = (String)children.get(1).Execute();
		
		// Get the node of the assigned value
		var assignValueNode = children.get(2);
		
		// Get the value of the assign node
		var assignValue = assignValueNode.Execute();
		
		// If the assign node was of type VarNameNode
		if (assignValueNode instanceof VarNameNode) {
			
			// Put the variable value inside the assignValue
			assignValue = VariablesStore.Get((String)assignValue);
		}
		
		// Get the type name of the assignValue
		var assignValueTypeName = assignValue.getClass().getSimpleName();
		
		// Get a boolean for whether we should convert the value to a double of not
		var shouldCastIntToDouble = currentVarTypeName == Double.class.getSimpleName() && assignValueTypeName == Integer.class.getSimpleName();
		
		// If we do not..
		if (!shouldCastIntToDouble) {
			// If types are different
			if (assignValueTypeName != currentVarTypeName) {
				// Throw exception
				throw ExceptionsCollection.WrongTypesException(currentVarTypeName, assignValueTypeName);
			}
			// Else if type was boolean and an operator other than = was used or, type was string and operators ('-=', '*=', '/=') were used
			else if (currentVarTypeName == Boolean.class.getSimpleName() && !operator.equals("=") || 
			   (currentVarTypeName == String.class.getSimpleName() && Arrays.asList("-=", "*=", "/=").contains(operator))) {
				// Throw exception
				throw ExceptionsCollection.InvalidOperatorException(operator, currentVarTypeName, assignValueTypeName);
			}
		}
		
		// Test the operator and do the appropriate actions accordingly
		switch(operator) {
		case "=":
			if (shouldCastIntToDouble) currentVarValue = Double.valueOf(assignValue.toString());
			else currentVarValue = assignValue;
			break;
		case "+=":
			if (shouldCastIntToDouble) currentVarValue = (Double)currentVarValue + Double.valueOf(assignValue.toString());
			else if (assignValueTypeName.equals(String.class.getSimpleName())) currentVarValue = (String)currentVarValue + (String)assignValue;
			else if (assignValueTypeName.equals(Integer.class.getSimpleName())) currentVarValue = (Integer)currentVarValue + (Integer)assignValue;
			else if (assignValueTypeName.equals(Double.class.getSimpleName())) currentVarValue = (Double)currentVarValue + (Double)assignValue;
			break;
		case "-=":
			if (shouldCastIntToDouble) currentVarValue = (Double)currentVarValue - Double.valueOf(assignValue.toString());
			else if (assignValueTypeName.equals(Integer.class.getSimpleName())) currentVarValue = (Integer)currentVarValue - (Integer)assignValue;
			else if (assignValueTypeName.equals(Double.class.getSimpleName())) currentVarValue = (Double)currentVarValue - (Double)assignValue;	
			break;
		case "*=":
			if (shouldCastIntToDouble) currentVarValue = (Double)currentVarValue * Double.valueOf(assignValue.toString());
			else if (assignValueTypeName.equals(Integer.class.getSimpleName())) currentVarValue = (Integer)currentVarValue * (Integer)assignValue;
			else if (assignValueTypeName.equals(Double.class.getSimpleName())) currentVarValue = (Double)currentVarValue * (Double)assignValue;
			break;
		case "/=":
			if (shouldCastIntToDouble) currentVarValue = (Double)currentVarValue / Double.valueOf(assignValue.toString());
			else if (assignValueTypeName.equals(Integer.class.getSimpleName())) currentVarValue = (Integer)currentVarValue / (Integer)assignValue;
			else if (assignValueTypeName.equals(Double.class.getSimpleName())) currentVarValue = (Double)currentVarValue / (Double)assignValue;
			break;
		}
		
		// Set the new value of the variable
		VariablesStore.Set(varName, currentVarValue);
		return null;
	}
}
