package main;
/**
 * @author emisi
 */
public class Memoria {
	private final Integer MAX_MEMORY = 10;
	private Integer[] Memory;
	private boolean null_elem;
	private int size;
	/**
	 * Memoria
	 */
	public Memoria() {
		this.Memory = new Integer[MAX_MEMORY];
		size = MAX_MEMORY;
		null_elem = true;
	}
	/**
	 * toString
	 * @param cadena
	 * @return
	 */
	public String toString() {
		return null;
		//Memoria: [0]:0 [3]:4
	}
	/**
	 * write
	 * @param posicion
	 * @param valor
	 * @return
	 */
	public boolean write(Integer posicion, Integer valor) {
		if (posicion >= 0) {
			this.resize(posicion);
			this.Memory[posicion] = valor;
			
			return true;
		}else {
			return false;
		}
	}
	
	//retorna el elemento el la posicion pos...
	public Integer read (Integer posicion) {
		if (Memory[posicion] != null) {
			return Memory[posicion];	
		}else {
			return -1;
		}
	}
	
	private void resize(Integer posicion) {
		//O ALOMEJOR EN VEZ DE SER SIZE * 2 SER
		null_elem = false;
		
		if (posicion > this.size) {
			Integer[] resizeArray = new Integer[posicion * 2];
			
			for (int i = 0; i < posicion; i++) {
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
	
}
