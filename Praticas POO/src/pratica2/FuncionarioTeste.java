package pratica2;

import java.util.Scanner;

public class FuncionarioTeste {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Digite o nome do empregado");
		String empnome = input.nextLine();
		System.out.println("Digite o salario do empregado");
		double val_salario = input.nextDouble();
		Funcionario empregado = new Funcionario(empnome, val_salario );
		System.out.println("Nome do empregado: " + empregado.getNome() + " Salario: " + empregado.getSalario() );
		empregado.setNome("Joao");
		System.out.println("Nome do empregado: " + empregado.getNome() + " Salario: " + empregado.getSalario() );

	}

}
