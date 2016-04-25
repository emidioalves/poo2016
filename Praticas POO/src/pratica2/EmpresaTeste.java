package pratica2;

public class EmpresaTeste {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		
		Funcionario empregado = new Funcionario ("Joao", 1000);
		empresa.adicionarFuncionario(empregado);
		Funcionario empregado2 = new Funcionario ("Carlos", 1500);
		empresa.adicionarFuncionario(empregado2);
		
		empresa.imprimeFuncionarios();
		System.out.println("Numero de funcionarios da empresa: " + empresa.numFuncionario());
		
	}

}
