package main;

public class ByteCodeParser {
//sin atriutos
	
	//Maybe Constructora
	
	//Puede recibbir lo que sea
	public static ByteCode parse(String byteString) {
		//REVISAR MAYUSCULAS
		String[] splitedByte = byteString.split(" ");
		
		if (splitedByte.length == 0) {
			return null;
		}else if(splitedByte.length == 1) {
			switch (splitedByte[1]) {
				case "ADD":
					return new ByteCode(ENUM_BYTECODE.ADD);
				case "SUB":
					return new ByteCode(ENUM_BYTECODE.SUB);
				case "MUL":
					return new ByteCode(ENUM_BYTECODE.MUL);
				case "DIV":
					return new ByteCode(ENUM_BYTECODE.DIV);
				case "OUT":
					return new ByteCode(ENUM_BYTECODE.OUT);
				case "HALT":
					return new ByteCode(ENUM_BYTECODE.HALT);
			}
		}else if(splitedByte.length == 2) {
			switch (splitedByte[1]) {
				case "PUSH":
					return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(splitedByte[2]));
				case "LOAD":
					return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(splitedByte[2]));
				case "STORE":
					return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(splitedByte[2]));
			}
		}else {
			return null;
		}
		return null;
	}
	
	public String toString(String cadena) {
		return cadena;
	};
}

//PUSH(1), LOAD(1), STORE(1
//SUB, MUL, DIV, OUT, HALT
//Patricionar el string que nos llega por conosola a traves de un split
//particionr en un array newinst push 4, [0(newinst), 1(push), 2(4)]
//if array.length = 0 return null

//if array.length = 1 significa que es, run halt add, div mul
//if else o un switch si es == run || halt || add
//return ByteCode (retornar un objeto ADD) return new ByteCode(ENUM_BYTECODE.ADD)
//else return null
//if array.length == 2
//if else o un switch si es push, store, load
//return ByteCode (retornar un objeto PUSH) return new ByteCode(ENUM_BYTECODE.PUSH)
//else return null
//if array.length == 3 return null