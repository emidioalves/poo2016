package pratica5;

public class Tecnico extends Empregado {

	public Tecnico(String nome, double salario) {
		super(nome, salario);
	}
	
	@Override
	public double aumentarSalario(){
		return this.salario +=this.salario*Empregado.valorAumentoTec;
	}

}
