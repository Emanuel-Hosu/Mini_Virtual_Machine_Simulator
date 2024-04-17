package main;

public class CommandParser {
	public static Command parse(String line) {
		//EXAVTAMENTE LO MISMO QUE BYTECODEPARSER
		String[] splitedCommand = line.split(" ");
		//System.out.println(splitedCommand.length);
		
		//PROBAR AVER SI FUNCION AL SPLIT
		/*for (int i = 0; i < splitedCommand.length; i++) {
			System.out.print(splitedCommand[i] + " ");
		}*/
		//HELP, QUIT, NEWINST(1), RUN, RESET, REPLACE(1);
		if(splitedCommand.length == 1) {
			//IGNORA SI ESTA EN MAYUSCULA O NO
			switch (splitedCommand[1]) {
				case "RUN":
					return new Command(ENUM_COMMAND.RUN);
				case "HELP":
					return new Command(ENUM_COMMAND.HELP);
				case "QUIT":
					return new Command(ENUM_COMMAND.QUIT);
				case "RESET":
					return new Command(ENUM_COMMAND.RESET);
			}
		}else if(splitedCommand.length == 2) {
			//ByteCoder + numero
			if(splitedCommand[0].equalsIgnoreCase("NEWINST"))
                return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(splitedCommand[1]));
		}else if(splitedCommand.length == 3) {
			String mixedByteCode = splitedCommand[1] + " " + splitedCommand[2];
			System.out.println(mixedByteCode);
			if(splitedCommand[0].equalsIgnoreCase("NEWINST"))
                return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(mixedByteCode));
		}
		return null;
	}
	
	public String toString(String cadena) {
		return null;
	}
}
