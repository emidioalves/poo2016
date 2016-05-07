package avaliacao1;

//import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		Loja loja = new Loja();
		

		Carro carro1 = new Carro();
		carro1.setNome("Corsa");
		carro1.setValor(15000.00);
		loja.adicionarCarro(carro1);

		Carro carro2 = new Carro();
		carro2.setNome("Palio");
		carro2.setValor(20000.00);
		loja.adicionarCarro(carro2);

		Carro carro3 = new Carro();
		carro3.setNome("Uno");
		carro3.setValor(10000.00);
		loja.adicionarCarro(carro3);
		
		loja.imprimeCarros();
		
		loja.carroMaisCaro();

		loja.removerCarro(carro2);
		
		loja.imprimeCarros();
		
		loja.carroMaisCaro();

	}

}
