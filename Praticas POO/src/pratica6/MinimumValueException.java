package pratica6;

public class MinimumValueException extends Exception {
	//caso a sua sess„o seja serializada
    private static final long serialVersionUID = 1149241039409861914L;
   //note que criei uma classe que herda a excpetion e passo a mensagem para o construtor da mesma pelo super.
   public  MinimumValueException(String msg){
    	super(msg);
    }

}
