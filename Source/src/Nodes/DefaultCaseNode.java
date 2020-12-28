package Nodes;

public class DefaultCaseNode extends BaseCase {
	
	// Returns true since default cases can always be executed if the executed reached it
	public Boolean CanExecute(Object value) { return true; }
}
