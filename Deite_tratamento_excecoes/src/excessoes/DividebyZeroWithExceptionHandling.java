package excessoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DividebyZeroWithExceptionHandling {

	private static Scanner scan;

	public static int quotient(int numerator, int denominator) throws ArithmeticException
		{
			return numerator/denominator;
		}
	
	public static void main(String[] args) {

		scan = new Scanner(System.in);
		boolean loop = true;
		
		do
		{
			try //le dois numeros e calcula o quociente
			{
				System.out.print("Entre um numerador inteiro: ");
				
				int numerator = scan.nextInt();
				if(numerator < 0){
					throw new NegativeNumberException();	
				}
				
				System.out.print("Entre um denominador inteiro: ");
				
				int denominator = scan.nextInt();
				if(denominator < 0){
					throw new NegativeNumberException();	
				}
				
				int result = quotient(numerator, denominator);
				System.out.printf("Resultado: %d / %d = %d\n ", numerator, denominator, result);
				loop = false;

			}
			catch (InputMismatchException inputMismatchException)
			{
				//System.err.printf("\nExceção: %s", inputMismatchException);
				//scan.nextLine();
				System.err.println("Necessario entrar com um inteiro. Tente novamente\n");
				scan.nextLine();
			}
			catch(ArithmeticException arithmeticException)
			{
				System.err.printf("\nExceção: %s", arithmeticException);
				System.out.println("Zero é um denominador invalido. Tente novamente\n");

			}
			catch(NegativeNumberException negativeNumberException)
			{
				System.err.printf("\nExceção: %s", negativeNumberException);
				System.out.println("Valor negativo. Tente novamente\n");

			}

			
		}
		while(loop);
	}

}
