package Nodes;

public class BooleanOperatorNode extends TreeNode {

	// Boolean operator ('&&', '||')
	protected String operation;
	
	// Assignes the value passed to the operation
	public BooleanOperatorNode(String operation) { this.operation = operation; }
	
	// Returned the current operation
	public Object Execute() { return operation; }
}
