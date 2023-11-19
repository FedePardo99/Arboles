package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import arbolesProgra2.ABInt;
import org.junit.Before;
import org.junit.Test;

import arbolesProgra2.ABBInt;

public class testABBInt {
	public static ABBInt arbol,arbolDePrueba;
	
	@Before
	public void inicializarArboles () {
		arbol = new ABBInt();
		arbolDePrueba = new ABBInt();
		
		arbol.agregar(4);
		arbol.agregar(1);
		arbol.agregar(12);
		arbol.agregar(2);
		arbol.agregar(9);
		arbolDePrueba.agregar(1);
		arbolDePrueba.agregar(2);
		arbolDePrueba.agregar(3);
		arbolDePrueba.agregar(4);
		arbolDePrueba.agregar(5);
		arbolDePrueba.agregar(6);
	}
	
	

	@Test
	public void maximo() {
		assertEquals(12,arbol.maximo());
	}
	
	@Test
	public void minimo() {
		assertEquals(1,arbol.minimo());
	}
	
	@Test
	public void cantNodos() {
		assertEquals(5,arbol.cantNodos());
	}
	
	@Test
	public void altura() {
		assertEquals(3,arbol.altura());
	}
	
	@Test
	public void quitar() {
		arbol.quitar(2);
		assertEquals(4,arbol.cantNodos());
	}
	
	@Test
	public void esABB() {
		assertTrue(arbol.esABB());
	}
	
	@Test
	public void noEsABB() {
		ABInt arbolNoBinario = new ABInt();
		
		arbolNoBinario.agregar(0);
		arbolNoBinario.agregar(1);
		arbolNoBinario.agregar(2);
		arbolNoBinario.agregar(-1);
		arbolNoBinario.agregar(3);
		arbolNoBinario.agregar(2);
		
		assertFalse(arbolNoBinario.esABB());
	}
	
	@Test
	public void esDegenerativo() {
		assertTrue(arbolDePrueba.esDegenerativo());
	}
	
	@Test
	public void noEsDegenerativo() {
		assertFalse(arbol.esDegenerativo());
	}
	
	@Test
	public void estaBalanceado() {
		assertTrue(arbol.estaBalanceado());
	}
	
	@Test
	public void noEstaBalanceado() {
		assertFalse(arbolDePrueba.estaBalanceado());
	}
	
	@Test
	public void sumarNodos(){
		assertEquals(28, arbol.sumarNodos());
	}
	
	@Test
	public void hojaEstaEntreElRango() {
		assertEquals(2,arbol.hojaEstaEntreElRango(1, 10));
	}
	
}
