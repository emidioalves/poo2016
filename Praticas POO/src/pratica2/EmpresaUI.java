package pratica2;

import java.util.Scanner;

public class EmpresaUI {
	
	private Empresa empresa;
	private Scanner input;
	
	//criação do método construtor da interface de usuario
	
	public EmpresaUI() {
		
		empresa = new Empresa();
	
	}
	
	//criando interface
	
	public void run (){
	
		input = new Scanner(System.in);
		
		int option =0;
		
		do {
			
			printMenu();
			option = Integer.parseInt(input.nextLine());
			
			switch (option){
				case 1:
					adicionarFuncionario(); break;
				case 2:
					buscarFuncionario(); break;
				case 3:
					removerFuncionario(); break;
			}
		}while (option !=0);
		}
	//criando acao de adicionar funcionario
	
	private void adicionarFuncionario(){
		System.out.print("Digite o nome:  ");
		String nome  = input.nextLine();
		System.out.print("Digite o salario:  ");
		double salario  = Double.parseDouble(input.nextLine());
		Funcionario empregado = new Funcionario();
		empregado.setNome(nome);
		empregado.setSalario(salario);
		empresa.adicionarFuncionario(empregado);
	}
	
	//criando metodo para buscar Funcionario
	private void buscarFuncionario(){
		System.out.print("Digite o nome:  ");
		String nome  = input.nextLine();
		Funcionario empregado = empresa.buscarFuncionario(nome);
		if (empregado!= null){
			System.out.println("Funcionario encontrado. Nome:  " + empregado.getNome() + "\nsalario: " + empregado.getSalario());
		}
		else
			System.out.print("Contato não encontrado");
	}
	
	//metodo para remover funcionario
	/*
	 * A ser implementado
	 */
	 private void removerFuncionario(){
		 System.out.print("A ser implementado!!!!"); 
	 }
	 
	 private void printMenu(){
		 System.out.println("\n\n Menu Empresa: ver. 1.0 ");
		 System.out.println("\n Numero de Funcionarios na empresa:  " + empresa.numFuncionario() + " funcionários" );
		 System.out.println("\t 0 - sair do sistema  ");
		 System.out.println("\t 1 - Adicionar Funcionario  ");
		 System.out.println("\t 2 - Buscar Funcionario  ");
		 System.out.println("\t 3 - Remover Funcionario  ");
		 System.out.println("Digite uma opção:  ");



			
	 }
		
}
