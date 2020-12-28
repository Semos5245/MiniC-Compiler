package Nodes;

public class IncDecOperatorNode extends TreeNode {

	// Increment Decrement operator
	protected String operator;
	
	// Assigns the value passed to the operator
	public IncDecOperatorNode(String operator) { this.operator = operator; }
	
	// Returns the operator
	public Object Execute() { return operator; }
}
