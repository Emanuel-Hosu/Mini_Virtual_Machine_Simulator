package main;

import java.util.Scanner;

public class Engine {
	private boolean end;
	private String user;
	//ByteCodeProbram program = new ByteCodeProgram();
	/**
	 * Engine constructora
	 */
	public Engine() {
		
	}
	/**
	 * start
	 */
	public void start() {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		CommandParser parser = new CommandParser();
		Command transmisor = new Command();
		
		do {
			this.user = scn.nextLine().toUpperCase();
			parser.parse(this.user);
			//System.out.println(parser);
			/*switch (user) {
				case "help": 
					help();
					break;
				case "quit":
					quit();
					user = "quit";
					break;
				case "run":
					run();
					break;
				case "newinst":
					newinst();
					break;
				case "reset":
					reset();
					break;
				case "replace":
					replace();
					break;
			}*/
		}while (this.user != "QUIT");
	}
	/**
	 * help
	 */
	public void help() {
		System.out.println("The execution begins HELP");
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
		System.out.println("\nThe execution begins QUIT");
		System.out.println("Turning off...");
	}
	/**
	 * run
	 */
	public void run() {
		System.out.println("\nThe execution begins RUN");
	}
	/**
	 * newinst
	 */
	public void newinst() {
		System.out.println("\nThe execution begins NEWINST");
	}
	/**
	 * reset
	 */
	public void reset() {
		System.out.println("\nThe execution begins RESET");
	}
	/**
	 * replace
	 */
	public void replace() {
		System.out.println("\nThe execution begins REPLACE");
	}
}
