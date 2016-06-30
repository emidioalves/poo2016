package avaliacao2;

public class LojaTeste {

	public static void main(String[] args) {
		Loja loja = new Loja ("Americanas");
		
		loja.addCD("Calipso", 20);
		loja.addCD("Iron Maiden", 30);
		
		loja.addLivro("Java Para iniciantes", -140);
		loja.addLivro("A biblia do Java", 250.99);
		
		loja.listaDeProdutos();
		loja.buscar("Calipso");
	}

}
