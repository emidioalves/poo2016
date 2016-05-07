package avaliacao1;

import java.util.*;

public class Loja {
	
	private ArrayList <Carro> lista_carros;
	
	//metodo construtor da classe loja
	public Loja() {

		lista_carros = new ArrayList<Carro>();
	}
	
	//metodo para adicionar carro na lista
	public void adicionarCarro(Carro carro){
		lista_carros.add(carro);
	}
	
	//metodo para remover carro da lista
	public void removerCarro(Carro carro){
		lista_carros.remove(carro);
		System.out.println("Carro removido com sucesso!\n");
	}
	
	//buscar carro pelo nome
	public Carro buscarCarro(String nome){
		for (Carro carro : lista_carros){
			if (carro.getNome().equals(nome))
				return (carro);
		}
		return null;
	}
	
	//public void remover
	
	//metodo para imprimir carros
	public void imprimeCarros (){
		for (Carro carro : lista_carros){
			System.out.println("Lista de carros da loja: \nNome do carro: " + carro.getNome() + "\nValor do veículo: " + carro.getValor()+"\n");
		}
	}
	
	//metodo para retornar o carro de maior valor
	public void carroMaisCaro(){
		Carro temp_carro = new Carro();
		temp_carro.setValor(0);
		for(Carro carro: lista_carros){
			if (temp_carro.getValor() < carro.getValor()){
				temp_carro = carro;
			}
		}
		System.out.println("--Carro mais caro da loja: " + temp_carro.getNome() + "--");
	}
	
	
}
