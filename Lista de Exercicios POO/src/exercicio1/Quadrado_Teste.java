package exercicio1;

public class Quadrado_Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quadrado quadrado = new Quadrado();
		
		quadrado.lado = 6;
		
		quadrado.calculaArea(quadrado.lado);
		quadrado.calculaPerimetro(quadrado.lado);
		
		System.out.println("Area do quadrado:  " + quadrado.area );
		System.out.println("Perimetro do quadrado:  " + quadrado.perimetro );

	}

}
