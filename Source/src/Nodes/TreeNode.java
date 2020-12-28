package Nodes;

import java.util.ArrayList;

// Base type for all nodes
public abstract class TreeNode {
  // Children of the node to be used for execution
  protected ArrayList<TreeNode> children = new ArrayList<TreeNode>();
  
  // Adds a new node to the children list
  public void Add(TreeNode node) { children.add(node); }
  
  // Executes the current node 
  public abstract Object Execute() throws Exception;
  
  // Prints a bit of information with the choosen label and value
  public void Print(String labelName, Object labelValue) 
  { System.out.println("Inside " + this.getClass().getSimpleName() + " with " + labelName + " value of " + labelValue.toString()); }
  
  // returns the simple name of the current object's class name 
  public String toString()
  {
	  return this.getClass().getSimpleName();
  }
}
