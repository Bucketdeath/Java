package Casa;

public class velho extends Imovel{
    private double desconto;
    
	public velho(String endere�o, double pre�o, double desconto) {
		super(endere�o, pre�o);
		this.desconto = desconto;
	}
	public void descontoVelhoPre�o() {
	  double total = pre�o * (desconto/100);
	  
	 System.out.printf("o valor de desconto � de R$ %,.0f reais\n", total);
	}
	public void getVelhoPre�o() {
		double total =pre�o *(desconto/100);
		pre�o -=total;
		System.out.printf("pre�o do imovel velho atualizado: R$ %,.0f reais\n", pre�o);
	}
		

}
