package Carro;

public class bombaCombustivel {
     
	
	private String tipoCombustivel;
	private double valorLitro;
	private double quantidadeCombustivel;
	
	public bombaCombustivel(String tipoCombustivel, double valorLitro, double quantidadeCombustivel){
		this.tipoCombustivel = tipoCombustivel;
		this.valorLitro = valorLitro;
		this.quantidadeCombustivel = quantidadeCombustivel;
	}
	public String abastecerPorValor(double valor) {
		double litros = valor / valorLitro;
		this.quantidadeCombustivel -= litros;
		return "Foi inserido "+litros+" litros de combustivel";
	}
			
	public String abastecerPorLitro(double litros) {
		double valor = litros * valorLitro;
		this.quantidadeCombustivel -= litros;
		return"Total a pagar R$ "+valor;
	}
	public void setValor(double novoValor) {
		this.valorLitro = novoValor;
	}
	public void setCombustivel(String novoCombustivel) {
		this.tipoCombustivel = novoCombustivel;
	}
	public void setQuantidadeCombustivel(double novaQuantidade) {
		this.quantidadeCombustivel = novaQuantidade;
	}
	public double getValor() {
		return valorLitro;
	}
	public String getCombustivel() {
		return tipoCombustivel;
	}
	public double getQuantidade() {
		return quantidadeCombustivel;
	}
	public static void main (String [] args) {
		
		bombaCombustivel bombinha = new bombaCombustivel("gasolina", 5.00, 2000);
		bombinha.setCombustivel("etanol");
		bombinha.setValor(4.00);
		bombinha.setQuantidadeCombustivel(3000);
		System.out.printf("novo combustivel: %s , novo valor do litro: R$ %.2f , nova quantidade da bomba: %.0f\n", bombinha.getCombustivel(), bombinha.getValor(), bombinha.getQuantidade());
		System.out.println(bombinha.abastecerPorValor(40));
		System.out.printf("Quantidade em Litros na bomba: %.2f \n", bombinha.getQuantidade());
		System.out.println(bombinha.abastecerPorLitro(20));
		System.out.printf("Quantidade em Litros na bomba: %.2f ", bombinha.getQuantidade());
		
		
		
	}
	
	
}

   
