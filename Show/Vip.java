package Show;

public class Vip extends ingresso{
    double valorAdc;
    
	public Vip(double valor, double valorAdc) {
		super(valor);
		this.valorAdc = valorAdc;	
	}
	public String getValorAdc() {
		valor += valorAdc;
		return"O valor do seu ingresso vip é de R$ "+valor+" reais";
	}
	
}
