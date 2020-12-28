package Nodes;

public class WhileNode extends TreeNode {

	// Executes a while statement
	public Object Execute() throws Exception
	{
		while (
				// As long as the expression evaluates to true
				(Boolean)children.get(0).Execute())
			// Get the block of code or the single statement and execute it
			children.get(1).Execute();
		
		return null;
	}
}
