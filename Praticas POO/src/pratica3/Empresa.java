package pratica3;

import java.util.*;

public class Empresa {
	private ArrayList <Funcionario> funcionarios;
	//private int quantidade;
	
	//metodo construror da empresa
	public Empresa() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	//funcao para adicionar funcionario na empresa - as instancias do funcionario devem ser previamente setadas
	public void adicionarFuncionario(Funcionario funcionario){
		funcionarios.add(funcionario);
	}
	
	//funcao para buscar funcionario pelo nome
	public Funcionario buscarFuncionario(String nome){
		for (Funcionario func : funcionarios){
			if (func.getNome().equals(nome))
				return (func);
		}
		return null;
	}
	
	//função para imprimir todos os funcionarios da lista
	public void imprimeFuncionarios (){
		for (int i = 0; i <funcionarios.size(); i++){
			System.out.println( funcionarios.get(i));
		}
	}
	//função para retirar funcionario do array a partir do nome
	public void removerFuncionario(String nome){
		funcionarios.remove(nome);
		
	}
	
	//funcao que retorna o numero de funcionarios - utiliza função size
	public int numFuncionario(){
		return funcionarios.size()	;
	}

}
