package pratica2;

public class EmpresaTeste {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		
		Funcionario empregado = new Funcionario ();
		empregado.setNome("Joao");
		empregado.setSalario(1000);
		empregado.setRg("12345");
		empresa.adicionarFuncionario(empregado);
		
		
		empresa.imprimeFuncionarios();
		System.out.println("Numero de funcionarios da empresa: " + empresa.numFuncionario());
		
	}

}
