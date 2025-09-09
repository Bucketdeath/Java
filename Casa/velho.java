package Casa;

public class velho extends Imovel{
    private double desconto;
    
	public velho(String endereço, double preço, double desconto) {
		super(endereço, preço);
		this.desconto = desconto;
	}
	public void descontoVelhoPreço() {
	  double total = preço * (desconto/100);
	  
	 System.out.printf("o valor de desconto é de R$ %,.0f reais\n", total);
	}
	public void getVelhoPreço() {
		double total =preço *(desconto/100);
		preço -=total;
		System.out.printf("preço do imovel velho atualizado: R$ %,.0f reais\n", preço);
	}
		

}
