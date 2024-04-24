package main;

public class CPU {
	private OperaAndStack pila; //ADD PUSH DIV
	private Memoria stored_memory; //STORE LOAD
	private boolean halt;
	
	public CPU() {
		halt = false;
	}
	
	public boolean execute(ByteCode instrucion) {
		/*if (instruction == ENUM_BYTECODE.ADD ){
			//llamar sima pila
			  if(sumaPila()){
			  return true;
			  }
		}else {
			return false;
		]*/
		//CPU ejecuta instuciones recibe una instruccion y l aejecuta
		return halt;
	}
	
	public String toString() {
		//va a llamar al metodo toString del OperaAndStack y el de metodo memory
		//concatena el OperaAndStack y la Memoria
		return null;
	}
	
	//metodo erase, se encarga de borrar la pila y la memoria(tienen que desaparecer los atributos, los tiene que dejar como nuevos)
	//los tiene que dejar vacios como un RESET o algo asi
	public void Erase() {
		//OperaAndStack[] newOperaStack = new OperaAndStack[];
	}
	
	//isHalt?() devuelve un booleano de si la maquina esta parada devuelve un true o false
	
	//boolean sumaPlia() utilizar metodos pop y push, pop pop + push
	//si solo hay un numero hay que hacer un pop y si la pila esta vacia hay que volver a meter el numero
	//si es un -1 no hay nada que coger
	
	//boolean restaPila()
	
	//boolean multiplicaPila()
	
	//boolean divide plia()
}
