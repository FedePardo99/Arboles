package arboles;

public class Main {

	public static void main(String[] args) {
		ABBInt arbol = new ABBInt();
		//ABBInt arbol1 = new ABBInt();
		arbol.agregar(7);
		arbol.agregar(3);
		arbol.agregar(4);
		arbol.agregar(5);
		arbol.agregar(6);
		

		
		  
		//arbol2.quitar(50);
		System.out.println(arbol.esDegenerativo());
	}
	
}
