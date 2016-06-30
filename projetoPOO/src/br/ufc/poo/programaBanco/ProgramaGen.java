package br.ufc.poo.programaBanco;
import classeTestes.ClienteTeste;

public interface ProgramaGen {

	void atualizarConta();
	void deletarConta();
	void visualizarContas();
	void acessarConta();
	void consultarSaldo();
	void efetuarDeposito();
	void efetuarSaque();
	void efetuarTransferencia();
	void cadastrarConta();
	void criarConta(int numConta, ClienteTeste cliente);
	
}
