package Casa;

public class novo extends Imovel{
   private double adicionalP; 
   
	public novo(String endereço, double preço, double adicionalP) {
		super(endereço, preço);
		this.adicionalP = adicionalP;
	}
    public void adicionalPreço() {
    	double total = preço *(adicionalP/100);
    	System.out.printf("O valor adicional do imovel novo é de: R$ %,.0f reais\n", total);
    }
    public void getPreço() {
    	double total = preço *(adicionalP/100);
    	total +=preço;
    	System.out.printf("O valor do imovel com adicional é de: R$ %,.0f reais", total);
    }
    

}
