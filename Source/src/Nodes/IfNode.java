package Nodes;

public class IfNode extends TreeNode {

	public Object Execute() throws Exception
	{
		// Get the result of the boolean expression
		Object expression = children.get(0).Execute();
		
		// If the result was true, execute the block of code or the single statement
		if ((Boolean)expression) { children.get(1).Execute(); }
		
		// Else check if the node has an else block then execute it
		else { if (children.size() > 2) children.get(2).Execute(); }
		
		return null;
	}
}
