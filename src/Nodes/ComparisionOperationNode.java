package Nodes;

public class ComparisionOperationNode extends TreeNode {

	// Comparision operator ('==', '>=', ...)
	public String operation;
	
	// Assigns the value passed to the operation
	public ComparisionOperationNode(String operation) { this.operation = operation; }
	
	// Returns the current operation
	public Object Execute() throws Exception { return this.operation; }
}
