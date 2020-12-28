package Nodes;

public class CaseNode extends BaseCase 
{
	// Assigned a value to be matches later
	public CaseNode(LiteralValueNode valueNode)  throws Exception { super(valueNode); }
	
	// Determines if the current case could be executed
	public Boolean CanExecute(Object value) { return this.value.equals(value); }
}