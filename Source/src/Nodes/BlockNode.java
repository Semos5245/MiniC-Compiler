package Nodes;

public class BlockNode extends TreeNode {

	// Executes all the children nodes inside it
	public Object Execute() throws Exception 
	{
		// Call the execute method on every node in the children nodes
		for (TreeNode node : children) {
			node.Execute();
		}
		return null; 
	}
}
