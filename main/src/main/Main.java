package main;
/**
 * @author emi
 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Engine eng = new Engine();
		eng.start()*/
		
		//ZONA PRUEBAS
		OperaAndStack num1 = new OperaAndStack();
		Memoria memo = new Memoria();
		memo.write(0, 0);
	    memo.write(3, 4);
	    System.out.println(memo);
		num1.push(4);
		memo.write(22, 3);

        // Configurar una instancia de CPU con las instancias creadas
        CPU cpu = new CPU();
        cpu.setPila(num1);
        cpu.setStoredMemory(memo);

        // Llamar al método toString() de la CPU
        String cpuToString = cpu.toString();

        // Imprimir el resultado o realizar alguna evaluación
        System.out.println("Representación en cadena de la CPU:");
        System.out.println(cpuToString);
		
	}

}
