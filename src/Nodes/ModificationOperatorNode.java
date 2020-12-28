package Nodes;

public class ModificationOperatorNode extends TreeNode {

	// Operator for the modification
	protected String operator;
	
	// Assigns the passed value to the current operator
	public ModificationOperatorNode(String operator) { this.operator = operator; }
	
	// Returns the current operator
	public Object Execute() throws Exception { return operator; }

}
