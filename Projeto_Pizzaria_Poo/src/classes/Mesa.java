package classes;

import java.util.*;
public class Mesa {
	
	private String numMesa;
	private ArrayList<Produto> pedido;

	public Mesa(String numMesa){
		pedido = new ArrayList<Produto>();
		this.numMesa = numMesa;
	}
	
	public String getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(String numMesa) {
		this.numMesa = numMesa;
	}
	
	//metodo que adiciona produtos ao pedido
	public void adicionarProdutoPedido(Produto prod){
		pedido.add(prod);
	}
	
	public void removerProdutoPedido(Produto prod){
		pedido.remove(prod);
	}
	
	//metodo que lista os produtos na lista da mesa
	public void listarProdutosPedido(){
		boolean state1 = false;
		double total = 0;
		for(int i=0;i<pedido.size();i++){
			
		    System.out.println("Nome: "+pedido.get(i).getNome()+" / Tamanho: "+pedido.get(i).getTamanho() 
		    	+"/ Preço: "+ pedido.get(i).getPreco());
		    total += pedido.get(i).getPreco();
		    state1 = true;
		}
		System.out.println("TOTAL:" + total + "reais");

		if(!state1){
			System.out.println("A mesa ainda não realizou um pedido");
			}
		}	
}
