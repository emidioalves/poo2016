package classes;

import java.util.*;
public class Mesa {
	
	private int numMesa;
	private ArrayList<Produto> pedido;

	public Mesa(int numMesa){
		pedido = new ArrayList<Produto>();
		this.numMesa = numMesa;
	}
	
	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}
	
	//metodo para adicionar produto na lista da mesa
	public void addProdutoPedido(String nome, double preco, String tamanho){
		pedido.add(new Produto(nome, preco, tamanho));
	}
}
