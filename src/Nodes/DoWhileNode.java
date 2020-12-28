package Nodes;

public class DoWhileNode extends TreeNode {

	public Object Execute()  throws Exception
	{
		// Get the first child which is a BlockNode or a simple TreeNode (Single statement of an type) and execute it
		do { children.get(0).Execute(); }
		// Get the expression and evaluate it
		while ((Boolean)children.get(1).Execute());
		
		return null;
	}
}
