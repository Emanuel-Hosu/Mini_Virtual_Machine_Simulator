package main;

/**
 * @author Emi
 */
public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;

	/**
	 * Command constructora default de la clase command
	 */
	public Command() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Command segunda constructora de la clase command, encargada de recibir por
	 * parametro un command y inicializarlo
	 *
	 * @param _command tipo ENUM_COMMAND, (inicializa el atributo command)
	 */
	public Command(ENUM_COMMAND _command) {
		// TODO Auto-generated constructor stub
		this.command = _command;
	}

	/**
	 * Command tercera constructora de la clase command, encargada de recibir dos
	 * parametros, command de tipo ENUM_COMMAND y byteCode de tipo ByteCode
	 * 
	 * @param _command  tipo ENUM_COMMAND, (inicializa el atributo command de la
	 *                  porpia clase)
	 * @param _byteCode tipo ByteCode, (inicializa el atributo instruction de la
	 *                  clase Command)
	 */
	public Command(ENUM_COMMAND _command, ByteCode _byteCode) {
		// TODO Auto-generated constructor stub
		this.command = _command;
		this.instruction = _byteCode;
	}

	/**
	 * Command cuarta y ultima constructora de la clase Command encargada de recibir
	 * por parametro un ENUM_COMMAND y un int (esta constructora se usa en caso de
	 * que se haya usado el comando REPLACE)
	 * 
	 * @param _command  tipo ENUM_COMMAND, (inicializa el atributo command de la
	 *                  porpia clase)
	 * @param _replace tipo int, (inicializa el atributo replace de la clase
	 *                  Command)
	 */
	public Command(ENUM_COMMAND _command, int _replace) {
		// TODO Auto-generated constructor stub
		this.command = _command;
		this.replace = _replace;
	}

	/**
	 * execute metodo booleano con un monton de if else de todos los comandos
	 * disponibles,si el comando que hemos recibido por parametro, le dice a Engine
	 * que ejecute el comando en caso de no ser asi salta un Sysout de error
	 * 
	 * @param engine recibe por parametro una cadena parseada de tipo engine
	 *               dependiento de lo que haya puesto el usuario (this)
	 * @return true o false, true si el commando ha sido encontrado o false si no lo
	 *         ha sido
	 */
	public boolean execute(Engine engine) {
		if (this.command == ENUM_COMMAND.HELP) {
			engine.help();
			return true;
		} else if (this.command == ENUM_COMMAND.QUIT) {
			engine.quit();
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
