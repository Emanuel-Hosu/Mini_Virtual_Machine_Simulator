package main;

public class ByteCode {
	/**
	 * 
	 */
	public enum ENUM_BYTECODE {
		PUSH(1), LOAD(1), STORE(1), ADD, SUB, MUL, DIV, OUT, HALT;
		private int valueArg;
		
		/**
		 * Constructora
		 */
		ENUM_BYTECODE() {
			this(0);
		}
		/**
		 * Constructora
		 * @param n
		 */
		ENUM_BYTECODE(int n) {
			this.valueArg = n;
		}
		/**
		 * Devuelve el número de parámetros que tiene una instrucción
		 * @return
		 */
		public int getValueArg(){
			return this.valueArg;
		}
	}
	
	private ENUM_BYTECODE name;
	private int param;
	
	//Constructora para inicializar los atributos
	public ByteCode() {
		
	}
	
	public String toString(String cadena) {
		return cadena;
	};
}
