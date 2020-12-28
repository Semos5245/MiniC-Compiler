package Nodes;

// Type name converter from Java type names to C# type names
public class TypeNameConverter {

	// Converts a C# type name to java
	public static String ToJava(String typeName) throws Exception
	{
		if (typeName.equals("int")) return "Integer";
		else if (typeName.equals("double")) return "Double";
		else if (typeName.equals("string"))return "String";
		else if (typeName.equals("bool"))return "Boolean";
		else throw new Exception();
	}

	// Converts a java type name to C#
	public static String ToCSharp(String typeName) throws Exception
	{
		if (typeName.equals("Integer")) return "int";
		else if (typeName.equals("Double")) return "double";
		else if (typeName.equals("String"))return "string";
		else if (typeName.equals("Boolean"))return "bool";
		else throw new Exception();
	}
}
