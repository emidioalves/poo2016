package pratica5;

public abstract class Empregado {
	protected String nome;
	protected double salario;
	protected static final double valorAumentoTec = 0.15;
	protected static final double valorAumentoGer = 0.25;
	
	//metodo construtor para o funcionario
	public Empregado( String nome, double salario){
		this.nome = nome;
		this.salario = salario;
	}
	
	//criacão de setters e getters para os parametros da classe
	public String getNome() {
		return nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	//metodo abstrato para aumentar salario
	public abstract double aumentarSalario();

}
