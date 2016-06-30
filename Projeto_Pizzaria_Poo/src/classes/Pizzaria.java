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
	public void cadastrarPizzaDoce(String nome, double preco, String sabor, String tamanho){
		produtos.add(new PizzaDoce(nome, preco, tamanho));
	}
	
	//metodo de cadastro de pizza salgada - as intancias do produto devem estar previamente setadas
	public void cadastrarPizzaSalgada(String nome, double preco, String sabor, String tamanho){
		produtos.add(new PizzaSalgada(nome, preco, tamanho));
	}
	
	//metodo de cadastro de bebida - as intancias do produto devem estar previamente setadas
	public void cadastrarBebida(String nome, double preco, String tamanho){
		produtos.add(new Bebida(nome, preco, tamanho));
	}
	
	
	//metodo que lista todos as pizzas doces
	public void listarPizzasDoces(){
		boolean state1 = false;
		for(int i=0;i<produtos.size();i++){
		
			if(produtos.get(i) instanceof PizzaDoce){
	    	System.out.println("Nome: "+produtos.get(i).getNome()+" / Tamanho: "+produtos.get(i).getTamanho() 
	    		+"/ Preço: "+ produtos.get(i).getPreco());
	    	state1 = true;
	    	}
			if(!state1){
				System.out.println("A pizzaria ainda não cadastrou pizzas doces");
			}
		}
	}
	
	//funcao para adicionar pizzas salgadas
	public void listarPizzasSalgadas(){
		boolean state1 = false;
		for(int i=0;i<produtos.size();i++){
		
			if(produtos.get(i) instanceof PizzaSalgada){
	    	System.out.println("Nome: "+produtos.get(i).getNome()+" / Tamanho: "+produtos.get(i).getTamanho() 
	    		+"/ Preço: "+ produtos.get(i).getPreco());
	    	state1 = true;
	    	}
			if(!state1){
				System.out.println("A pizzaria ainda não cadastrou pizzas salgadas");
			}
		}
	}
	
	//funcao para adicionar bebidas
	public void listarBebidas(){
		boolean state1 = false;
		for(int i=0;i<produtos.size();i++){
		
			if(produtos.get(i) instanceof Bebida){
	    	System.out.println("Nome: "+produtos.get(i).getNome()+" / Tamanho: "+produtos.get(i).getTamanho() 
	    		+"/ Preço: "+ produtos.get(i).getPreco());
	    	state1 = true;
	    	}
			if(!state1){
				System.out.println("A pizzaria ainda não cadastrou bebidas");
			}
		}
	}
	
	//função para remover produto da lista de produtos
	public void removerProduto(Produto prod){
		produtos.remove(prod);
	}
	
	/*
	 * 
	 * Funções para realizar o atendimento das mesas
	 * 
	 */
	
	//fucao para adicionar mesa na lista de mesas
	public void adicionarMesa(Mesa mesa){
		mesas.add(mesa);
	}
	
	//funcao para buscar uma mesa na lista - utilizando o numero da mesa
	public Mesa buscarMesa(int numMesa){
		for(Mesa mesa : mesas ){
			if(mesa.getNumMesa() ==numMesa)
				return(mesa);
		}
		return null;
	}
	
	//funcao para receber procurar um produto na lista de produtos
	public Produto buscarProduto(String nome){
		for (Produto prod: produtos){
			if (prod.getNome().equals(nome))
				return(prod);
		}
		return null;
	}
	
	//função para adicionar um produto encontrado pelo nome na lista de pedidos da mesa
	public void realizarPedido(String nome, int numMesa){
		
	}
}
