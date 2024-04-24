package main;
//A ESTE HAY QUE DARLE UNA VUELTA
public class ByteCodeProgram {
	private ByteCode[] program;
	private int num_elems;
	private int size;
	
	//tiene una constructora 
	public ByteCodeProgram() {
		this.size = 1;
		this.num_elems = 0;
	}
	
	//add_ByteCode
	public void add_ByteCode(ByteCode instruction) {
		this.program[this.size - 1] = instruction;
		
		num_elems++;
	};
	
	//boolean setInstructionPosition (ByteCode, position), inserta el bytecode en la posicion position mientras sema mayor o igual a 0 y sea menor a size (siempre sera una posicion ocupada, va a machacar una posicion con replace)
	public boolean setInstructionPosition(ByteCode instruction, int position) {
		//alomejor hay que llamar a bytecode resize
		if (position >= 0 && position < size) {
			this.program[position] = instruction;
			
			num_elems++;
			return true;
		}else {
			return false;
		}
	}
	//void setInstruction(Bytecode) inserta en bytecode siguiente en la siguiente posicion disponible 
	public void setInstruction (ByteCode instruction) {
		this.program[this.size - 1] = instruction;

		num_elems++;
	}
	
	//replace_ByteCode(Recibe algo) inventada
	
	//showN_ByteCode devuelve la instruccion iesima
	public int showN_ByteCode(){
		return this.size;
	}
	
	
	//ByteCodeResize()
		//if numelems == a no se que
		//Si se llena entonces sera un size * 2
	private void ByteCodeResize() {
		if (num_elems == size) {
			ByteCode[] resizeArray = new ByteCode[size * 2];
			
			for (int i = 0; i < size; i++) {
				if (i < size) {
					resizeArray[i] = program[i];				
				}else {
					resizeArray[i] = null;
				}
				
				System.out.println("Clase ByteCodeProfram " + resizeArray.length);
				this.program = resizeArray;
			}
		}
	}
	
	//cuando identificamos que un programa llama a run hacemos una llamada a esto
	//runProgram() recorre el array y va ejecutando todo el programa
	
	public String toString() {
		//Imprime programa almacenado
		//junto a todo lo que aparece en el array \n
		return "Programa almacenado: \n " + this.program;
	};
}
