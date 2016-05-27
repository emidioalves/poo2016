package pratica5;

import java.util.ArrayList;

public class Empresa {
	private String nomeEmpresa;
	private ArrayList <Empregado> empregados;
	
	public Empresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
		empregados = new ArrayList <Empregado>();
	}
	
	public void addGerente(String nome, double salario){
		empregados.add(new Gerente(nome, salario));
	}

}
