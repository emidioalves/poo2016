package avaliacao2;

public class CD extends Produto {
	
	public CD(String nome, double preco){
		super(nome,preco);
	}
	
	private int numFaixas;

	public int getNumFaixas() {
		return numFaixas;
	}

	public void setNumFaixas(int numFaixas) {
		this.numFaixas = numFaixas;
	}
	
	@Override
	public String toString(){
		return "CD: " + this.nome + "\n" + "Preço:" + this.preco + "\n" + "numero de faixas: " + this.numFaixas;
	}

}
