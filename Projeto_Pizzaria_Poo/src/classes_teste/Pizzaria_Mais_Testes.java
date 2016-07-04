package classes_teste;
import java.util.*;
import classes.*;
public class Pizzaria_Mais_Testes {

	public static void main(String[] args) {
		
		Pizzaria nomePizzaria = new Pizzaria("Pizza Hut");
		
		nomePizzaria.cadastrarPizzaSalgada("Calabreza Grande", 29.90, "Grande");
		nomePizzaria.cadastrarPizzaSalgada("Calabreza Média", 18.90, "Média");
		nomePizzaria.cadastrarPizzaDoce("Chocolate", 29.90, "Grande");
		nomePizzaria.cadastrarPizzaSalgada("Calabreza Pequena", 15.90, "Pequena");
		nomePizzaria.cadastrarPizzaSalgada("Frango com Catupiri Grande", 29.90, "Grande");
		nomePizzaria.cadastrarPizzaSalgada("Frango com Catupiri Média", 18.90, "Média");
		nomePizzaria.cadastrarPizzaDoce("Banana com Canela", 27.90, "Grande");
		nomePizzaria.cadastrarPizzaSalgada("Frango com Catupiri Pequena", 15.90, "Pequena");
		nomePizzaria.cadastrarPizzaDoce("Chocolate Branco", 29.90, "Grande");
		nomePizzaria.cadastrarPizzaDoce("Banana", 27.90, "Grande");
		nomePizzaria.cadastrarBebida("Coca Cola 2L", 8.90, "2000 mL");
		nomePizzaria.cadastrarBebida("Fanta Laranja 2L", 8.90, "2000 mL");
		nomePizzaria.cadastrarBebida("Agua Mineral 1L", 4.90, "1000 mL");
		
		nomePizzaria.listarProdutos();
		//nomePizzaria.listarPizzasDoces();
		//nomePizzaria.listarPizzasSalgadas();
		//nomePizzaria.listarBebidas();
		//nomePizzaria.listarMesas();
		/*Mesa mesa1 = new Mesa("6");
		Mesa mesa2 = new Mesa("3");
		Mesa mesa3 = new Mesa("9");
		Mesa mesa4 = new Mesa("1");
		
		nomePizzaria.adicionarMesa(mesa1);
		nomePizzaria.adicionarMesa(mesa2);
		nomePizzaria.adicionarMesa(mesa3);
		nomePizzaria.adicionarMesa(mesa4);
		nomePizzaria.realizarPedido("Coca Cola 2L", "3");
		nomePizzaria.realizarPedido("Agua Mineral 1L", "3");
		nomePizzaria.realizarPedido("Frango com Catupiri Grande", "3");
		
		nomePizzaria.realizarPedido("Fanta Laranja 2L", "9");
		nomePizzaria.realizarPedido("Agua Mineral 1L", "6");
		nomePizzaria.realizarPedido("Chocolate Branco", "1");



		nomePizzaria.listarMesas();
		Mesa mesa; 
		mesa = nomePizzaria.buscarMesa("3");
		mesa.listarProdutosPedido();
		Mesa mesa_teste = nomePizzaria.buscarMesa("9");
		mesa_teste.listarProdutosPedido();
		mesa4.listarProdutosPedido();
		mesa3.listarProdutosPedido();
		mesa2.listarProdutosPedido();
		//Mesa teste2 = nomePizzaria.buscarMesa("1");
		//Mesa teste = nomePizzaria.listarPedido("4");;
		//teste.listarProdutosPedido();
		//teste2.listarProdutosPedido();
		//nomePizzaria.realizarPedido("Coca Cola 2L", 3);
		//nomePizzaria.realizarPedido("Agua Mineral 1L", 3);
		//nomePizzaria.realizarPedido("Coca Cola 2L", 3);*/
		nomePizzaria.salvarProdutos(nomePizzaria.retornarArray());
				

		
	}

}
