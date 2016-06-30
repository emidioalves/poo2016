package classeTestes.tiposConta;

import classeTestes.ClienteTeste;
import classeTestes.ContaGenTeste;


public class ContaCorrenteTeste extends ContaGenTeste{

	public ContaCorrenteTeste(int numConta, ClienteTeste cliente) {
		super(numConta, cliente);
	}

	/*@Override //Falta implementar
	public void tipoTaxa(double taxa) {
		this.saldo -= taxa;	
	}*/

}
