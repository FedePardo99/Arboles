package arboles;

public class ABInt {
	protected class NodoInt {
		protected int elem;
		protected NodoInt der, izq;

		NodoInt(int valor) {
			elem = valor;
		}
	}

	protected NodoInt raiz;

	public String toStringPreOrder() {
		return preOrder(raiz);
	}
	
	public String toStringPostOrden() {
		return postOrden(raiz);
	}
	
	public String toStringIneOrder() {
		return inOrder(raiz);
	}
	
	public int minimo() {
		return buscarMinimo(raiz,raiz.elem);
	}
	public int maximo() {
		return buscarMaximo(raiz,raiz.elem);
	}
	
	public void agregar(int elem) {
		raiz = agregar(raiz, elem);
	}

	private NodoInt agregar(NodoInt nodo, int elem) {
		if (nodo == null)
			return new NodoInt(elem);

		if (nodo.der != null)
			nodo.izq = agregar(nodo.izq, elem);
		else
			nodo.der = agregar(nodo.der, elem);

		return nodo;
	}

	public boolean pertenece(int elem) {
		return pertenece(raiz, elem);
	}

	

	public void quitar(int elem) {
		raiz = quitar(raiz, elem);
	}

	private String inOrder(NodoInt n) {
		if (n == null)
			return "";
		return inOrder(n.izq) + " " + n.elem + " " + inOrder(n.der);
	}

	private String preOrder(NodoInt n) {
		if (n == null)
			return "";
		return n.elem + "[ " + preOrder(n.izq) + " - " + preOrder(n.der) + " ]";
	}

	private String postOrden(NodoInt n) {
		if (n == null)
			return "";
		return postOrden(n.izq) + " " + postOrden(n.der) + " " + +n.elem + " ";
	}

	private int buscarReemplazoPorIzquierda(NodoInt nodo) {
		if (nodo.izq == null)
			return nodo.elem;
		return buscarReemplazoPorIzquierda(nodo.izq);
	}

	public int cantNodos() {
		return cantNodos(raiz);
	}

	protected int cantNodos(NodoInt nodo) {
		if (nodo == null)
			return 0;
		return 1 + cantNodos(nodo.izq) + cantNodos(nodo.der);
	}

	public int altura() {
		return altura(raiz);
	}

	public boolean estaBalanceado() {
		return estaBalanceado(raiz);
	}

	public boolean equals(NodoInt nodo) {
		return equals(raiz,nodo);
	}

	private boolean equals(NodoInt nodo1, NodoInt nodo2) {
		
		if(cantNodos(nodo1) != cantNodos(nodo2))
			return false;
		
		if(nodo1 == null && nodo2 == null)
			return true;
		
		if(nodo1.elem != nodo2.elem)
			return false;
		
		
		
		return equals(nodo1.izq, nodo2.izq) && equals(nodo1.der, nodo2.der);
	}
	public boolean esEquiponderado() {
		return esEquiponderado(raiz);
	}
	
	private boolean esEquiponderado(NodoInt nodo) {
		if(nodo == null)
			return true;
		
		if(sumarNodos(nodo.izq) != sumarNodos(nodo.der))
			return false;
		
		
		return esEquiponderado(nodo.izq) && esEquiponderado(nodo.der);
	}
	
	private int sumarNodos(NodoInt nodo) {
		if(nodo == null)
			return 0;
		
		return nodo.elem +sumarNodos(nodo.izq)+sumarNodos(nodo.der);
	}

	public boolean esABB() {
		return esABB(raiz);
	}

	public void intercambiarHijos() {
		intercambiarHijos(raiz);
	}

	private void intercambiarHijos(NodoInt nodo) {
		if(nodo == null)
			return;
		
		if(nodo.der!=null && nodo.izq!=null) {
			cambiarValores(nodo.der,nodo.izq);
			intercambiarHijos(nodo.izq);
			intercambiarHijos(nodo.der);
		}
	}

	private void cambiarValores(NodoInt der, NodoInt izq) {
		int n = der.elem;
		der.elem= izq.elem;
		izq.elem =n;
	}

	// --------------------------------------------------
	// ------------------- AUXILIARES -------------------
	// --------------------------------------------------
	
	private boolean esABB(NodoInt nodo) {
		if(nodo.izq == null || nodo.der == null)
			return true;
		
		if(nodo.izq.elem > nodo.elem || nodo.der.elem < nodo.elem)
			return false;
		
		return esABB(nodo.der) && esABB(nodo.izq);
	}
	
	
	
	private int buscarMaximo(NodoInt nodo,int maximo) {
		if(nodo == null)
			return maximo;
		
		int maximoActual = esMaximo(nodo.elem,maximo);
		
		 maximoActual = buscarMaximo(nodo.izq, maximoActual);
		 maximoActual = buscarMaximo(nodo.der, maximoActual);
		
		
		return maximoActual ;
	}
	
	private int esMaximo(int elem,int max) {
		return elem>max?elem:max;
	}
	
	
	private int buscarMinimo(NodoInt nodo,int minimo) {
		if(nodo == null)
			return minimo;
		
		int minimoActual = esMinimo(nodo.elem,minimo);
		
		minimoActual = buscarMinimo(nodo.izq, minimoActual);
		minimoActual = buscarMinimo(nodo.der, minimoActual);
		
		
		return minimoActual ;
	}
	
	private int esMinimo(int elem, int minimo) {
		return elem<minimo?elem:minimo;
	}

	
	private boolean estaBalanceado(NodoInt nodo) {
		if(nodo == null)
			return true;
		
		if(Math.abs(altura(nodo.izq)-altura(nodo.der)) > 1)
			return false;
		return estaBalanceado(nodo.der) && estaBalanceado(nodo.izq);
	}
	
	
	private boolean pertenece(NodoInt nodo, int elem) {
		if (nodo == null)
			return false;

		if (nodo.elem == elem)
			return true;

		return pertenece(nodo.izq, elem) || pertenece(nodo.der, elem);
	}
	
	public int alturaRamaConMasPeso() {
		return alturaRamaConMasPeso(raiz);
	}
	public int contarNodos(int elem) {
		return contarNodos(raiz,elem);
	}
	
	public int alturaRamaConMasRepeticiones(int elem) {
		return alturaRamaConMasRepeticiones(raiz,elem);
	}
	
	public String elementosImparesPostOrden() {
		return elementosImparesPostOrden(raiz);
	}
	
	

	private String elementosImparesPostOrden(NodoInt nodo) {
		if(nodo == null)
			return "";
		if(esImpar(nodo.elem))
			return elementosImparesPostOrden(nodo.izq) + elementosImparesPostOrden(nodo.der)+" "+ nodo.elem;
		
		return  elementosImparesPostOrden(nodo.izq) + elementosImparesPostOrden(nodo.der);
	}

	private boolean esImpar(int elem) {
		return elem % 2 == 1;  
	}

	/*
	 * 
	 * ------------------------------METODOS PRIVADOS DE LA CLASE ARBOL ------------------------------------------------
	 
	 */
	private int alturaRamaConMasRepeticiones(NodoInt nodo,int elem) {
		if(nodo == null)
			return 0;
		if(!pertenece(elem))
			return 0;
		
		if(contarNodos(nodo.izq,elem) > contarNodos(nodo.der,elem))
			return 1+alturaRamaConMasRepeticiones(nodo.izq,elem);
			
		return 1+alturaRamaConMasRepeticiones(nodo.der,elem);
	}
	
	private int contarNodos(NodoInt nodo, int elem) {
		if(nodo == null)
			return 0;
		
		if(nodo.elem == elem)
			return 1+contarNodos(nodo.der,elem)+contarNodos(nodo.izq, elem);
		
		return contarNodos(nodo.der,elem)+contarNodos(nodo.izq, elem);
	}

	private int alturaRamaConMasPeso(NodoInt nodo) {
		if(nodo == null)
			return 0;
		
		if(sumarNodos(nodo.izq) > sumarNodos(nodo.der))
			return 1+alturaRamaConMasPeso(nodo.izq);
			
		return 1+alturaRamaConMasPeso(nodo.der);
	}

	private NodoInt quitar(NodoInt nodo, int elem) {

		if (nodo == null)
			return null;
		if (nodo.elem == elem) { // encontre el elemento a quitar
			// TODO refactorizar esto para que quede mas corto
			if (esFacilDeBorrar(nodo))
				return seBorra(nodo);

			int reemplazo = buscarReemplazoPorIzquierda(nodo.izq);
			nodo.elem = reemplazo;
			nodo.izq = quitar(nodo.izq, reemplazo);

		} else {
			nodo.izq = quitar(nodo.izq, elem);
			nodo.der = quitar(nodo.der, elem);
		}
		return nodo;
	}
	
	private boolean esFacilDeBorrar(NodoInt nodo) {
		return esHoja(nodo) || tieneUnHijo(nodo);

	}

	private boolean tieneUnHijo(NodoInt nodo) {
		return (nodo.der == null && nodo.izq != null) || (nodo.der != null && nodo.izq == null);

	}

	
	private NodoInt seBorra(NodoInt nodo) {
		if (esHoja(nodo))
			return null;

		if (nodo.der == null) {
			return nodo.izq;
		}
		if (nodo.izq == null) {
			return nodo.der;
		}
		return null;
	}
	
	private boolean esHoja(NodoInt nodo) {

		return nodo.izq == null && nodo.der == null;
	}
	protected int altura(NodoInt nodo) {
		if (nodo == null)
			return 0; 
		return 1 + max(altura(nodo.izq), altura(nodo.der));
	}
	
	private int max(int a, int b) {
		return a>b?a:b;
	}

}
