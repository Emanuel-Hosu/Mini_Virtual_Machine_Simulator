package main;

/**
 * @author Emi
 */
public enum ENUM_BYTECODE {
	PUSH(1), LOAD(1), STORE(1), ADD, SUB, MUL, DIV, OUT, HALT;

	private int valueArg;

	/**
	 * Constructora default de ENUM_BYTECODE
	 */
	ENUM_BYTECODE() {
		this(0);
	}

	/**
	 * Constructora segunda de ENUM_BYTECODE encargada de recibir un int
	 * 
	 * @param n indica el numero siguiente de un ByteCode
	 */
	ENUM_BYTECODE(int n) {
		this.valueArg = n;
	}

	/**
	 * getValueArg metodo int que devuelve el número de parámetros que tiene una
	 * instrucción
	 * 
	 * @return this.valueArg este siendo el número de parámetros que tiene una
	 *         instrucción
	 */
	public int getValueArg() {
		return this.valueArg;
	}
}
