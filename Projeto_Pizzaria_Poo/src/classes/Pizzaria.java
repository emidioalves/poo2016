package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
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
	
	//metodo de adicionar produtos na pizzaria - as intancias do produto devem estar previamente setadas
	public void cadastrarPizzaDoce(String nome, double preco, String tamanho){
		produtos.add(new PizzaDoce(nome, preco, tamanho));
	}
	
	//metodo de adicionar pizza salgada - as intancias do produto devem estar previamente setadas
	public void cadastrarPizzaSalgada(String nome, double preco, String tamanho){
		produtos.add(new PizzaSalgada(nome, preco, tamanho));
	}
	
	//metodo para adicionar bebida - as intancias do produto devem estar previamente setadas
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
	
	//metodo para lsitar pizzas salgadas
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
	
	//metodo para listar as bebidas
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
	//metodo para retornar o arraylist de produtos
	public  ArrayList <Produto> retornarArray(){
		ArrayList<Produto> lista = new ArrayList<Produto>();
		return lista;
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
	    	System.out.println("No: "+ mesas.get(i).getNumMesa());
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
				System.out.println("Mesa " + numMesa + " encontrada");
				return mesa;
			}
		}
		System.out.println("Mesa " + numMesa + " nao ocupada");
		return null;
	}
	
	//metodo para procurar um produto na lista de produtos
	public Produto buscarProduto(String nome){
		for (Produto prod: produtos){
			if (prod.getNome().equals(nome))
				return(prod);
		}
		System.err.println("Produto não encontrado no cadastro!!");
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
	
	//metodo para serializar(salvar) o array de produtos
	public int salvarProdutos(ArrayList produtos){
		try{
			FileOutputStream out = new FileOutputStream("produtos.ser");
			ObjectOutputStream objOut = new ObjectOutputStream(out);
		
			objOut.writeObject(produtos); 	//referencia à estrutura que deve ser salva
			objOut.close();
			System.out.println("Dados salvos com sucesso!");
			return 0;
		}
		catch(Exception exception){
			return -1;
		}
	}
	
	//metodo para ler o arquivo serializado salvo
	public Object carregarDados(){
		Object resultado = null;
		
		try{
			//utilizar o nome do arquivo salvo
			FileInputStream fs = new FileInputStream("produtos.ser");
			ObjectInputStream os = new ObjectInputStream(fs);
			resultado = os.readObject();			
			os.close();
			System.out.println("Dados carregados com sucesso!");
			return resultado;
		}
		catch (Exception exception){
			return null;
		}
	}
	
	
}
