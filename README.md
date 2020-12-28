# MiniCSharpCompiler
Java, and JavaCC based C# Mini compiler.

This project is a mix between an interpreter and a compiler where code given is analysed using complex regular expressions stored in tokens, and further more compared with the CFGs which define a langauge structure, Nodes are created according to the analysed results and a tree of nodes is creating which is merely the intermediate code to be executed later.

Semantic Correction is taken into consideration in this project where different types can't be assigned to each other as a basic implementation.

As i have said before, it is a mix between an interpreter and a compiler where the project doesn't produce an executable file as a compiler does but is also given errors at compile time and also executed the intermediate code directly without producing any Assembly code.

Feel free to use it and add on as you like :)
