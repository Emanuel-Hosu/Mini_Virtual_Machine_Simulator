package main;

public class CPU {
	private OperaAndStack pila; // ADD PUSH DIV
	private Memoria stored_memory; // STORE LOAD
	private boolean halt;

	public CPU() {
		this.halt = true;
		this.pila = new OperaAndStack();
		this.stored_memory = new Memoria();

	}

	public void runCPU() {
		//Este lo llamo desde el engine
		//false es que la maquina no esta apagada
		this.halt = false;
	}

	public boolean stopCPU() {
		//true es que esta apagada la maquina
		this.halt = true;
		return this.halt;
	}

	// isHalt?() devuelve un booleano de si la maquina esta parada devuelve un true o false
	public boolean isHalt() {
		return halt;
	}

	public void setPila(OperaAndStack pila) {
		this.pila = pila;
	}

	public void setStoredMemory(Memoria _stored_memory) {
		this.stored_memory = _stored_memory;
	}

	// HAY QUE HACER COSAS AQUI
	// cambiar la movida de new ByteCode(ENMU no se que)
	public boolean execute(ByteCode instrucion) {
		// CPU ejecuta instuciones recibe una instruccion y l aejecuta
		switch (instrucion.getCode()) {
		case ADD:
			return sumaPila();
		case SUB:
			return restaPila();
		case DIV:
			return dividePila();
		case MUL:
			return multiplicaPila();
		case PUSH:
			return push(instrucion.getParam());
		case HALT:
			return stopCPU();
		case LOAD:
			return load(instrucion.getParam());
		case OUT:
			return out();
		case STORE:
			return store(instrucion.getParam());
		default:
			System.out.println("Error: wrong istruction");
			return false;
		}
	}
	//CUANDO SE HACE UN OUT LA CPU HACE UN SISTEM PRINY, ORDENA Y SACA LA CIMA DE LA PILA ES:  CON PILA.GETCIMA
	public boolean out() {
		System.out.println("Program has added to stack " + pila.getCima());
		int valueCimaStack = pila.getCima();
		if (pila.push(valueCimaStack))
			return true;
		else
			return false;
	}
	
	public boolean load(Integer pos) {
//		Integer valueCimaMemory = stored_memory.read(pos);
//		if (pila.push(valueCimaMemory))
//			return true;
//		else
//			return false;
		if (stored_memory.getNullElem() != true) {
			Integer valueCimaMemory = stored_memory.read(pos);
			if (pila.push(valueCimaMemory))
				return true;
			else
				return false;			
		}else {
			return false;
		}
	}
	
	public boolean store(Integer pos) {
		if (pila.isEmpty() == false && pila.getNumElems() > 0) {
			Integer valueCima = pila.pop();
			if (stored_memory.write(pos, valueCima))
				return true;
			else
				return false;			
		}else {
			return false;
		}
	}

	// va a llamar al metodo toString del OperaAndStack y el de metodo memory
	// concatena el OperaAndStack y la Memoria
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(stored_memory.toString() + "\n");
		sb.append(pila.toString());

		return sb.toString();
	}

	// metodo erase, se encarga de borrar la pila y la memoria(tienen que
	// desaparecer los atributos, los tiene que dejar como nuevos)
	// los tiene que dejar vacios como un RESET o algo asi
	public void erase() {
		pila = new OperaAndStack();
		stored_memory = new Memoria();
	}

	// boolean sumaPlia() utilizar metodos pop y push, pop pop + push
	// si solo hay un numero hay que hacer un pop y si la pila esta vacia hay que
	// volver a meter el numero
	// si es un -1 no hay nada que coger
	// ME FALTA RETORNAR EL RESULTADO
	// PASA ALGO AQUI HAYQ QUE REVISAR EL IS EPMTY Y EL GETNUMELEMS
	public boolean sumaPila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();

			int resultado = num1 + num2;
			pila.push(resultado);
			return true;
		} else {
			return false;
		}
	}

	// boolean restaPila()
	public boolean restaPila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();

			int resultado = num1 - num2;
			pila.push(resultado);
			return true;
		} else {
			return false;
		}
	};

	// boolean multiplicaPila()
	public boolean multiplicaPila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();

			int resultado = num1 * num2;
			pila.push(resultado);
			return true;
		} else {
			return false;
		}
	};

	// boolean dividePlia()
	public boolean dividePila() {
		if (pila.isEmpty() == false && pila.getNumElems() > 1) {
			int num1 = pila.pop();
			int num2 = pila.pop();

			int resultado = num1 / num2;
			pila.push(resultado);
			return true;
		} else {
			return false;
		}
	};

	public boolean push(int number) {
		if (pila.push(number))
			return true;
		else
			return false;
	};
}