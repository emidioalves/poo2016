package classeTestes;

public class ClienteTeste {

	private String nome;
	private String sobrenome;
	private String cpf;
	private EnderecoTeste endereco;

	public ClienteTeste(String nome, String sobrenome, String cpf, EnderecoTeste endereco) {
		if(nome == null || sobrenome == null || cpf == null || endereco == null){
			throw new IllegalArgumentException("Informacoes invalidas, tente novamente!");
		}else{
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.cpf = cpf;
			this.endereco = endereco;
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public EnderecoTeste getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + " " + this.sobrenome + " - CPF: " + this.cpf + "\n" + endereco.toString();
	}
	
}
