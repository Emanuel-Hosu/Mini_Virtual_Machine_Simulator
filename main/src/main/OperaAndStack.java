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
	public OperaAndStack(){
		//num_elems ++?
		this.Stack = new int[MAX_STACK];
		this.num_elems = 0;
	}
	/**
	 * toString
	 * @param cadena
	 * @return cadena
	 */
	public String toString(String cadena) {
		return cadena;
	}
	/**
	 * isEmpty
	 * @return
	 */
	public boolean isEmpty() {
		//
		if (this.num_elems < this.Stack.length && this.Stack[num_elems] != -1) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * push
	 * @param num
	 */
	public void push(int num) {
		//COMPRUEBA SI EL STACK ESTA LLENO
		if (this.num_elems < this.Stack.length) {
			this.Stack[num_elems] = num;
			//System.out.println(this.Stack[num_elems]);
			num_elems ++;
		}
	}
	/**
	 * pop
	 * @return 
	 */
	public int pop() {
		int pop_num;
		
		if (isEmpty() == false) {
			pop_num = Stack[num_elems];
			
			Stack[num_elems] --;
			return pop_num;
		}else {
			return (Integer) null;
		}
	}
	/**
	 * getCima
	 * @return
	 */
	public int getCima(){
		if (isEmpty() == false) {
			return Stack[num_elems];
		}else {
			return (Integer) null;
		}
	}
}
