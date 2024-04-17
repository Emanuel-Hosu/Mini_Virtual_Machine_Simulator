package main;

public class CPU {
	private OperaAndStack pila; 
	private Memoria stored_memory;
	private boolean halt;
	
	public CPU() {
		halt = false;
	}
	
	public boolean execute(ByteCode instrucion) {
		return halt;
	}
	
	public String toString() {
		//va a llamar al metodo toString del OperaAndStack y el de metodo memory
		return null;
	}
	
	//metodo erase, se encarga de borrar la pila y la memoria(tienen que desaparecer los atributos, los tiene que dejar como nuevos)
	//los tiene que dejar vacios como un RESET o algo asi
	
	//isHalt?() devuelve un booleano de si la maquina esta parada devuelve un true o false
	
	//sumaPlia() utilizar metodos pop y push, pop pop + push
	//si solo hay un numero hay que hacer un pop y si la pila esta vacia hay que volver a meter el numero
	
	//restaPila()
	
	//multiplicaPila()
	
	//divide plia()
}
