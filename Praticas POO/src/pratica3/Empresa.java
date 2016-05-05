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
			Funcionario func = funcionarios.get(i);
			System.out.println("Funcionarios na lista: \nNome: " + func.getNome() + "\n\tsalario: " + func.getSalario());
		}
	}
	/*public void imprimeFuncionarios (){
		for (Funcionario func : funcionarios){
			System.out.println("Funcionarios na lista: \nNome: " + func.getNome() + "\n\tsalario: " + func.getSalario());
		}
	}*/
	
	//função para retirar funcionario do array a partir do nome
	public void removerFuncionario(Funcionario func){
		funcionarios.remove(func);
		
	}
	
	//funcao que retorna o numero de funcionarios - utiliza função size
	public int numFuncionario(){
		return funcionarios.size()	;
	}

}
