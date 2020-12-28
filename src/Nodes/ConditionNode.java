package Nodes;

import java.util.Arrays;

public class ConditionNode extends TreeNode {

	// Evaluates the condition and returns a boolean result
	public Object Execute() throws Exception
	{
		// Get the left operand node
		TreeNode leftOperandNode = children.get(0);
		
		// Get the value of the left operand
		Object leftOperandValue = children.get(0).Execute();
		
		// If the node is a variable type node
		if (leftOperandNode instanceof VarNameNode) {
			// Put the variable value in the value of the leftOperand
			leftOperandValue = VariablesStore.Get((String)leftOperandValue);
		}
		
		// Get the class type name of the left operand
		var leftOperandTypeName = leftOperandValue.getClass().getSimpleName();
		
		// If the children are of size 1 (It is a variable or a literal value)
		if (children.size() == 1)
		{
			// If the value inside the left operand is not boolean
			if (!(leftOperandValue instanceof Boolean)) {
				// Throw exception 
				throw ExceptionsCollection.WrongTypesException(Boolean.class.getSimpleName(), leftOperandTypeName);
			}
			
			// Returns the boolean result
			return (Boolean)leftOperandValue;
		}
		
		// Get operator
		String operator = (String)children.get(1).Execute();
		
		// Get the right operand node
		TreeNode rightOperandNode = children.get(2);
		
		// Get the value of the right operand node
		Object rightOperandValue = rightOperandNode.Execute();
		
		// If the node is of type VarNameNode
		if (rightOperandNode instanceof VarNameNode) {
			// Put inside the right operand value the value of the variable
			rightOperandValue = VariablesStore.Get((String)rightOperandValue);
		}
		
		// Get the right operand type name
		var rightOperandTypeName = rightOperandValue.getClass().getSimpleName();
		
		// If types of both operands are different Or an invalid operator is used for Strings and Booleans
		if (rightOperandTypeName != leftOperandTypeName || ((leftOperandValue instanceof String || leftOperandValue instanceof Boolean) && Arrays.asList(">=", "<=", ">", "<").contains(operator))) {
			// Throw execption
			throw ExceptionsCollection.InvalidOperatorException(operator, leftOperandTypeName, rightOperandTypeName);
		}
		
		// Test the operation and do the appropriate actions
		switch(operator) {
		case "<":
			if (leftOperandValue instanceof Double) return (Double)leftOperandValue < (Double)rightOperandValue;
			else if (leftOperandValue instanceof Integer) return (Integer)leftOperandValue < (Integer)rightOperandValue;
		case ">":
			if (leftOperandValue instanceof Double) return (Double)leftOperandValue > (Double)rightOperandValue;
			else if (leftOperandValue instanceof Integer) return (Integer)leftOperandValue > (Integer)rightOperandValue;
		case "<=":
			if (leftOperandValue instanceof Double) return (Double)leftOperandValue <= (Double)rightOperandValue;
			else if (leftOperandValue instanceof Integer) return (Integer)leftOperandValue <= (Integer)rightOperandValue;
		case ">=":
			if (leftOperandValue instanceof Double) return (Double)leftOperandValue >= (Double)rightOperandValue;
			else if (leftOperandValue instanceof Integer) return (Integer)leftOperandValue >= (Integer)rightOperandValue;
		case "==":
			return leftOperandValue.equals(rightOperandValue);
		case "!=":
			return !leftOperandValue.equals(rightOperandValue);
		default:
			throw new Exception("Unexpected error occured");
		}
	}
}
