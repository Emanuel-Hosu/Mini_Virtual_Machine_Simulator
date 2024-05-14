package main;

/**
 * @author emi
 */
public class OperaAndStack {
	private final int MAX_STACK = 10;
	private int[] Stack;
	private int num_elems;

	/**
	 * OperaAndStack constructora defaulta de la clase OperaAndStack encargada de
	 * inicializar los atributos
	 */
	public OperaAndStack() {
		this.Stack = new int[MAX_STACK];
		this.num_elems = 0;
	}

	/**
	 * toString metodo String que se encarga de crear la cadena "Pila: x y".
	 * Recorriendo Stack i imprimiendo los valores que tiene dentro
	 * 
	 * @return cadena String, esta siendo "Pila: x y", x y representado los valores
	 *         del interior de Stack i
	 */
	public String toString() {
		String cadena = "";

		for (int i = 0; i < this.num_elems; i++) {
			cadena += " " + this.Stack[i];
		}
		if ((num_elems - 1) == -1) {
			cadena = "<empty>";
		}

		return "Pila: " + cadena;
	}

	/**
	 * isEmpty metodo booleano que retorna que comprueba si el Stack tiene elementos dentro o no
	 * 
	 * @return false si hay elementos dentro, true de si no hay elementos dentro
	 */
	public boolean isEmpty() {
		// && this.Stack[num_elems - 1] != -1 pero no lo pongo para que salga el
		if (this.num_elems < this.Stack.length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * push metodo booleano que recibe por parametro un int que este comprobara si el stack esta lleno si no lo esta aniadira el int recibido por parametro en la siguiente posicion libre del array
	 * 
	 * @param num int parametro con el parametro del ByteCode
	 */
	public boolean push(int num) {
		// COMPRUEBA SI EL STACK ESTA LLENO
		if (this.num_elems < this.Stack.length) {
			this.Stack[this.num_elems] = num;
			this.num_elems++;
			return true;
		} else {
			return true;
		}
	}

	/**
	 * pop metodo int, encargado de verificar si el array esta vacio y si no lo esta sera guardar el numero del array , borrarlo del array y devolver el numero  guardado, Si el array esta vacio este devuelve un menos 1
	 * 
	 * @return
	 */
	public int pop() {
		int pop_num;

		if (isEmpty() == false) {
			pop_num = this.Stack[this.num_elems - 1];
			this.num_elems--;

			int[] newStack = new int[this.Stack.length];
			for (int i = 0; i < this.num_elems; i++) {
				newStack[i] = this.Stack[i];
			}

			for (int i = this.num_elems; i < this.Stack.length; i++) {
				newStack[i] = -1;
			}

			this.Stack = newStack;

			return pop_num;
		} else {
			return -1;
		}
	}

	/**
	 * getCima metodo int getter que comprueba si el array esta vacio si no lo esta nos devolvera el ultimo numero que hay en el array
	 * 
	 * @return el ultimo numero del array en el caso de que el array no este vacio, menos uno si el array esta vacio
	 */
	public int getCima() {
		if (isEmpty() == false) {
			return this.Stack[this.num_elems - 1];
		} else {
			return -1;
		}
	}
	
	/**
	 * getNumElems metodo int getter que retorna this.num_elems de la clase OperaAndStack
	 * @return this.num_elems
	 */
	public int getNumElems() {
		return this.num_elems;
	}

	/**
	 * getStack metodo int[] getter, que retorna this.Stack de la clase OperaAndStack
	 * @return this.Stack
	 */
	public int[] getStack() {
		return this.Stack;
	}

	/**
	 * setStack metodo setter que recibe por parametro un int[] que se encarga de darle un nuevo valor a this.Stack
	 * @param erasedStack int[]
	 */
	public void setStack(int[] erasedStack) {
		this.Stack = erasedStack;
	}
}
