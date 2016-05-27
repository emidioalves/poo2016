package pratica5;

public class Gerente extends Empregado {

	public Gerente(String nome, double salario) {
		super(nome, salario);
	}

	@Override
	public double aumentarSalario() {
		return this.salario += Empregado.valorAumentoGer*this.salario;
		
	}
	
}
