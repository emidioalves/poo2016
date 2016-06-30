package classeTestes;

import classeTestes.exception.LimiteSaqueException;
import classeTestes.exception.SaldoInsuficienteException;

public abstract class ContaGenTeste {

		private int numConta;
		private ClienteTeste cliente;
		protected double saldo;
		private double limiteSaque;
		
		public ContaGenTeste(int numConta, ClienteTeste cliente) {
			this.numConta = numConta;
			this.cliente = cliente;
			this.saldo = 0;
			this.limiteSaque = 500;
		}
		
		/**
		 * Metodo que deposita dinheiro na conta
		 * @param valor Valor desejado para deposito
		 */
		public void deposita(double valor) {
			if(valor >= 0){
				this.saldo += valor;
			} else{
				throw new IllegalArgumentException("Valor depositado invalido, tente novamente!");
			}				
		}
		
		/**
		 * Metodo que consulta a conta pertencente a agencia
		 * @param valor Valor desejado para saque
		 * @throws SaldoInsuficienteException Excecao levantada caso a conta nao tenha saldo suficiente para saque
		 * @throws LimiteSaqueException Excecao levantada caso o valor desejado supere o limite
		 */
		public void saca(double valor) throws SaldoInsuficienteException, LimiteSaqueException{
			if(this.saldo < valor){
				throw new SaldoInsuficienteException("Saldo insuficiente");
			}else if(this.limiteSaque < valor){
				throw new LimiteSaqueException("Limite de saque");
			}else saldo -= valor;
		}
		
		/**
		 * Metodo que consulta a conta pertencente a agencia
		 * @param conta Conta para transferir o valor desejado
		 * @param valor Valor que sera transferido
		 * @throws SaldoInsuficienteException Excecao levantada caso a conta ao tenha saldo suficiente para realizar a transferencia
		 */
		public void transfere(ContaGenTeste conta, double valor) throws SaldoInsuficienteException, LimiteSaqueException{
			try {
				this.saca(valor);
				conta.deposita(valor);
			} catch (SaldoInsuficienteException e) {
				throw new SaldoInsuficienteException("Saldo insuficiente!");
			} catch (LimiteSaqueException e) {
				throw new LimiteSaqueException("Valor passou do limite!");
			}
		}
		
		//public abstract void tipoTaxa(double taxa); Falta implementar futuramente
		
		/**
		 * Metodo que consulta o saldo
		 * @return Retorna o saldo da conta
		 */
		public double consultaSaldo(){
			return this.saldo;
		}

		public int getNumConta() {
			return this.numConta;
		}

		public ClienteTeste getCliente() {
			return this.cliente;
		}
		
		@Override
		public String toString() {
			return "\nNome: " + getCliente().getNome() + " " + getCliente().getSobrenome() + "\nCPF: " + getCliente().getCpf() + " - Numero da Conta: " + getNumConta() + "\nEnd: " + getCliente().getEndereco().toString();
		}
		
}