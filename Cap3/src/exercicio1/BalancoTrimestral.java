package exercicio1;

public class BalancoTrimestral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gastosJaneiro = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		
		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
		
		int mediaPorMes = gastosTrimestre/3;
		System.out.println ("Gastos do Trimestre: " + gastosTrimestre);
		System.out.println ("Média de gastos mensais: " + mediaPorMes);
		
	}

}
