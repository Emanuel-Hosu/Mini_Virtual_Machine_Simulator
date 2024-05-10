package main;

public class ByteCode {
	private ENUM_BYTECODE code;
	private int param;
	
	//Constructora para inicializar los atributos
	public ByteCode(ENUM_BYTECODE _code) {
		this.code = _code;
		this.param = -1;
	}

	public ByteCode(ENUM_BYTECODE _code, int _param) {
		this.code = _code;
		this.param = _param;
	}
	//tiene sus propios metodos getters
	
	public ENUM_BYTECODE getCode(){
		return code;
	}
	
	public int getParam() {
		return param;
	}
}
