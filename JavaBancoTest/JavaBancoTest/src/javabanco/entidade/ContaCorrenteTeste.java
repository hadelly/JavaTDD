package javabanco.entidade;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class ContaCorrenteTeste {

	@Test
	public void testCriacaoObjeto(){
		//Prepara
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		//Testa
		assertNotNull (cc);
	}
	
	@Test
	public void testSaldo() {
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		assertEquals(0, cc.saldo(), 0);
	}

	@Test
	public void testCredito() {
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		cc.credito(100);
		assertEquals(100, cc.saldo(), 0);
	}

	@Test
	public void testDebito() {
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		cc.debito(100);
		assertEquals(-100, cc.saldo(), 0);
	}

	@Test
	public void testExtrato() {
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		cc.credito(100);
		cc.debito(100);
		ArrayList<Operacao> listaOperacoes = cc.extrato();
		assertEquals(2, listaOperacoes.size());
		//maneira de pegar uma referencia ao primeiro item da lista
		Operacao op1 = listaOperacoes.get(0);
		assertEquals(100, op1.getValor(), 0);
		assertEquals("CREDITO", op1.getTipoOperacao());
		//maneira de pegar uma referencia ao primeiro item da lista
		assertEquals(100, listaOperacoes.get(1).getValor(), 0);
		assertEquals("DEBITO",  listaOperacoes.get(1).getTipoOperacao());
	}
	
	@Test
	public void testSaldoPequenosFloats() {
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		cc.credito(0.1f);
		cc.credito(0.2f);
		assertEquals(0.3f, cc.saldo(), 0.0f);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreditoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		
		cc.credito(-10);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDebitoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		
		cc.debito(-10);		
	}
	
	public void testGetTitular(){
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		assertEquals ("joao da silva", cc.getTitular());
	}
	
	public void testGetNumero(){
		ContaCorrente cc = new ContaCorrente(12345, "joao da silva");
		assertEquals(12345, cc.getNumero());
	}
	
	public void testTranferencia(){
		//Prepara
		ContaCorrente ccOrigem = new ContaCorrente(12345, "joao da silva");
		ContaCorrente ccDestino = new ContaCorrente (67890, "maria da silva");
		//Transfere
		ccOrigem.tranferencia(100, ccDestino);
		//Testa
		assertEquals (-100, ccOrigem.saldo(), 0);
		assertEquals (100, ccDestino.saldo(), 0);
	}

}