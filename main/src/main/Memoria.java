package main;
/**
 * @author Emi
 */
public class Memoria {
	private final Integer MAX_MEMORY = 10;
	private Integer[] Memory;
	private boolean null_elem;
	private int size;
	/**
	 * Memoria constructora encargada de de inicializar los atributos
	 */
	public Memoria() {
		this.Memory = new Integer[MAX_MEMORY];
		this.size = MAX_MEMORY;
		this.null_elem = true;
	}
	/**
	 * toString metodo encargado de crear lo siguiente; "Memoria: [0]:0 [3]:4" haciendo un par de llamadas a Memory i
	 * @return chain la cadena con el interior del array, si no hay nada retornara empty
	 */
	public String toString() {
		String chain = "";
		StringBuilder sb = new StringBuilder();
	    chain += ("Memory: ");
	    int i = 0;
	    for (i = 0; i < this.Memory.length; i++) {
	        if (this.Memory[i] != null) {
	        	chain += "[" + i + "]:" + this.Memory[i] + " ";
	        }
	    }
	    
	    if (this.null_elem) {
	        chain += "<empty>";
	    }
	    
		return chain;
		
	}
	/**
	 * write metodo booleano encargado de recibir dos paramentros un Integer indicando la posicion y otoro Integer indicando el Valor. Estos sinedo la posicion en la que indicamos cuando hacemos un STROE x y el valor de la pila guardandolo en la posicion x de la memoria 
	 * @param posicion Ineger recibido despues de un STORE x, x indicando la posicion donde se almacenara en la memoria
	 * @param valor Ineger, este siendo el ultimo elemento de la pila en caso de que lo haya
	 * @return true si la ejecucion ha sido exitos. False si no lo ha sido. Esto dependera de la posicion que debe ser >= 0
	 */
	public boolean write(Integer posicion, Integer valor) {
		if (posicion >= 0) {
			this.resize(posicion);
			this.Memory[posicion] = valor;
			
			this.null_elem = false;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * read metodo Integer. Retorna el elemento el la posicion recibida por parametro. Si en esta no hay nada escrito retornara un menos uno. Este es usado para hacer un LOAD x, x indicando la posicon recibida por parametro
	 * @param posicion Integer. Indica la posicion LOAD x, x indicando la posicon recibida por parametro.
	 * @return Memory[posicion] si la posicion recibida por parametro no es null en la memoira, en caso de serlo devolvera un menos 1
	 */
	public Integer read (Integer posicion) {
		if (Memory[posicion] != null) {
			return Memory[posicion];	
		}else {
			return -1;
		}
	}
	
	/**
	 * resize metodo que se encarga de recibir por parametro un Integer indicando la posicion de donde se quiere almacenar un valor si este es mayor que this.size lo que hara nuestro programa es crear un nuevo array con el el length doble de posicon * 2 copiara todos los elementos enteriormente en el array viejo y devolvera el array nuevo con el length posicion * 2
	 * @param posicion Integer indica donde quiere guardar el usuario el parametro
	 */
	private void resize(Integer posicion) {
		this.null_elem = false;
		
		if (posicion >= this.size) {
			Integer[] resizeArray = new Integer[posicion * 2];
			
			for (int i = 0; i < posicion; i++) {
				if (i < size) {
					resizeArray[i] = this.Memory[i];				
				}else {
					resizeArray[i] = null;
				}
			}
			
			this.Memory = resizeArray;
		}
		
	}
	
	/**
	 * getNullElem metodo boolean getter que devuelve el this.null_elem
	 * @return this.null_elem si es true o false
	 */
	public boolean getNullElem() {
		return this.null_elem;
	}
	
	/**
	 * getMemory metodo Integer[] getter que devuelve this.Memory
	 * @return this.Memory el array de la clase Memorua
	 */
	public Integer[] getMemory(){
		return this.Memory;
	}
	
	/**
	 * setMemory metodo setter que recibe por parametro un Integer[] y convierte el yhis.Memory en ese parametro
	 * @param erasedMemory Integer[] encargado de settear el this.memory
	 */
	public void setMemory(Integer[] erasedMemory){
		this.Memory = erasedMemory;
	}
	
}
