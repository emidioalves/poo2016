package exercicio4;
//imprima os fatoriais de 1 a 10


public class Exercicio4 {

	public static void main(String[] args) {
		int fat;
		for (int i = 1; i <=10; i++){
			fat = Fatorial.fatorial(i);
			System.out.println(fat);
		}
	}

}
