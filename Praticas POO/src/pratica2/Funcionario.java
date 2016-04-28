package pratica2;

public class Funcionario {
	
	 String nome;
	private double salario;
	private String dataEntrada;
	//private String departamento;
	private String rg; 
	
	/*public Funcionario( String nome, double salario){
		this.nome = nome;
		this.salario = salario;
	}*/	
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
	
}
