package Nodes;

// Collections of exceptions
public class ExceptionsCollection {

	// Returns an Invalid Operation exception with the appropriate message
	public static Exception InvalidOperatorException(String operator, String type1, String type2) throws Exception {
		return new Exception("Operator '" + operator + "' cannot be applied to operands of type '" + TypeNameConverter.ToCSharp(type1)
		+ "' and '" + TypeNameConverter.ToCSharp(type2));
	}
	
	// Returns an Invalid Operation exception with the appropriate message
	public static Exception InvalidOperatorException(String operator, String type) throws Exception {
		return new Exception("Operator '" + operator +"' cannot be applied on operand of type '" + TypeNameConverter.ToCSharp(type) + "'");
	}
	
	// Returns an Wrong Types exception with the appropriate message
	public static Exception WrongTypesException(String type1, String type2) throws Exception {
		return new Exception("Cannot implicitly convert type '" + TypeNameConverter.ToCSharp(type2)
		+ "' to '" + TypeNameConverter.ToCSharp(type1) + "'");
	}
	
	// Returns an Wrong Types exception with the appropriate message
	public static Exception WrongTypesException(String type1, Object value2) throws Exception {
		return new Exception("Cannot implicitly convert type '" + TypeNameConverter.ToCSharp(value2.getClass().getSimpleName())
		+ "' to '" + TypeNameConverter.ToCSharp(type1) + "'");
	}
}
