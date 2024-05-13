package main;

public class CommandParser {
	public static Command parse(String line) {
		// EXAVTAMENTE LO MISMO QUE BYTECODEPARSER
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
			// ByteCoder + numero
			if (splitedCommand[0].equalsIgnoreCase("NEWINST"))
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(splitedCommand[1]));
			else if (splitedCommand[0].equalsIgnoreCase("REPLACE")) {
				return new Command(ENUM_COMMAND.REPLACE, ByteCodeParser.parse(splitedCommand[1]));
			}
		} else if (splitedCommand.length == 3) {
			String mixedByteCode = splitedCommand[1] + " " + splitedCommand[2];
			//system.out.println(mixedByteCode);
			if(splitedCommand[0].equalsIgnoreCase("NEWINST"))
                return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(mixedByteCode));
		}
		return null;
	}
}
