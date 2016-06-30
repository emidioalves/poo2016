package pratica6;

public class NegativeException extends Exception {
	//caso a sua sess„o seja serializada
    private static final long serialVersionUID = 1149241039409861914L;
   //note que criei uma classe que herda a excpetion e passo a mensagem para o construtor da mesma pelo super.
    public  NegativeException(String msg){
    	System.out.println("Nao foi possivel adicionar produto. Preço NEgativo");
    }
    //aqui, voce criar o objeto com aexceÁao, passado o erro e a mensagem.
    public  NegativeException(String msg, Throwable cause){
        super(msg,cause);
    }
}
