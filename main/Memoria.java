package main;
/**
 * @author emisi
 */
public class Memoria {
	private final Integer MAX_MEMORY = 10;
	private Integer[] Memory;
	private int size;
	/**
	 * Memoria
	 */
	public Memoria() {
		//Size ++?
		
		this.Memory = new Integer[MAX_MEMORY];
		size = -1;
	}
	/**
	 * 
	 * @param cadena
	 * @return
	 */
	public String toString(String cadena) {
		return cadena;
	}
	/**
	 * write
	 * @param posicion
	 * @param valor
	 * @return
	 */
	public boolean write(Integer posicion, Integer valor) {
		//Si no esta vacio
		if (this.size < this.Memory.length && this.Memory[size] != -1) {
			for (int i = 0; i < Memory.length; i++) {
				if (this.Memory[i] == posicion) {
					this.Memory[i] = valor;
				}
			}
			
			return true;
		}else {
			return false;
		}
	}
	
	/*No entiendo
	public Integer read (Integer posicion) {
		
	}*/
	
	public void resize() {
		//O ALOMEJOR EN VEZ DE SER SIZE * 2 SER
		Integer[] resizeArray = new Integer[size * 2];
		
		for (int i = 0; i < size; i++) {
			resizeArray[i] = Memory[i];
		}
	}
	
}
