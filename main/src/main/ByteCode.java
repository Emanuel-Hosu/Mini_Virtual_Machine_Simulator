package main;
/**
 * @author Emi
 */
public class ByteCode {
	private ENUM_BYTECODE code;
	private int param;
	
	/**
	 * BytecCode constructora que recibe por parametro un bytecode en este caso puede ser un add, div, out etc
	 * @param _code (lo recibe y lo inicializa)
	 */
	public ByteCode(ENUM_BYTECODE _code) {
		this.code = _code;
		this.param = -1;
	}
	/**
	 * ByteCode segunda constructora de la clase ByteCode esta recibe tanto el codigo ByteCode como su parametro, por ejemplo push 3, store 9, etc
	 * @param _code (lo recibe y lo inicializa)
	 * @param _param (lo recibe y lo inicializa)
	 */
	public ByteCode(ENUM_BYTECODE _code, int _param) {
		this.code = _code;
		this.param = _param;
	}
	/**
	 * getCode de tipo ENUM_BYTECODE, uno de los dos metodos getters de la clase ByteCode, retorna el ByteCode
	 * @return ByteCode(el codigo)
	 */
	public ENUM_BYTECODE getCode(){
		return this.code;
	}
	/**
	 * getParam de tipo int, el segundo metodo getter de la clase ByteCode, este retorna el parametro del codigo ByteCode
	 * @return Parametro del ByteCode
	 */
	public int getParam() {
		return this.param;
	}
}
