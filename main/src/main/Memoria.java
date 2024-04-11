package main;
/**
 * @author emisi
 */
public class Memoria {
	private final Integer MAX_MEMORY = 10;
	private Integer[] Memory;
	private Integer null_elem;
	private int size;
	/**
	 * Memoria
	 */
	public Memoria() {
		this.Memory = new Integer[MAX_MEMORY];
		size = MAX_MEMORY;
		null_elem = null;
	}
	/**
	 * toString
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
//		if (this.size < this.Memory.length) {
//			for (int i = 0; i < Memory.length; i++) {
//				if (this.Memory[i] == posicion) {
//					this.Memory[i] = valor;
//					
//				}
//			}
//			
//			return true;
//		}else {
//			return false;
//		}
		
		while (posicion <= resize()) {
			
		}
	}
	
	//retorna el elemento el la posicion pos...
	public Integer read (Integer posicion) {
		Integer pos = null;
		for (int i = 0; i <= posicion; i ++) {
			if (i == posicion) {
				pos = Memory[i];
			}
		}
		
		return pos;
	}
	
	private void resize() {
		//O ALOMEJOR EN VEZ DE SER SIZE * 2 SER
		Integer[] resizeArray = new Integer[size * 2];
		
		for (int i = 0; i < Memory.length; i++) {
			if (i < size) {
				resizeArray[i] = Memory[i];				
			}else {
				resizeArray[i] = null;
			}
		}
		
		//ajustarlo al array atributo
		this.Memory = resizeArray;
	}
	
}
