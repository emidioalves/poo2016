package classes_teste;

import classes.*;
public class Mesa_teste {

	public static void main(String[] args) {

		Mesa mesa = new Mesa("1");
		Mesa mesa2 = new Mesa("2");
		
		Produto prod = new Produto("Coca Cola 2L", 8.90, "grande");
		PizzaSalgada calabreza = new PizzaSalgada("Calabreza", 29.90, "grande");
		mesa.adicionarProdutoPedido(prod);
		mesa.adicionarProdutoPedido(calabreza);
		
		mesa.listarProdutosPedido();
		//mesa2.listarProdutosPedido();
		
	}

}
