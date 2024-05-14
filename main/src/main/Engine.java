package main;

import java.util.Scanner;

/**
 * @author Emi
 */
public class Engine {
	private Scanner scn = new Scanner(System.in);
	private ByteCodeProgram program;
	private CPU cpu;
	private boolean end;
	private String user;

	/**
	 * Engine constructora encargada de inicializar algunos atributos de la clase
	 */
	public Engine() {
		this.end = false;
		this.cpu = new CPU();
		this.program = new ByteCodeProgram();
	}

	/**
	 * start metodo que se encarga de entrar en yn bucle hasta que la maquina parem
	 * recoge lo que el usuario escribe por pantalla y una vez recogido llama al
	 * metodo parser de CommandParser para splitear y llamar a los metodos
	 * correspondientes siguientes, este volviendo al Engine y despues son llamados
	 * los diferentes metodos para llevar al cabo la ejecucion del comando
	 * introducido por el usuario. Este siempre lo hara cuando el comando sea
	 * escrito correcto, en caso de que no lo sea este imprimira un error por
	 * pantalla
	 */
	public void start() {
		// TODO Auto-generated method stub
		Command trn = new Command();

		while (!this.end) {
			user = scn.nextLine().toUpperCase();
			trn = CommandParser.parse(user);
			System.out.print("The execution begins: " + user + "\n");

			if (trn != null) {
				if (!trn.execute(this)) {
					if (!user.equals("QUIT")) {
						System.out.println("Error: Ejecucion incorrecta del comando");
					}
				}
			} else {
				System.out.println("Error: Incorrect Command");
			}
		}
		;
	}

	/**
	 * help metodo que se encarga de enseniar como se usa la "maquina virtual"
	 */
	public void help() {
		System.out.println("HELP: Shows this help");
		System.out.println("QUIT: Close the app");
		System.out.println("RUN: Run the program");
		System.out.println("NEWINST BYTECODE: Enter a new instruction to the program");
		System.out.println("RESET: Clears the current program");
		System.out.println("REPLACE N: Replaces instruction N with the one requested from the user");
	}

	/**
	 * quit metodo que imprime una cadena de apagando la maquinay pone el this.end
	 * en true por lo tanto hace que el while acabe
	 */
	public void quit() {
		System.out.println("Turning off...");
		System.out.println(this.program.toString());
		this.end = true;
	}

	/**
	 * run metodo encargado a llamar a diferentes metods, uno de ellos el runCPU que
	 * pon el halt de la maquina en false (osea que la maquina esta funcionando)
	 * acto seguido llama a runProgram() de la clase ByteCodeProgram para imprimir
	 * la cadena enorme por ultimo el toString() de ByteCodeProgram impirimiendo el
	 * programa almacenado
	 */
	public void run() {
		this.cpu.runCPU();
		System.out.println(this.program.runProgram(this.cpu));
		System.out.println(this.program.toString());
	}

	/**
	 * newinst metodo que recibe la intrucion ByteCode por parametro llama al
	 * setInstruction() de ByteCodeProgram para introducir el ByteCode. Luego
	 * imprime por pantalla el programa almacenado
	 * 
	 * @param instruction ByteCode instruction introducida por el usuario
	 */
	public void newinst(ByteCode instruction) {
		this.program.setInstruction(instruction);
		System.out.println(this.program.toString());
	}

	/**
	 * reset metodo que llama al metodo reset de ByteCodeProgram
	 */
	public void reset() {
		this.program.reset();
	}

	/**
	 * replace metodo encargado de imprimir por pantalla una cadena y volviendo a
	 * dejar al usuario a introducir una nueva cadena para ser parseada y ser
	 * "repleceada" con un elemento.
	 * 
	 * @param replace int. Encargado de indicar la posicion de donde queremos
	 *                cambiar el ByteCode
	 */
	public void replace(int replace) {
		System.out.println("New instruction: ");
		String newOption = scn.nextLine().toUpperCase();
		ByteCode trn2 = ByteCodeParser.parse(newOption);
		this.program.setInstructionPosition(trn2, replace);
		System.out.println(this.program.toString());
	}
}
