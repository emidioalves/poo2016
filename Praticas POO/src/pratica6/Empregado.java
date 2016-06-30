package pratica6;

abstract class  Empregado {
	protected String nome;
	protected double salario;
	protected static final double aumentoTecnico=0.15;
	protected static final double aumentoGerente=0.25;

	public Empregado(String nome,double salario){
		this.nome=nome;
		
		
		if(salario<0 || salario==0 || salario<100){
			throw new IllegalArgumentException("entre com valor valido");}
				//throw new NegativeExcpetion("o numero nao pode ser negativo);
		        //throw new MinimumValueException("o salario tem que ser no minumo 100);
			else{
			this.salario = salario;
			}
	}
	
	public abstract double aumentaSalario();
	
	public String getNome(){
		return nome;
	}
	public double getSalario(){
		return salario;
	}

}
