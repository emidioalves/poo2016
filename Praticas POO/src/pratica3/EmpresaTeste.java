package pratica3;

import java.util.*;

public class EmpresaTeste {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		
		ArrayList<Funcionario> lista_empregado = new ArrayList<Funcionario>();
		
		
		
		Funcionario empregado1 = new Funcionario();
		Funcionario empregado2 = new Funcionario();
		Funcionario empregado3 = new Funcionario();
		Funcionario empregado4 = new Funcionario();
		Funcionario empregado5 = new Funcionario();

		
		empregado1.setNome("Joao");
		empregado1.setSalario(1000);
		//empregado1.setRg("12345");
		
		lista_empregado.add(empregado1);
		
		empregado2.setNome("Jose");
		empregado2.setSalario(1000);
		//empregado2.setRg("12305");
		lista_empregado.add(empregado2);

		
		empregado3.setNome("Chico");
		empregado3.setSalario(1000);
		//empregado3.setRg("12315");
		lista_empregado.add(empregado3);

		empregado4.setNome("Sole");
		empregado4.setSalario(1000);
		//empregado4.setRg("12325");
		lista_empregado.add(empregado4);

		empregado5.setNome("John");
		empregado5.setSalario(1000);
		//empregado5.setRg("12335");
		lista_empregado.add(empregado5);

		int num_emp = lista_empregado.size();
		System.out.println("Numero de empregados: " +num_emp);
		
		Iterator ite = lista_empregado.iterator();
		while (ite.hasNext()){
			Funcionario func = (Funcionario)ite.next();
			System.out.println("Nome do funcionario: " +func.getNome() + "\nSalario: " + func.getSalario() + "\nRG Funcionario: "  /*func.getRg()*/);	
		}	
	}

}
