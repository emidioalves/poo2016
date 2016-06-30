package avaliacao2;

import java.util.*;


public class Loja {
	private String nomeEmpresa;
	private ArrayList<Produto> lista_produtos;
	
	//costrutor do arraylist
	public Loja(String nomeEmpresa){
		this.nomeEmpresa = nomeEmpresa;
		lista_produtos =  new ArrayList<Produto>();
	}
	
	//metodo para adicionar Livros a lista de produtos
	public void addLivro(String nome, double preco){
		
		try{
			if (preco  > 0){
				lista_produtos.add(new Livro(nome,preco));
			}
		}
		catch (Exception e) {
			e.getMessage();
			
		}
		finally{
			System.out.println("Hoje está quente");
		}
}
	
	//lista para adicionar cds a lista de produtos
	public void addCD(String nome, double preco){
		
			try{
				if (preco  > 0){
					lista_produtos.add(new CD(nome,preco));
				}
			}
			catch (Exception e) {
				e.getMessage();
				
			}
			finally{
				System.out.println("Hoje está quente");
			}
	}
	//numero de cds na lista
	public int numeroCDS(){
		int number=0;
		     
		    for(int i=0;i<lista_produtos.size();i++){
		    	if(lista_produtos.get(i) instanceof CD )
		    		number++;
		    }	    	
    return number;}
	
	// numero de livros na lista
	public int numeroDesenvolvedores(){
		int number=0;
		     
		    for(int i=0;i<lista_produtos.size();i++){
		    	if(lista_produtos.get(i) instanceof Livro )
		    		number++;
		    }	    	
    return number;
    }
	
	public void listaDeProdutos(){
		 boolean state1=false; 
		 boolean state2=false;
		 
			System.out.println(">>>> Lista de Produtos  - Loja "+ this.nomeEmpresa+" <<< \n");
			System.out.println("--------------------------");
			System.out.println("         CD(s)       ");
			System.out.println("--------------------------\n");
			
			for(int i=0;i<lista_produtos.size();i++){
				
			    if(lista_produtos.get(i) instanceof CD){
			    	
			    	//toString();
			    	
			    	System.out.println("Nome: "+lista_produtos.get(i).nome+" / Preco: "+lista_produtos.get(i).preco);

				state1=true;}
			
			
			}
			if(!state1)// caso nao mude, eh porque n existe objeto do tipo Gerente no array estanciado
				System.out.println("A empresa ainda nao possui CD(s) \n");
			
			System.out.println();
			System.out.println("--------------------------");
			System.out.println("         Livro(s)"           );
			System.out.println("--------------------------\n");
			
			for(int i=0;i<lista_produtos.size();i++){
			    if(lista_produtos.get(i) instanceof Livro)
			    	
			    	//System.out.println(Lista_produto.get(i));
			    	System.out.println("Nome do livro: "+lista_produtos.get(i).nome+" / Preço: "+lista_produtos.get(i).preco);

				state2=true;}
			if(!state2)// caso nao mude, eh porque n existe objeto do tipo Gerente no array estanciado

				System.out.println("A empresa ainda nao possui Livros(s) \n");
		}
	
	public void buscar(String nome){
		//System.out.print("Digite o nome:  ");
		//String nome  = input.nextLine();
		Produto produto = buscarProduto(nome);
		if (produto instanceof Livro){
			
			System.out.println(produto );
		}
		
		if(produto instanceof CD){
			System.out.println(produto );
		}
		else
			System.out.print("Produto não encontrado");

	}
	
	//funcao para buscar produto pelo nome
		public Produto buscarProduto(String nome){
			for (Produto prod : lista_produtos){
				if (prod.getNome().equals(nome))
					return (prod);
			}
			return null;
		}
	

}
