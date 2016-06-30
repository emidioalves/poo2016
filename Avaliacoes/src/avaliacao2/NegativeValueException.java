package avaliacao2;

public class NegativeValueException extends Exception {
	//caso a sua sess„o seja serializada
    //private static final long serialVersionUID = 1149241039409861914L;
   //note que criei uma classe que herda a excpetion e passo a mensagem para o construtor da mesma pelo super.
    NegativeValueException(String msg){
    	super(msg);
    	System.out.println("Adicinar valor positivo");
    }
    //aqui, voce criar o objeto com aexceÁao, passado o erro e a mensagem.
    //public  NegativeValueException(String msg, Throwable cause){
      //  super(msg,cause);
    //}

}
