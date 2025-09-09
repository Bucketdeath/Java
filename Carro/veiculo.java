package Carro;

public class veiculo {
	private double combustivel;
	   private double consumo;
	   
	   public veiculo(double combustivel, double consumo) {
		this.combustivel = combustivel;
		this.consumo = consumo;
		
	   }
	   public double getcombustivel() {
		   return combustivel;
	   }
	   public void addCombustivel(double Combustivel) {
	       this.combustivel += Combustivel;
	   }
	   public void andar (double km) {
	       double andar;
		   andar = km / consumo;
		   combustivel -= andar;
			   

	   }
	   public static void main (String [] args) {
		   veiculo Skyline = new veiculo(100, 15);
		   System.out.println(Skyline.getcombustivel());
		   Skyline.andar(20);
		   System.out.println(Skyline.getcombustivel());
		   Skyline.addCombustivel(10);
		   System.out.println(Skyline.getcombustivel());
		   
	   }
}
