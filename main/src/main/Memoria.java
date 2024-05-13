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
		//Memoria: [0]:0 [3]:4
		String chain = "";
		StringBuilder sb = new StringBuilder();
	    chain += ("Memory: ");
	    int i = 0;
	    for (i = 0; i < Memory.length; i++) {
	        if (Memory[i] != null) {
	            //sb.append("[").append(i).append("]:").append(Memory[i]).append(" ");
	        	chain += "[" + i + "]:" + Memory[i] + " ";
	        }
	    }
	    
	    //Lo MISMO HAY QUE CAMBIAR ALGO AQUI, QUIEN SABE :,) habria que revisar el null_elem ese :,)
	    if (null_elem) {
	        chain += "<empty>";
	    }
	    
		return chain;
		
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
			
			null_elem = false;
			return true;
		}else {
			return false;
		}
	}
	
	//retorna el elemento el la posicion pos...
	//LOAD
	public Integer read (Integer posicion) {
		if (Memory[posicion] != null) {
			return Memory[posicion];	
		}else {
			return -1;
		}
	}
	
	private void resize(Integer posicion) {
		null_elem = false;
		
		if (posicion >= this.size) {
			Integer[] resizeArray = new Integer[posicion * 2];
			
			for (int i = 0; i < posicion; i++) {
				if (i < size) {
					resizeArray[i] = Memory[i];				
				}else {
					resizeArray[i] = null;
				}
			}
			
			//ajustarlo al array atributo
			System.out.println(resizeArray.length);
			this.Memory = resizeArray;
		}
		
	}
	
	public boolean getNullElem() {
		return null_elem;
	}
	
	public Integer[] getMemory(){
		return Memory;
	}
	
	public void setMemory(Integer[] erasedMemory){
		this.Memory = erasedMemory;
	}
	
}
