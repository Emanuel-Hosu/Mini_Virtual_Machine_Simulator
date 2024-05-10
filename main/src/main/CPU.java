package main;

public class CPU {
	private OperaAndStack pila; //ADD PUSH DIV
	private Memoria stored_memory; //STORE LOAD
	private boolean halt;
	
	public CPU() {
		this.halt = true;
	}
	
	//hay que llamarlo al darle a run en engine
	public void runCPU() {
		this.halt = false;
	}
	
	public void setPila(OperaAndStack pila) {
        this.pila = pila;
    }

    public void setStoredMemory(Memoria _stored_memory) {
        this.stored_memory = _stored_memory;
    }
	
    //cambiar la movida de new ByteCode(ENMU no se que)
	public boolean execute(ByteCode instrucion) {
		if (instrucion.equals(ENUM_BYTECODE.ADD)) {
			if(sumaPila() == true) {				
				return true;
			}else {
				return false;
			}
		}else if(instrucion.equals(ENUM_BYTECODE.SUB)) {
			if(restaPila() == true) {				
				return true;
			}else {
				return false;
			}
		}else if(instrucion.equals(ENUM_BYTECODE.MUL)) {
			if(multiplicaPila() == true) {				
				return true;
			}else {
				return false;
			}
		}else if(instrucion.equals(ENUM_BYTECODE.DIV)) {
			if(dividePila() == true) {				
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		//CPU ejecuta instuciones recibe una instruccion y l aejecuta
	}
	
	//va a llamar al metodo toString del OperaAndStack y el de metodo memory
	//concatena el OperaAndStack y la Memoria
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(stored_memory.toString() + "\n");
		sb.append(pila.toString());
		
		return sb.toString();
	}
	
	//metodo erase, se encarga de borrar la pila y la memoria(tienen que desaparecer los atributos, los tiene que dejar como nuevos)
	//los tiene que dejar vacios como un RESET o algo asi
	public void erase() {
		pila = new OperaAndStack();
		stored_memory = new Memoria();
	}
	
	//isHalt?() devuelve un booleano de si la maquina esta parada devuelve un true o false
	public boolean isHalt() {
		return halt;
	}
	
	//boolean sumaPlia() utilizar metodos pop y push, pop pop + push
	//si solo hay un numero hay que hacer un pop y si la pila esta vacia hay que volver a meter el numero
	//si es un -1 no hay nada que coger
	//ME FALTA RETORNAR EL RESULTADO
	public boolean sumaPila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();
			
			int resultado = num1 + num2;
			pila.push(resultado);
			return true;
		}else {
			return false;
		}
	};
	
	//boolean restaPila()
	public boolean restaPila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();
			
			int resultado = num1 - num2;
			pila.push(resultado);
			return true;
		}else {
			return false;
		}
	};
	
	//boolean multiplicaPila()
	public boolean multiplicaPila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();
			
			int resultado = num1 * num2;
			pila.push(resultado);
			return true;
		}else {
			return false;
		}
	};
	
	//boolean dividePlia()
	public boolean dividePila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();
			
			int resultado = num1 / num2;
			pila.push(resultado);
			return true;
		}else {
			return false;
		}
	};
}

//CUANDO SE HACE UN OUT LA CPU HACE UN SISTEM PRINY, ORDENA Y SACA LA CIMA DE LA PILA ES:  CON PILA.GETCIMA
