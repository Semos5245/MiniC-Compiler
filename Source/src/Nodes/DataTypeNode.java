package Nodes;

public class DataTypeNode extends TreeNode {

	// The name of the data type
	protected String typeName;
	
	// Assign the passed value to current type name
	public DataTypeNode(String typeName) throws Exception {this.typeName = TypeNameConverter.ToJava(typeName); }
	
	// Returns the type name
	public Object Execute() { return typeName; }
}
