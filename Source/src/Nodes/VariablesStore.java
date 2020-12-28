package Nodes;

import java.util.HashMap;

// Global storage for variable for the entire program
// Should be like for every block of code, it has its own context (store of variables) and deeper contexts should access higher contexts so on...
public class VariablesStore 
{
	// Hash map for storing variable's name as the key and the variable's value as a general object type
	protected static HashMap<String, Object> Variables = new HashMap<String, Object>();
	
	// Retrieves the value of a variable, Throws if variable not found
	public static Object Get(String key) throws Exception { MakeSureExists(key); return Variables.get(key); }
	
	// Adds a new variable with the specified key (variable name) and the specified value (variable value)
	// Throws if the variable already exists
	public static void Add(String key, Object value) throws Exception {
		MakeSureNotExists(key);
		Variables.put(key, value);
	}
	
	// Sets or updates the variable value, Throws if variable does not exist
	public static void Set(String key, Object value) throws Exception{
		MakeSureExists(key);
		Variables.put(key, value);
	}
	
	// Throws if the key does not exist
	public static void MakeSureExists(String key) throws Exception 
	{ 
		if (Variables.get(key) == null)
			throw new Exception("The name '" + key + "' doesn't exist in the current context.");
    }
	
	// Throws if the variable exists
	public static void MakeSureNotExists(String key) throws Exception 
	{ 
		if (Variables.get(key) != null)
			throw new Exception("A local variable with the name '" + key + "' already exists in this scope.");
    }
}
