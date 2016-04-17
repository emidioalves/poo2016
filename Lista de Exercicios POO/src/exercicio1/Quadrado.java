package exercicio1;

public class Quadrado {
	
	double lado;
	double area;
	double perimetro;
	
	//metodo para calcular a area
	void calculaArea (double lado){
		this.area = lado*lado;
	}
	
	//metodo para calcular perimetro
	void calculaPerimetro (double lado){
		this.perimetro = 4*lado;
	}
	

}
