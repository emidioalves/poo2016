package poo.projeto.locadora;

abstract class Carro {
	
	private String montadora;
	private String modelo;
	private String motorização;
	private double diaria;
	public String getMontadora() {
		return montadora;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMotorização() {
		return motorização;
	}
	public void setMotorização(String motorização) {
		this.motorização = motorização;
	}
	public double getDiaria() {
		return diaria;
	}
	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}
	
	
	

}
