package exercicio4;

public class Fatorial {
	
	public static int fatorial ( int n ){
		
		if (n <= 1){
			
			return 1;
		}
		else {
			return fatorial(n-1)*n;
		}
		
	}
}

