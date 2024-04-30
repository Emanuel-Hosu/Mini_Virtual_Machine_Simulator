package main;

public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;

	// Constructora para inicializar los atributos
	public Command() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * 
	 * @param _command
	 */
	public Command(ENUM_COMMAND _command) {
		// TODO Auto-generated constructor stub
		this.command = _command;
	}

	/**
	 * 
	 * @param _command
	 * @param _byteCode
	 */
	public Command(ENUM_COMMAND _command, ByteCode _byteCode) {
		// TODO Auto-generated constructor stub
		this.command = _command;
		this.instruction = _byteCode;
	}

	/**
	 * 
	 * @param _command
	 * @param _replacer
	 */
	public Command(ENUM_COMMAND _command, int _replace) {
		// TODO Auto-generated constructor stub
		this.command = _command;
		this.replace = _replace;
	}

	/**
	 * 
	 * @param engine
	 * @return
	 */
	public boolean execute(Engine engine) {
		// if else de todos los comandos disponibles
		// si el comando que hemos recibido por parametro, le dice a Engine que ejecute
		// el comando
		if (this.command == ENUM_COMMAND.HELP) {
			engine.help();
			return true;
		} else if (this.command == ENUM_COMMAND.QUIT) {
			engine.quit();
			// user = "quit";
		} else if (this.command == ENUM_COMMAND.RUN) {
			engine.run();
			return true;
		} else if (this.command == ENUM_COMMAND.NEWINST) {
			engine.newinst(this.instruction);
			return true;
		} else if (this.command == ENUM_COMMAND.RESET) {
			engine.reset();
			return true;
		} else if (this.command == ENUM_COMMAND.REPLACE) {
			engine.replace(this.replace);
			return true;
		} else {
			System.out.println("Invalid engine command. Please use 'help' for available options.");
		}
		return false;
	};
}
