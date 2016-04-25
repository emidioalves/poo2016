package pratica2;

public class Empresa {
	
	private Funcionario []funcionarios;
	private int quantidade;
	
	public Empresa() {
		funcionarios =  new Funcionario[10];
		quantidade = 0;
	}
	
	//funcao para adicionar funcionario na empresa
	public void adicionarFuncionario(Funcionario funcionario){
		funcionarios[quantidade++] = funcionario;
	}
	
	//funcao para buscar funcionario
	public Funcionario buscarFuncionario(String nome){
		for (int i = 0; i < quantidade; i++){
			if (funcionarios[i].getNome().equals(nome))
				return funcionarios[i];
		}
		return null;
	}
	
	//função para imprimir funcionarios
	public void imprimeFuncionarios (){
		for (int i = 0; i <quantidade; i++){
			System.out.println(funcionarios[i].getNome());
		}
	}
	//função para retirar funcionario do array
	public void removerFuncionario(){
		//testar
	}
	
	//funcao que retorna o numero de funcionarios
	public int numFuncionario(){
		return quantidade	;
	}
}
