package pratica6;

public class Tecnico extends Empregado{
	public Tecnico (String nome,double salario){
		super(nome,salario);
	}

	@Override
	public double aumentaSalario() {
		return this.salario+=(this.salario*Empregado.aumentoTecnico);
		
	}

}
