package Nodes;

public class LiteralValueNode extends TreeNode {

	// Literal value
	private Object value;
	
	// Assigns the value passed to the current value
	public LiteralValueNode(Object value) { this.value = value; }
	
	// Returns the current value
	public Object Execute() throws Exception { return value; }
}
