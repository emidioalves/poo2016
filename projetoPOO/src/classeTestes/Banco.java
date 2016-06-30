package classeTestes;

import classeTestes.exception.AgenciaNaoEncontradaException;

public class Banco{
	
	private AgenciaTeste[] agencias = new AgenciaTeste[42];
	
	public Banco() {
		this.agencias = AgenciaTeste.preencheDados(AgenciaTeste.lerAqr());
	}
	
	/**
	 * Método que consulta uma agencia pertencente ao banco
	 * @param codigoAgencia Numero da agencia a ser consultada
	 * @return Retorna a entidade agencia referente ao codigo da agencia informada
	 * @throws AgenciaNaoEncontradaException Exceção levantada caso a agencia consultada não seja encontrada neste banco
	 */
	public AgenciaTeste consultarAge(String codigoAgencia) throws AgenciaNaoEncontradaException{
		
		for (AgenciaTeste agenciaTmp : agencias) {
			if(agenciaTmp !=null && agenciaTmp.getInfoAge().getCodigoAgencia().equals(codigoAgencia))
				return agenciaTmp;
		}
		
		throw new AgenciaNaoEncontradaException("Agencia nao encontrada!");
	}

}
