package main;

public class Command {
	private ByteCode instruction;
	private int replace;
	
	//Constructora para inicializar los atributos
	/*
	public ENUM_COMAND comand(String comand) {
		switch (comand.toUpperCase()) {
		case "QUIT":
			return ENUM_COMAND.quit;
		case "HELP":
			return ENUM_COMAND.help;
		}
		
	};*/
	public Command() {
		// TODO Auto-generated constructor stub
		
	}
	public Command(ENUM_COMMAND _command) {
		// TODO Auto-generated constructor stub
		
	}
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
