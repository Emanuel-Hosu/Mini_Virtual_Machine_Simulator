package main;

public class CPU {
	private OperaAndStack[] operator_stack; 
	private Memoria[] stored_memory;
	private boolean finished;
	
	public CPU() {
		finished = false;
	}
	
	public boolean execute(ByteCode instrucion) {
		return finished;
	}
	
	public String toString(String cadena) {
		return cadena;
	}
}
