package avaliacao2;

public class Livro extends Produto {
	
	public Livro(String nome, double preco) {
		super(nome, preco);
	}
	
	private String autor;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString(){
		return "Livro: " + this.nome + "\n" + "Preço:" + this.preco + "\n" + "Autor: " + this.autor;
	}
	

}
