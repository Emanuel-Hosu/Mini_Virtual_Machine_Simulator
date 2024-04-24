package main;

public class Command {
	private ByteCode instruction;
	private int replace;
	
	//Constructora para inicializar los atributos
	public Command() {
		// TODO Auto-generated constructor stub
		
	}
	/**
	 * 
	 * @param _command
	 */
	public Command(ENUM_COMMAND _command) {
		// TODO Auto-generated constructor stub
		
	}
	/**
	 * 
	 * @param _command
	 * @param _byteCode
	 */
	public Command(ENUM_COMMAND _command, ByteCode _byteCode) {
		// TODO Auto-generated constructor stub
		
	}
	
	public boolean execute(Engine engine) {
		return false;
		
	};
	
	public String toString(String cadena) {
		return cadena;
	};
}
