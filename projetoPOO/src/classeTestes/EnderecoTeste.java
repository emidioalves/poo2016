package classeTestes;

public class EnderecoTeste {

	private String ruaAvenidaCliente;
	private String numEndCliente;
	private String complementoEndCliente;
	private String bairroCliente;
	private String cepCliente;
	
	public EnderecoTeste(String ruaAvenida, String num, String comple, String bairro, String cep) {
		if(ruaAvenida == null || bairro == null || cep == null){
			throw new IllegalArgumentException("Endereco invalido, tente novamente!");
		}else{
			this.ruaAvenidaCliente = ruaAvenida;
			this.numEndCliente = num;
			this.complementoEndCliente = comple;
			this.bairroCliente = bairro;
			this.cepCliente = cep;
		}
				
	}
	
	public String getRuaAvenidaCliente() {
		return ruaAvenidaCliente;
	}
	
	public String getNumEndCliente() {
		return numEndCliente;
	}
	
	public String getComplementoEndCliente() {
		return complementoEndCliente;
	}
	
	public String getBairroCliente() {
		return bairroCliente;
	}
	
	public String getCepCliente() {
		return cepCliente;
	}
		
	@Override
	public String toString() {
		return "Rua/Avenida: " + this.ruaAvenidaCliente + " - Num: " + this.numEndCliente + "\nComp: " + this.complementoEndCliente + "\nBairro: " + this.bairroCliente + " - Cep: " + this.cepCliente;
	}
	
}
