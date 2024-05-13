package main;

public class ByteCodeParser {
	
	//Puede recibbir lo que sea
	public static ByteCode parse(String byteString) {
		//REVISAR MAYUSCULAS
		String[] splitedByte = byteString.split(" ");
		if (splitedByte.length == 0) {
			return null;
		}else if(splitedByte.length == 1) {
			if("ADD".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.ADD);
			}else if("SUB".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.SUB);
			}else if("MUL".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.MUL);
			}else if("DIV".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.DIV);
			}else if("OUT".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.OUT);
			}else if("HALT".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.HALT);
			}
		}else if(splitedByte.length == 2) {
			if("PUSH".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(splitedByte[1]));
			}else if("LOAD".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(splitedByte[1]));
			}else if("STORE".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(splitedByte[1]));
			}
		}
		
		return null;
	}
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