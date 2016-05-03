package pratica2;

import java.util.Scanner;

public class FuncionarioTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite o nome do empregado");
		String empnome = sc.nextLine();
		System.out.println("Digite o salario do empregado");
		double val_salario = sc.nextDouble();
		Funcionario empregado = new Funcionario();
		empregado.setNome(empnome);
		empregado.setSalario(val_salario);
		
		System.out.println("Nome do empregado: " + empregado.getNome() + ". Salario: " + empregado.getSalario() );
		//empregado.setNome("Joao");
		//System.out.println("Nome do empregado: " + empregado.getNome() + " Salario: " + empregado.getSalario() );

	}

}
