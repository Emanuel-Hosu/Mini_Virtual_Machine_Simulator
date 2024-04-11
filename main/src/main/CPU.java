package main;

public class CPU {
	//tiene que ser un array
	private OperaAndStack[] operator_stack; 
	private Memoria[] stored_memory;
	private boolean finished;
	
	public CPU() {
		//Convertir operatorStack y storedMemory en arrays
		finished = false;
	}
	
	public boolean execute(ByteCode instrucion) {
		return finished;
	}
	
	public String toString(String cadena) {
		return cadena;
	}
}
