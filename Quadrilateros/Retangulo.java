package Quadrilateros;

public class Retangulo implements Quadrilatero{
    double base;
    double altura;
    
    public Retangulo(double base, double altura) {
    	this.base = base;
    	this.altura = altura;
    }
	
	public double calcularArea() {
		
		return base * altura;
	}

	
	public double calcularPerimetro() {
		
		return (base + altura) * 2;
	}
	public static void main(String[]args) {
		Retangulo r = new Retangulo(8,11);
		System.out.println(r.calcularArea());
		System.out.println(r.calcularPerimetro());
	}

}
