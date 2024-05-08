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
		this.program = new ByteCode[size];
	}
	
	//add_ByteCode
	public void add_ByteCode(ByteCode instruction) {
		this.program[this.size - 1] = instruction;
		
		num_elems++;
	};
	
	//boolean setInstructionPosition (ByteCode, position), inserta el bytecode en la posicion position mientras sema mayor o igual a 0 y sea menor a size (siempre sera una posicion ocupada, va a machacar una posicion con replace)
	public boolean setInstructionPosition(ByteCode instruction, int position) {
		//alomejor hay que llamar a bytecode resize
		ByteCodeResize();
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
		ByteCodeResize();
		this.program[(this.num_elems + 1) - 1] = instruction;

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
				
//				System.out.println("Clase ByteCodeProgram Resize " + resizeArray.length);
			}
			this.program = resizeArray;
			size = resizeArray.length;
		}
	}
	
	//cuando identificamos que un programa llama a run hacemos una llamada a esto
	//String runProgram(CPU cpu) recorre el array(num_elems) y va ejecutando todos los bytecodes de programs.
		//Los recorre hasta num_elems
		//Para que se puedan ejecutar estos programsas: forma un String gigante, this.program[i].toString;
			//El estado de la maquina
			/*Comienza la ejecución de RUN
			El estado de la maquina tras ejecutar el bytecode this.program[i].toString es:
			Estado de la CPU:
			cpu.toString
			El estado de la maquina tras ejecutar el bytecode this.program[i].toString es:
			Estado de la CPU:
			cpu.toString
			El estado de la maquina tras ejecutar el bytecode ADD es:
			Estado de la CPU:
			Memoria: <vacia>
			Pila: 5
			El estado de la maquina tras ejecutar el bytecode STORE 4 es:
			Estado de la CPU:
			Memoria: [4]:5
			Pila: <vacia>
			
			cuando acabe el while
			Programa almacenado:
			i:  this.program[i].toString*/
		//for o while con 
		//El estado de la maquina tras ejecutar el bytecode this.program[i].toString es:
		//\n
		//Estado de la CPU:
		//Memoria: Memoria.toString;
		//Pila: Command.toStrin;(hay que revisar)
	public String runProgram(CPU cpu) {
		String mensaje = "";
		for (int i = 0; i < this.num_elems; i++) {
			if(!cpu.isHalt() && cpu.execute(this.program[i])) {
				//bla bla bla
				mensaje += "the state of the machine after executing " + this.program[i].toString() + " is:\nCPU state:\n" + cpu.toString();
			}else if(!cpu.isHalt()) { // Si hay error en la ejecucion
				//bla bla bla
				mensaje += "Error: Incorrect execution of the command";
			}
		}
		
		cpu.erase(); // Limpiamos la CPU
		cpu.runCPU(); // Y lo volvemos a poner en marcha
		return mensaje;
	}
	
	//Crear un metodo void reset();
	public void reset() {
		this.program = new ByteCode[0];
	}
	
	//HAY QUE HACER COSAS EN RESIZE Y LUEGO ARREGALR ESTO.
	public String toString() {
		//Imprime programa almacenado
		//junto a todo lo que aparece en el array \n
		//while i num_elems
		// this.program[i]
		/*Programa almacenado:
			0: PUSH 2
			1: PUSH 3
			2: ADD
			3: STORE 4*/
		String sb = "";
		System.out.print("Stored program: \n");
		int i = 0;
		while (i < this.num_elems) {
			sb += (i +": " + this.program[(i + 1) - 1].getCode() + " " + this.program[(i + 1)  - 1].getParam() + "\n");
			
			i++;
		}
		return sb;
	};
}
