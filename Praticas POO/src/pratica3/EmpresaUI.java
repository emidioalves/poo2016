package pratica3;

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
						adicionar(); break;
					case 2:
						buscar(); break;
					case 3:
						remover(); break;
					case 4:
						imprime(); break;
				}
			}while (option !=0);
			}
		//criando acao de adicionar funcionario
		
		private void adicionar(){
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
		private void buscar(){
			System.out.print("Digite o nome:  ");
			String nome  = input.nextLine();
			Funcionario empregado = empresa.buscarFuncionario(nome);
			if (empregado!= null){
				System.out.println("Funcionario encontrado. Nome:  " + empregado.getNome() + "\n\tsalario: " + empregado.getSalario());
			}
			else
				System.out.print("Contato não encontrado");
		}
		
		//metodo para remover funcionario da lista
		 private void remover(){
			System.out.print("Removendo funcionario... ");
			System.out.print("Digite o nome:  ");
			String nome  = input.nextLine();
			Funcionario empregado = empresa.buscarFuncionario(nome);
			if (empregado != null){
				empresa.removerFuncionario(empregado);
				System.out.print("Funcionario removido com sucesso!!!"); 
			}
			else{
				System.out.println("Funcionario nao encontrado!");
			}
		 }
		 
		 //metodo para imprimir os funcionarios da lista
		 private void imprime(){
			 
			 empresa.imprimeFuncionarios(); 
		 }
		 
		 private void printMenu(){
			 System.out.println("\n\n Menu Empresa: ver. 1.0 ");
			 System.out.println("\n Numero de Funcionarios na empresa:  " + empresa.numFuncionario() + " funcionários" );
			 System.out.println("\t 0 - sair do sistema  ");
			 System.out.println("\t 1 - Adicionar Funcionario  ");
			 System.out.println("\t 2 - Buscar Funcionario  ");
			 System.out.println("\t 3 - Remover Funcionario  ");
			 System.out.println("\t 4 - Imprimir Funcionarios  ");
			 System.out.println("Digite uma opção:  ");

				
		 }

}
