package classeTestes;

public class InfoAgencias {

	private String infoAgencia;
	private String nomeAgencia;
	private String ruaEndAgencia;
	private int numeroEndAgencia;
	private String complementoEndAgencia;
	private String bairroEndAgencia;
	private String cepAgencia;
	private String telAgencia;
	private String codigoAgencia;
	
	public String getNomeAgencia() {
		return nomeAgencia;
	}
	
	public String getRuaEndAgencia() {
		return ruaEndAgencia;
	}
	
	public int getNumeroEndAgencia() {
		return numeroEndAgencia;
	}
	
	public String getComplementoEndAgencia() {
		return complementoEndAgencia;
	}
	
	public String getBairroEndAgencia() {
		return bairroEndAgencia;
	}
	
	public String getCepAgencia() {
		return cepAgencia;
	}
	
	public String getTelAgencia() {
		return telAgencia;
	}
	
	public String getCodigoAgencia() {
		return codigoAgencia;
	}
	
	public String getInfoAgencia() {
		return infoAgencia;
	}
	public void setInfoAgencia(String infoAgencia) {
		this.infoAgencia = infoAgencia;
	}
	
	public InfoAgencias(String nomeAgencia,String ruaEndAgencia,int numeroEndAgencia,String complementoEndAgencia,String bairroEndAgencia,String cepAgencia,String telAgencia,String codigoAgencia) {
		this.nomeAgencia = nomeAgencia;
		this.ruaEndAgencia = ruaEndAgencia;
		this.numeroEndAgencia = numeroEndAgencia;
		this.complementoEndAgencia = complementoEndAgencia;
		this.bairroEndAgencia = bairroEndAgencia;
		this.cepAgencia = cepAgencia;
		this.telAgencia = telAgencia;
		this.codigoAgencia = codigoAgencia;
	}
	
}
