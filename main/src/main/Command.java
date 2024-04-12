package main;

public class Command {
	/**
	 * 
	 */
	public enum ENUM_COMMAND {
		HELP, QUIT, NEWINST(1), RUN, RESET, REPLACE(1);
		private int valueArg;
		
		/**
		 * Constructora
		 */
		ENUM_COMMAND() {
			this.valueArg = 0;
		}
		/**
		 * Constructora
		 * @param n
		 */
		ENUM_COMMAND(int n) {
			this.valueArg = n;
		}
		/**
		 * Devuelve el número de parámetros que tiene un comando
		 * @return
		 */
		public int getValueArg(){
			return this.valueArg;
		}
	}
	
	private ByteCode instruction = new ByteCode();
	private int replace;
	
	//Constructora para inicializar los atributos
	public Command(){
		
	};
	/*
	public ENUM_COMAND comand(String comand) {
		switch (comand.toUpperCase()) {
		case "QUIT":
			return ENUM_COMAND.quit;
		case "HELP":
			return ENUM_COMAND.help;
		}
		
	};*/
	
	public boolean execute(Engine engine) {
		return false;	
	};
	
	public String toString(String cadena) {
		return cadena;
	};
}
