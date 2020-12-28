package Nodes;

public class ForNode extends TreeNode {

	public Object Execute() throws Exception {
		

		for (
				// Get the initial assign node and execute it
				children.get(0).Execute();
				
				// Get the boolean expression and execute it
				(Boolean)children.get(1).Execute();
				
				// Get the modification node and execute it
				children.get(2).Execute())
			
			// Get the block of code related to the for loop and execute it
			children.get(3).Execute();
		
		return null;
	}
}
