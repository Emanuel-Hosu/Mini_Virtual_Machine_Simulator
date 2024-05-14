package main;

/**
 * @author Emi
 */
public class CommandParser {
	/**
	 * parse metodo de tipo Command estatico, encargado de recibir por parametro lo
	 * que ha introducido el usuario por pantalla y se encarga de parsearlo. Una vez
	 * parseado si las partes del string parseado concuerda con algun commando
	 * devuelve el commando
	 * 
	 * @param line String que viene de la clase Engine, con el string de commandos
	 *             que ha introducido el usuario
	 * @return dependiendo del comando correcto que ha introducido el usuario un
	 *         ENUM_COMMAND con el comando introducido por el usaurio o si ninguno
	 *         es correcto devuelve un null
	 */
	public static Command parse(String line) {
		String[] splitedCommand = line.split(" ");

		if (splitedCommand.length == 1) {
			// IGNORA SI ESTA EN MAYUSCULA O NO
			if ("RUN".equals(splitedCommand[0])) {
				return new Command(ENUM_COMMAND.RUN);
			} else if ("HELP".equals(splitedCommand[0])) {
				return new Command(ENUM_COMMAND.HELP);
			} else if ("QUIT".equals(splitedCommand[0])) {
				return new Command(ENUM_COMMAND.QUIT);
			} else if ("RESET".equals(splitedCommand[0])) {
				return new Command(ENUM_COMMAND.RESET);
			}
		} else if (splitedCommand.length == 2) {
			if (splitedCommand[0].equalsIgnoreCase("NEWINST"))
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(splitedCommand[1]));
			else if (splitedCommand[0].equalsIgnoreCase("REPLACE")) {
				return new Command(ENUM_COMMAND.REPLACE, ByteCodeParser.parse(splitedCommand[1]));
			}
		} else if (splitedCommand.length == 3) {
			String mixedByteCode = splitedCommand[1] + " " + splitedCommand[2];
			if (splitedCommand[0].equalsIgnoreCase("NEWINST"))
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(mixedByteCode));
		}
		return null;
	}
}
