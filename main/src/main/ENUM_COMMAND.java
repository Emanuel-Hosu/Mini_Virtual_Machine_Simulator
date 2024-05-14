package main;

public enum ENUM_COMMAND {
	HELP, QUIT, NEWINST(1), RUN, RESET, REPLACE(1);

	private int valueArg;

	/**
	 * Constructora default de ENUM_COMMAND
	 */
	ENUM_COMMAND() {
		this.valueArg = 0;
	}

	/**
	 * Constructora segunda de ENUM_COMMAND encargada de recibir por parametro un n
	 * 
	 * @param n indica el numero siguiente de un ByteCode
	 */
	ENUM_COMMAND(int n) {
		this.valueArg = n;
	}

	/**
	 * Devuelve el número de parámetros que tiene un comando
	 * 
	 * @return this.valueArg este siendo el número de parámetros que tiene una
	 *         instrucción
	 */
	public int getValueArg() {
		return this.valueArg;
	}
}
