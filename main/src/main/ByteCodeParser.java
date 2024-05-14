package main;

/**
 * @author Emi ByteCodeParser carece de atributos, solo tiene un metodo
 *         "parseador"
 */
public class ByteCodeParser {
	/**
	 * parse es un metodo estatico que recibe por parametro un String, en este caso lo siguiente de NEWINST
	 * lo splitea en partes y empeiza a buscar a traves de un if, el codigo al que le corresponde y si este
	 * viene acompanyado de un numero, se encarga de retornar tambien el parametro
	 * @param byteString parametro que viene desde Engine (Lo siguiende de NEWINST que haya introduciodo el usuari)
	 * @return Se encarga de retornar un ByteCode, depende de lo que vaya seguido del NEWINST, este lo puede retornar con parametro o sin, luego ya se encargara la constructora de ByteCode que hacer con el
	 */
	public static ByteCode parse(String byteString) {
		String[] splitedByte = byteString.split(" ");
		if (splitedByte.length == 0) {
			return null;
		} else if (splitedByte.length == 1) {
			if ("ADD".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.ADD);
			} else if ("SUB".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.SUB);
			} else if ("MUL".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.MUL);
			} else if ("DIV".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.DIV);
			} else if ("OUT".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.OUT);
			} else if ("HALT".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.HALT);
			}
		} else if (splitedByte.length == 2) {
			if ("PUSH".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(splitedByte[1]));
			} else if ("LOAD".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(splitedByte[1]));
			} else if ("STORE".equals(splitedByte[0])) {
				return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(splitedByte[1]));
			}
		}

		return null;
	}
}