package classes;

import java.util.*;

public class Pizzaria {
	private String nomePizzaria;
	private ArrayList <Produto> produtos;
	private ArrayList<Mesa> mesas;
	
	//metodo construtor da pizzaria
	public Pizzaria(String nomePizzaria){
		produtos = new ArrayList<Produto>();
		mesas = new ArrayList<Mesa>();
		this.nomePizzaria = nomePizzaria;
	}
	
	//metodo de cadastro de produtos na pizzaria - as intancias do produto devem estar previamente setadas
	public void cadastrarPizzaDoce(String nome, double preco, String tamanho){
		produtos.add(new PizzaDoce(nome, preco, tamanho));
	}
	
	//metodo de cadastro de pizza salgada - as intancias do produto devem estar previamente setadas
	public void cadastrarPizzaSalgada(String nome, double preco, String tamanho){
		produtos.add(new PizzaSalgada(nome, preco, tamanho));
	}
	
	//metodo de cadastro de bebida - as intancias do produto devem estar previamente setadas
	public void cadastrarBebida(String nome, double preco, String tamanho){
		produtos.add(new Bebida(nome, preco, tamanho));
	}
	
	//metodo para listar todos os produtos
	public void listarProdutos(){
		boolean state1 = false;
		for(int i=0;i<produtos.size();i++){
		
	    	System.out.println("Nome: "+produtos.get(i).getNome()+" / Tamanho: "+produtos.get(i).getTamanho() 
	    		+"/ Preço: "+ produtos.get(i).getPreco());
	    	state1 = true;
	    	
			if(!state1){
				System.out.println("A pizzaria ainda não cadastrou pizzas doces");
			}
		}
	}
	
	//metodo para listar todas as pizzas doces
	public void listarPizzasDoces(){
		boolean state1 = false;
		for(int i=0;i<produtos.size();i++){
		
			if(produtos.get(i) instanceof PizzaDoce){
	    	System.out.println("Nome: "+produtos.get(i).getNome()+" / Tamanho: "+produtos.get(i).getTamanho() 
	    		+"/ Preço: "+ produtos.get(i).getPreco());
	    	state1 = true;
	    	}
		}
		if(!state1){
			System.out.println("A pizzaria ainda não cadastrou pizzas doces");
		}
	}
	
	//metodo para adicionar pizzas salgadas
	public void listarPizzasSalgadas(){
		boolean state1 = false;
		for(int i=0;i<produtos.size();i++){
		
			if(produtos.get(i) instanceof PizzaSalgada){
	    	System.out.println("Nome: "+produtos.get(i).getNome()+" / Tamanho: "+produtos.get(i).getTamanho() 
	    		+"/ Preço: "+ produtos.get(i).getPreco());
	    	state1 = true;
	    	}
		}
		if(!state1){
			System.out.println("A pizzaria ainda não cadastrou pizzas salgadas");
		}
	}
	
	//metodo para adicionar bebidas
	public void listarBebidas(){
		boolean state1 = false;
		for(int i=0;i<produtos.size();i++){
		
			if(produtos.get(i) instanceof Bebida){
	    	System.out.println("Nome: "+produtos.get(i).getNome()+" / Tamanho: "+produtos.get(i).getTamanho() 
	    		+"/ Preço: "+ produtos.get(i).getPreco());
	    	state1 = true;
	    	}
		}
		if(!state1){
			System.out.println("A pizzaria ainda não cadastrou bebidas");
		}
		
	}
	
	//metodo para remover produto da lista de produtos
	public void removerProduto(Produto prod){
		produtos.remove(prod);
	}
	
	/*
	 * 
	 * Metodo para realizar o atendimento das mesas
	 * 
	 */
	
	//metodo para listar as mesas
	public void listarMesas(){
		boolean state1 = false;
		System.out.println(" Mesa(s) ocupada(s): ");

		for(int i=0;i<mesas.size();i++){
	    	System.out.println(mesas.get(i).getNumMesa());
	    	state1 = true;
		}	
		if(!state1){
			System.out.println("A pizzaria ainda não tem nenhuma mesa ocupada");
		}
	}
	//metodo para adicionar mesa na lista de mesas
	public void adicionarMesa(Mesa mesa){
		mesas.add(mesa);
	}
	
	//metodo para buscar uma mesa na lista - utilizando o numero da mesa
	public Mesa buscarMesa(String numMesa){
		for(Mesa mesa : mesas ){
			if(mesa.getNumMesa().equals(numMesa)){
				System.out.println("Mesa" + numMesa + " encontrada");
			}
			return mesa;
		}
		return null;
	}
	
	//metodo para procurar um produto na lista de produtos
	public Produto buscarProduto(String nome){
		for (Produto prod: produtos){
			if (prod.getNome().equals(nome))
				return(prod);
		}
		return null;
	}
	
	//metodo para adicionar um produto encontrado pelo nome na lista de pedidos da mesa
	public void realizarPedido(String nome, String numMesa){
		Produto prod = buscarProduto(nome);
		Mesa mesaPedido = buscarMesa(numMesa);
		mesaPedido.adicionarProdutoPedido(prod);
	}
	
	//metodo para remover um produto adicionado em um pedido de mesa
	public void removerProdutoPedido(String nome, String numMesa){
		Produto prod = buscarProduto(nome);
		Mesa mesaPedido = buscarMesa (numMesa);
		mesaPedido.removerProdutoPedido(prod);
	}
	
	//metodo para listar os produtos
	public void listarPedido(String numMesa){
		Mesa mesaPedido = buscarMesa(numMesa);
		mesaPedido.listarProdutosPedido();
	}
	
	//metodo que mostra os pedidos da mesa
	public void pedidosMesa(String numMesa){
		
	}
	
	
	
	
}
