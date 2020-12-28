package Nodes;

public class PrintNode extends TreeNode {

	// Prints a value or a variables value to the console
	public Object Execute() throws Exception {
		
		// Get the node to be printed
		TreeNode node = children.get(0);
		
		// Get the value of the node
		Object valueToPrint = node.Execute();
		
		// If the node is of type VarNameNode
		if (node instanceof VarNameNode) {
			// Set the value to be printed to the value of the variable
			valueToPrint = VariablesStore.Get((String)valueToPrint);
		}
		
		// Print the value to the console
		System.out.println(valueToPrint.toString());
		
		return null;
	}
}
