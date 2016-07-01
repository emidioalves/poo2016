package classes;

public class Produto {
	private String nome;
	private double preco;
	private String tamanho;
	
	
	public Produto(String nome, double preco, String tamanho) {
		this.nome = nome;
		this.preco = preco;
		this.tamanho = tamanho;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}	
}
