package exercicio4;

public class Fatorial {
	
	public static double fatorial ( int n ){
		
		if (n <= 1){
			
			return 1;
		}
		else {
			return fatorial(n-1)*n;
		}
		
	}
}

