package pratica6;

public class Teste {

	public static void main(String[] args) {

Empresa e1=new Empresa("ComputerMania");
		
		e1.adcGerente("Jose",1100);
		e1.adcDesenvolvedor("Pedro", -3000);
		e1.adcDesenvolvedor("Maria", -3000);
		
		e1.listaEmpregados();
	}

}
