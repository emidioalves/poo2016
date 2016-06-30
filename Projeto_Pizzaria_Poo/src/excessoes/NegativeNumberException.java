/**
 * 
 */
package excessoes;

/**
 * @author emidio28alves
 *
 */
public class NegativeNumberException extends Exception {
	
	public NegativeNumberException(){
		super("Não aceita valores negativos");
	}
}
