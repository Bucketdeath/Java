package Casa;

public class novo extends Imovel{
   private double adicionalP; 
   
	public novo(String endere�o, double pre�o, double adicionalP) {
		super(endere�o, pre�o);
		this.adicionalP = adicionalP;
	}
    public void adicionalPre�o() {
    	double total = pre�o *(adicionalP/100);
    	System.out.printf("O valor adicional do imovel novo � de: R$ %,.0f reais\n", total);
    }
    public void getPre�o() {
    	double total = pre�o *(adicionalP/100);
    	total +=pre�o;
    	System.out.printf("O valor do imovel com adicional � de: R$ %,.0f reais", total);
    }
    

}
