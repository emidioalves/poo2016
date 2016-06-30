package pratica6;

public class Gerente extends Empregado{

	public Gerente(String nome,double salario){
		super(nome,salario);
	}

	@Override
	public double aumentaSalario() {
		return this.salario+=(this.salario*Empregado.aumentoGerente);
		
	}
	

}
