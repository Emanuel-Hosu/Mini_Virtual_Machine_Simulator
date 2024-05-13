package main;

/**
 * @author emi
 */
public class OperaAndStack {
	private final int MAX_STACK = 10;
	private int[] Stack;
	private int num_elems;

	/**
	 * OperaAndStack
	 */
	public OperaAndStack() {
		// num_elems ++?
		this.Stack = new int[MAX_STACK];
		this.num_elems = 0;
	}

	/**
	 * toString
	 * 
	 * @return cadena
	 */
	public String toString() {
		// Pila: 0 4
		String cadena = "";

		for (int i = 0; i < num_elems; i++) {
			cadena += " " + Stack[i];
		}
		if ((num_elems - 1) == -1) {
			cadena = "<empty>";
		}
		
		return "Pila: " + cadena;
	}

	/**
	 * isEmpty
	 * 
	 * @return
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
	 * push
	 * 
	 * @param num
	 */
	public boolean push(int num) {
		// COMPRUEBA SI EL STACK ESTA LLENO
		if (this.num_elems < this.Stack.length) {
			this.Stack[num_elems] = num;
			// System.out.println(this.Stack[num_elems]);
			num_elems++;
			return true;
		} else {
			return true;
		}
	}

	/**
	 * pop
	 * 
	 * @return
	 */
	public int pop() {
		int pop_num;

		if (isEmpty() == false) {
			pop_num = Stack[num_elems - 1];
			num_elems--;

			int[] newStack = new int[Stack.length];
			for (int i = 0; i < num_elems; i++) {
				newStack[i] = Stack[i];
			}
			
			for (int i = num_elems; i < Stack.length; i++) {
	            newStack[i] = -1;
	        }

			Stack = newStack;
			
			return pop_num;
		} else {
			return -1;
		}
	}

	/**
	 * getCima
	 * 
	 * @return
	 */
	public int getCima() {
		if (isEmpty() == false) {
			return Stack[num_elems - 1];
		} else {
			// SIGNIFICA QUE ESTA VACIO
			return -1;
		}
	}

	public int getNumElems() {
		return this.num_elems;
	}

	public int[] getStack() {
		return this.Stack;
	}

	public void setStack(int[] erasedStack) {
		this.Stack = erasedStack;
	}
}
