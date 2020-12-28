package Nodes;

public class VarNameNode extends TreeNode {

	// Variable name that is captured
	private String variableName;
	
	// Assigns the passed value to the variable name
	public VarNameNode(String value) { variableName = value; }
	
	// Returns the variable name
	public Object Execute() throws Exception { return variableName; }
}
