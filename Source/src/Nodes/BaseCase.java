package Nodes;

// Represents the base type for the cases (Normal case and default case)
public abstract class BaseCase extends TreeNode {

	// Value represented inside the case (null for default case)
	protected Object value;
	
	// Assigned the value passed
	protected BaseCase(LiteralValueNode valueNode) throws Exception { this.value = valueNode.Execute(); }
	
	// Default constructor
	protected BaseCase() { }
	
	// Executes the code block inside it
	public Object Execute() throws Exception { children.get(0).Execute(); return null; }
	
	// Determines if the current case could be executed according to the value passed
	public abstract Boolean CanExecute(Object value);
	
	// Retrieves the value inside the case
	public Object getValue() { return value; }
}
