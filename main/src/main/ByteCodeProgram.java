package main;

/**
 * @author Emi
 */
public class ByteCodeProgram {
	private ByteCode[] program;
	private int num_elems;
	private int size;

	/**
	 * ByteCodeProgram constructora que se encarga de inicializar los atributos de
	 * la clase
	 */
	public ByteCodeProgram() {
		this.size = 1;
		this.num_elems = 0;
		this.program = new ByteCode[size];
	}

	/**
	 * add_ByteCode recibe por parametro un ByteCode y se encarga de aniadirlo al
	 * array de program de su propia clase
	 * 
	 * @param instruction recibido por parametro para aniadir el codigo ByteCode al
	 *                    array
	 */
	public void add_ByteCode(ByteCode instruction) {
		this.program[this.size - 1] = instruction;

		this.num_elems++;
	};

	/**
	 * setInstructionPosition metodo boolean que recibe por parametro una instrucion
	 * y una posicion, inserta el bytecode en la posicion position mientras sema
	 * mayor o igual a 0 y sea menor a size (siempre sera una posicion ocupada, va a
	 * machacar una posicion con replace) basicamente sirve para hacer el replace
	 * 
	 * @param instruction parametro recibido de tipo ByteCode, este sera aniadido en
	 *                    la posicion del siguiente parametro position
	 * @param position    parametro recibido de tipo int que indicara la posicon
	 *                    donde en instruction sera introduciod
	 * @return true o false en caso de que se haya llevado con exito la operacion
	 *         osea que posicion sea > a 0
	 */
	public boolean setInstructionPosition(ByteCode instruction, int position) {
		ByteCodeResize();
		if (position >= 0 && position < size) {
			this.program[position] = instruction;

			return true;
		} else {
			return false;
		}
	}

	/**
	 * setInstruction metodo que recibe por parametro un ByteCode, y se encarga de
	 * introducirlo en la primera posicion disponible del array de la misma clase
	 * 
	 * @param instruction recibido por parmaetro de tipo ByteCode, se introducira en
	 *                    la siguiente posicion del array program
	 */
	public void setInstruction(ByteCode instruction) {
		ByteCodeResize();
		this.program[(this.num_elems + 1) - 1] = instruction;

		this.num_elems++;
	}

	/**
	 * showN_ByteCode un metodo getter de tipo int que devuelve el this.size de esta
	 * clase
	 * 
	 * @return this.size de esta clase ByteCodeProgram
	 */
	public int showN_ByteCode() {
		return this.size;
	}

	/**
	 * ByteCodeResize metodo que hace el array mas grande haciendo un (size x 2) en
	 * caso de que el num_elems sea igual que size
	 */
	private void ByteCodeResize() {
		if (this.num_elems == this.size) {
			ByteCode[] resizeArray = new ByteCode[this.size * 2];

			for (int i = 0; i < this.size; i++) {
				if (i < this.size) {
					resizeArray[i] = this.program[i];
				} else {
					resizeArray[i] = null;
				}
			}
			this.program = resizeArray;
			this.size = resizeArray.length;
		}
	}

	/**
	 * runProgram metodo de tipo String, que se encarga de hacer una cadena enorme
	 * con los estados de la maquina y el programa almacenado, ejecutado codigo a
	 * codigo cada ejecucion una vez heco el string este limpiara la memoria
	 * 
	 * @param cpu recibe la cpu de engine por parametro
	 * @return mensaje este siendo la cadena enorme acumulada a lo largo de la
	 *         ejecucion de la maquina con cada programa almacenado
	 */
	public String runProgram(CPU cpu) {
		String mensaje = "";
		for (int i = 0; i < this.num_elems; i++) {
			if (!cpu.isHalt() && cpu.execute(this.program[i])) {
				if (this.program[i].getParam() != -1)
					mensaje += "\nThe state of the machine after executing " + this.program[i].getCode() + " "
							+ this.program[i].getParam() + " is:\n\nCPU state:\n" + cpu.toString() + "\n";
				else
					mensaje += "\nThe state of the machine after executing " + this.program[i].getCode()
							+ " is:\n\nCPU state:\n" + cpu.toString() + "\n";
			} else if (!cpu.isHalt()) { // Si hay error en la ejecucion
				mensaje += "Error: Incorrect execution of the command";
			}
		}

		cpu.erase(); // Limpiamos la CPU
		cpu.runCPU(); // Y lo volvemos a poner en marcha
		return mensaje;
	}

	/**
	 * reset metodo que se encarga de resetear el programa, inicializando todos los
	 * atributos de nuevo igual que en la constructora
	 */
	public void reset() {
		this.size = 1;
		this.num_elems = 0;
		this.program = new ByteCode[size];
	}

	/**
	 * toString metodo que imprime el programa almacenado, junto todo lo que aparece
	 * en el array
	 * 
	 * @return sb este siendo un string con todo el programa almacenado
	 */
	public String toString() {
		String sb = "";
		System.out.print("Stored program: \n");
		int i = 0;
		while (i < this.num_elems) {
			if (this.program[(i + 1) - 1].getParam() == -1) {
				sb += (i + ": " + this.program[(i + 1) - 1].getCode() + "\n");
			} else {
				sb += (i + ": " + this.program[(i + 1) - 1].getCode() + " " + this.program[(i + 1) - 1].getParam()
						+ "\n");
			}
			i++;
		}
		return sb;
	};
}
