package main;

import java.util.Scanner;

public class Engine {
	private Scanner scn = new Scanner(System.in);
	private ByteCodeProgram program;
	private CPU cpu;
	private boolean end;
	private String user;
	//ByteCodeProbram program = new ByteCodeProgram();
	/**
	 * Engine constructora
	 */
	public Engine() {
		end  = false;
		cpu = new CPU();
		program = new ByteCodeProgram();
	}
	/**
	 * start
	 */
	public void start() {
		//metodo void
			//entra en un 
		// TODO Auto-generated method stub
		//CommandParser parser = new CommandParser();
		Command trn = new Command();
		
		while(!this.end) {
			//Recoge lo que se escribe por pantalla, una vez cogido hay que llamar al comand parser
			user = scn.nextLine().toUpperCase();
			trn = CommandParser.parse(user);
			System.out.print("The execution begins: " + user + "\n");
			
			if(trn != null) {
				if(!trn.execute(this)) {
					//un comando que puede fallar es parar la maquina cuando la maquina ya esta parada, poner como primer comando replace, por que no hay nada a lo que hacerle replace
					if(!user.equals("QUIT")) {
						System.out.println("Error: Ejecucion incorrecta del comando");						
					}
				}
			}else {
				System.out.println("Error: Incorrect Command");
			}
		};
	}
	/**
	 * help
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
	 * quit
	 */
	public void quit() {
		System.out.println("Turning off...");
		this.end = true;
	}
	/**
	 * run
	 */
	public void run() {
		this.cpu.runCPU();
		//this.program.runProgram(this.cpu);
		System.out.println(program.runProgram(this.cpu));
		System.out.println(this.program.toString());
	}
	/**
	 * newinst
	 * @param instruction 
	 * @param command 
	 */
	public void newinst(ByteCode instruction) {
		this.program.setInstruction(instruction);
		System.out.println(this.program.toString());
	}
	/**
	 * reset
	 */
	public void reset() {
		this.program.reset();
	}
	/**
	 * replace
	 * @param replace 
	 */
	public void replace(int replace) {
		System.out.println("New instruction");
		String newOption = scn.nextLine().toUpperCase();
		ByteCode trn2 = ByteCodeParser.parse(newOption);
		this.program.setInstructionPosition(trn2, replace);
		System.out.println(this.program.toString());
	}
}
