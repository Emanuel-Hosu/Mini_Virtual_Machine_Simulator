package main;

/**
 * @author Emi
 */
public class CPU {
	private OperaAndStack pila; // ADD PUSH DIV
	private Memoria stored_memory; // STORE LOAD
	private boolean halt;

	/**
	 * CPU construcora de la clase CPU encargada de inicializar los atributos
	 */
	public CPU() {
		this.halt = true;
		this.pila = new OperaAndStack();
		this.stored_memory = new Memoria();
	}

	/**
	 * runCPU metodo llamado desde el engine para arrancar la maquina (false es que
	 * la maquina NO esta apagada)
	 */
	public void runCPU() {
		this.halt = false;
	}

	/**
	 * stopCPU metodo llamado de engine en caso de que se ejecute el comando HALT (
	 * true es que esta apagada la maquina)
	 * 
	 * @return this.halt (el halt en true)
	 */
	public boolean stopCPU() {
		this.halt = true;
		return this.halt;
	}

	/**
	 * isHalt metodo booleano de la clase CPU, devuelve un booleano de si la maquina
	 * esta parada devuelve un true o false. Este es llamado en diferentes metodos
	 * de diferentes clases
	 * 
	 * @return halt (este puede estar en true o false dependiendo de como este el
	 *         estado de la maquina)
	 */
	public boolean isHalt() {
		return this.halt;
	}

	/**
	 * setPila metodo setter de la clase cpu que "le da valor al atributo"
	 * 
	 * @param pila OperaAndStack encargado de darle valor a la this.pila
	 */
	public void setPila(OperaAndStack pila) {
		this.pila = pila;
	}

	/**
	 * setStoredMemory segundo metodo setter de la clase CPU encargado de dalre un
	 * valor a this.stored_memory
	 * 
	 * @param _stored_memory Memoria, ecargado de darle valor a this.stored_memory
	 */
	public void setStoredMemory(Memoria _stored_memory) {
		this.stored_memory = _stored_memory;
	}

	/**
	 * execute metodo booleano, encargado de hacer un switch comparando los codigos
	 * que recibe a traves del parametro, una vez el codigo (continuacion del
	 * NEWINST) concuerda este llama a un metodo de la propia clase encargado de
	 * hacer lo que pide dependiendo del codigo. OSea CPU ejecuta instuciones recibe
	 * una instruccion y la ejecuta
	 * 
	 * @param instrucion ByteCode, parametro con la continuacion del newinst
	 * @return dependiendo de la instrucion el metodo correspondiente (metodo que
	 *         esta en la propia clase)
	 */
	public boolean execute(ByteCode instrucion) {
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

	/**
	 * out metodo boolean, encargado de crear una cadena con la cima de la pila
	 * cuando este sea ejecutado e imprimirla al comienzo de run. Siempre y cuando
	 * la pila no este vacia
	 * 
	 * @return true si la pila no esta vacia y la ejecucion ha sido exitosa y false
	 *         si la pila esta vacia
	 */
	public boolean out() {
		if (this.pila.isEmpty() == false && this.pila.getNumElems() > 0) {
			System.out.println("The top of the pile is " + this.pila.getCima());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * load metodo booleano, encargado de recoger el parametro almacenado en memoria
	 * en la posicion introducida por el usuario (el parametro pos) y introducirla
	 * en la pila. Siempre y cuando haya algo almacenado en la memoria
	 * 
	 * @param pos Integer parametro encargado de dar la posicon al load del cual se
	 *            quiere coger la informacio
	 * @return true si la memoria no esta vacia y el push ha sido exitoso, false si
	 *         el push no ha sido exitos o si la memoria esta vacia
	 */
	public boolean load(Integer pos) {
		if (this.stored_memory.getNullElem() != true) {
			Integer valueCimaMemory = this.stored_memory.read(pos);
			if (valueCimaMemory != -1) {
				if (this.pila.push(valueCimaMemory))
					return true;
				else
					return false;				
			}
		}
		return false;
	}

	/**
	 * store metodo booleano. Encargado de guardar en la memoria el elemento de la
	 * cima de la pila, asi eliminandolo a su paso, este sera introducido en la
	 * posicon que el usuario diga esta siendo recibida por parametro (pos).Este
	 * metodo se ejecutrara siempre y cuando haya almenos un elemento en la pila y
	 * esta no este vacia
	 * 
	 * @param pos Integer, posicion donde sera almacenado la cima de la pila
	 * @return true si la pila no esta vacia, hay almenos un elemento en ella, y si
	 *         la escritura en la memoria ha sido exitosa. False si alemnos una cosa
	 *         de lo que he dicho anteriormente es no esta siendo exitosa
	 */
	public boolean store(Integer pos) {
		if (this.pila.isEmpty() == false) {
			this.stored_memory.write(pos, this.pila.pop());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * toString metodo de tipo String, encargado de llamar al metodo toString del
	 * OperaAndStack y el de metodo memory y concatena amos metodos toString() de
	 * cada clase
	 * 
	 * @return sb este siendo un StringBuilder que crea la cadena es como un String
	 *         +=
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.stored_memory.toString() + "\n");
		sb.append(this.pila.toString());

		return sb.toString();
	}

	/**
	 * erase metodo que se encarga de borrar la pila y la memoria. Los deja como
	 * nuevos (vacios)
	 */
	public void erase() {
		this.pila = new OperaAndStack();
		this.stored_memory = new Memoria();
	}

	/**
	 * sumaPila metodo booleano encargado de sacar de la pila los dos elementos que
	 * hay y sumarlos y despues volver a introducir el resultado de los dos
	 * elementos a traves de un push. Siempre se ejecutara cunado la pila no este
	 * vacia y cuando hayan alemnos dos elementos en la pila.
	 * 
	 * @return true si la pila no esta vacia y hayan mas de dos elementos dentro.
	 *         False si es todo lo contrario a lo que he dicho
	 */
	public boolean sumaPila() {
		if (this.pila.isEmpty() == false && this.pila.getNumElems() > 1) {
			int num1 = this.pila.pop();
			int num2 = this.pila.pop();

			int resultado = num1 + num2;
			this.pila.push(resultado);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * restaPila metodo booleano encargado de sacar de la pila los dos elementos que
	 * hay y restarlos y despues volver a introducir el resultado de los dos
	 * elementos a traves de un push. Siempre se ejecutara cunado la pila no este
	 * vacia y cuando hayan alemnos dos elementos en la pila.
	 * 
	 * @return true si la pila no esta vacia y hayan mas de dos elementos dentro.
	 *         False si es todo lo contrario a lo que he dicho
	 */
	public boolean restaPila() {
		if (this.pila.isEmpty() == false && this.pila.getNumElems() > 1) {
			int num1 = this.pila.pop();
			int num2 = this.pila.pop();

			int resultado = num1 - num2;
			this.pila.push(resultado);
			return true;
		} else {
			return false;
		}
	};

	/**
	 * multiplicaPila metodo booleano encargado de sacar de la pila los dos
	 * elementos que hay y multiplicarlos y despues volver a introducir el resultado
	 * de los dos elementos a traves de un push. Siempre se ejecutara cunado la pila
	 * no este vacia y cuando hayan alemnos dos elementos en la pila.
	 * 
	 * @return true si la pila no esta vacia y hayan mas de dos elementos dentro.
	 *         False si es todo lo contrario a lo que he dicho
	 */
	public boolean multiplicaPila() {
		if (this.pila.isEmpty() == false && this.pila.getNumElems() > 1) {
			int num1 = this.pila.pop();
			int num2 = this.pila.pop();

			int resultado = num1 * num2;
			this.pila.push(resultado);
			return true;
		} else {
			return false;
		}
	};

	/**
	 * dividePila metodo booleano encargado de sacar de la pila los dos elementos
	 * que hay y dividirlos y despues volver a introducir el resultado de los dos
	 * elementos a traves de un push. Siempre se ejecutara cunado la pila no este
	 * vacia y cuando hayan alemnos dos elementos en la pila.
	 * 
	 * @return true si la pila no esta vacia y hayan mas de dos elementos dentro.
	 *         False si es todo lo contrario a lo que he dicho
	 */
	public boolean dividePila() {
		if (pila.isEmpty() == false && this.pila.getNumElems() > 1) {
			int num1 = this.pila.pop();
			int num2 = this.pila.pop();

			int resultado = num1 / num2;
			this.pila.push(resultado);
			return true;
		} else {
			return false;
		}
	};

	/**
	 * push metodo booleano encargado de pushear al array de pila (OperaAndStack) el
	 * numero que ha sido introducido por el usuario el (parametro)
	 * 
	 * @param number int. Introducido por el usuario (este siendo el parametro
	 *               seguido de algun ByteCode)
	 * @return true si push no ha dado nignun error. False si push ha dado algun
	 *         error
	 */
	public boolean push(int number) {
		if (this.pila.push(number))
			return true;
		else
			return false;
	};
}