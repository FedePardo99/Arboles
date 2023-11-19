package arboles;

import java.util.ArrayList;

import arboles.ABInt.NodoInt;

public class ABBInt extends ABInt {
	   

	@Override
	public void agregar(int elem) {
		super.raiz = agregar(super.raiz, elem);
	}
	
	@Override
	public boolean pertenece(int elem) {
		return pertenece(super.raiz, elem);
	}

	public int sumarMaximoYminimo() {
		return sumarMaximoYminimo(super.raiz);
	}
	
	private int sumarMaximoYminimo(NodoInt nodo) {
		if(nodo == null)
			return 0;
			
		return maximo(nodo.der)+minimo(nodo.izq);
	}
	
	public boolean esDegenerativo() {
		return esDegenerativo(super.raiz);
	}
	
	private boolean esDegenerativo(NodoInt nodo) {
		if(nodo == null)
			return true;
		
		if(cantNodos(nodo.der) == 0 && cantNodos(nodo.izq) > 0 )
			return true;
		
		if(cantNodos(nodo.izq) == 0 && cantNodos(nodo.der) > 0 )
			return true;
		
		return false;
	}

	private int minimo(NodoInt raiz) {
		if (raiz.izq == null) return raiz.elem;
		return minimo(raiz.izq);
	}
	private int maximo(NodoInt raiz) {
		if (raiz.der == null) return raiz.elem;
		return maximo(raiz.der);
	}
	
	public int buscarMaximo() {
		return maximo(super.raiz);
	}
	@Override
	public void quitar(int elem) {
		raiz = quitar(super.raiz, elem);
	}
	
	
	public int altura() {
		return  super.altura();
	}

	@Override
	public boolean esABB() {
		return super.esABB();
	}
	
	public int buscarMinimo() {
		return minimo(super.raiz);
	}
	public boolean estaBalanceado() {
		return super.estaBalanceado();
	}
	
	
	public boolean estaCompleto() {
		return estaCompleto(super.raiz);
	}
	
	@Override
	public String toStringPreOrder() {
		return super.toStringPreOrder();
	}
	@Override
	public String toStringPostOrden() {
		return super.toStringPostOrden();
	}
	
	public String toStringIneOrder() {
		return super.toStringIneOrder();
	}
	
	public int hojaEstaEntreElRango(int desde,int hasta) {
		return estaEntreElRango(super.raiz,desde,hasta);
	}
	
	public ArrayList<Integer>ramaDondeSeInserta(int n){
		
		return ramaDondeSeInserta(super.raiz, new ArrayList<>() ,n);
	}

	public String numNodosDelNivel(int nivel) {
		return numNodosDelNivel(super.raiz,nivel);
	}
	
	public boolean esEquiponderado() {
		return esEquiponderado(super.raiz);
	}
	
	

	public String hojasSTR() {
		return hojasSTR(super.raiz);
	}

	
	public String hojasMayores(int elem) {
		if(super.raiz == null)
			return null;
		return hojasMayores(super.raiz,elem);
	}
	
	public int sumarNodos() {
		return sumarNodos(super.raiz);
	}
	
	public int alturaRamaConMasPeso() {
		return alturaRamaConMasPeso(super.raiz);
	}
	
	public int ramaConMayorPeso() {
		return ramaConMayorPeso(super.raiz);
	}
	
	public ArrayList<Integer> listaElementosRamaMasPeso(){
		return listaElementosRamaMasPeso(super.raiz,new ArrayList<>());
	}
	
	public int profundidadDelArbol() {
		return profundidadDelArbol(super.raiz);
	}
	

	private int profundidadDelArbol(NodoInt nodo) {
		return altura(nodo)-1;
		
	}
	
	private ArrayList<Integer> listaElementosRamaMasPeso(NodoInt nodo, ArrayList<Integer> array) {
		if(nodo == null)
			return array;
		
		if(sumarNodos(nodo.izq) > sumarNodos(nodo.der)) {
			array.add(nodo.elem);
			return listaElementosRamaMasPeso(nodo.izq,array);
		}	
		array.add(nodo.elem);
		return listaElementosRamaMasPeso(nodo.der,array);
		
	}

	private NodoInt agregar(NodoInt nodo, int elem) {
		if (nodo == null)
			return new NodoInt(elem);

		if (nodo.elem > elem)
			nodo.izq = agregar(nodo.izq, elem);
		else if (nodo.elem < elem)
			nodo.der = agregar(nodo.der, elem);

		return nodo;
	}
	
	private int ramaConMayorPeso(NodoInt nodo) {
		if(nodo == null)
			return 0;
		
		if(sumarNodos(nodo.izq) > sumarNodos(nodo.der))
			return nodo.elem+ramaConMayorPeso(nodo.izq);
			
		return nodo.elem+ramaConMayorPeso(nodo.der);
	}
	
	
	private int alturaRamaConMasPeso(NodoInt nodo) {
		if(nodo == null)
			return 0;
		
		if(sumarNodos(nodo.izq) > sumarNodos(nodo.der))
			return 1+alturaRamaConMasPeso(nodo.izq);
			
		return 1+alturaRamaConMasPeso(nodo.der);
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
	
	private String numNodosDelNivel(NodoInt nodo, int nivel) {
		if(nodo == null) {
			return "";
		}
		
		if(nivel-- == 1)
			return nodo.elem + " ";
		
		return numNodosDelNivel(nodo.izq, nivel) + numNodosDelNivel(nodo.der, nivel);
		
	}
	private String hojasMayores(NodoInt nodo, int elem) {
		if(nodo == null)
			return "";
		
		if(nodo.elem < elem)
			return hojasMayores(nodo.der, elem);
		
		if(esHoja(nodo) && hojaEsMayor(nodo.elem,elem))
			return nodo.elem + " " ;
		
		return hojasMayores(nodo.izq, elem)+hojasMayores(nodo.der, elem);
	}
	
	
	private boolean hojaEsMayor(int hoja,int elem) {
		return hoja>elem;
	}
	
	private String hojasSTR(NodoInt nodo) {
		if(nodo == null) {
			return "";
		}
		
		if(esHoja(nodo)) {
			return nodo.elem + " ";
		}
		return hojasSTR(nodo.izq) + hojasSTR(nodo.der);
	}

	private boolean estaCompleto(NodoInt nodo) {
		
		if(nodo == null) 	
			return true;
		
		
		if((nodo.der == null && nodo.izq != null) ||(nodo.der != null && nodo.izq == null))	
			return false;
			
		
		return estaCompleto(nodo.der) && estaCompleto(nodo.izq);
	}
	
	
	private ArrayList<Integer> ramaDondeSeInserta(NodoInt nodo, ArrayList<Integer> array,int elem) {
		
		if(nodo == null)
			return array;
		
		
		if(elem > nodo.elem) {
			array.add(nodo.elem);
			return ramaDondeSeInserta(nodo.der, array, elem);
			
		}else if(elem<nodo.elem) {
			array.add(nodo.elem);
			return ramaDondeSeInserta(nodo.izq, array, elem);
		}
		
		
		return array;
	}
	
	private int estaEntreElRango(NodoInt nodo, int desde, int hasta) {
		
	    if (nodo == null)
	        return 0;
	    
	    if (esHoja(nodo)) {
	        return estaEnElRango(nodo.elem, desde, hasta);
	            
	    }
	    if(nodo.elem <desde)
	    	return estaEntreElRango(nodo.der,desde,hasta);
	    
	    if (nodo.elem >hasta)
	    	return estaEntreElRango(nodo.izq,desde,hasta);
	    
	    return estaEntreElRango(nodo.izq, desde, hasta) + estaEntreElRango(nodo.der, desde, hasta);
	}

	private int estaEnElRango(int elem, int desde, int hasta) {
	    return (elem > desde && elem < hasta)?1:0;
	}

	private NodoInt quitar(NodoInt nodo, int elem) {

		if (nodo == null)
			return null;
		if (nodo.elem == elem) { 
			if (esFacilDeBorrar(nodo))
				return seBorra(nodo);

			int reemplazo = buscarReemplazoPorIzquierda(nodo.izq);
			nodo.elem = reemplazo;
			nodo.izq = quitar(nodo.izq, reemplazo);

		} else if(elem>nodo.elem){
			nodo.der = quitar(nodo.der, elem);
		}else {
			nodo.izq = quitar(nodo.izq, elem);
		}
		return nodo;
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
	private boolean esFacilDeBorrar(NodoInt nodo) {
		return esHoja(nodo) || tieneUnHijo(nodo);

	}
	
	private boolean tieneUnHijo(NodoInt nodo) {
		return (nodo.der == null && nodo.izq != null) || (nodo.der != null && nodo.izq == null);

	}

	private int buscarReemplazoPorIzquierda(NodoInt nodo) {
		if (nodo.izq == null)
			return nodo.elem;
		return buscarReemplazoPorIzquierda(nodo.izq);
	}

	private boolean esHoja(NodoInt nodo) {

		return nodo.izq == null && nodo.der == null;
	}
	
	private boolean pertenece(NodoInt nodo, int elem) {
		if (nodo == null)
			return false;

		if (nodo.elem == elem)
			return true;

		if (nodo.elem > elem)
			return pertenece(nodo.izq, elem);
		
		return pertenece(nodo.der, elem);
	}
	
}
