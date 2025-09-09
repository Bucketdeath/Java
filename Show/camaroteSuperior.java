package Show;

public class camaroteSuperior extends Vip{
	private double valorcamaroteS;

	public camaroteSuperior(double valor, double valorAdc, double valorcamaroteS ) {
		super(valor, valorAdc);
		this.valorcamaroteS = valorcamaroteS;
		
	}
	public String getValorcamaroteS() {
		
		valor +=valorAdc;
		valorcamaroteS += valor;
		return "O valor do seu ingresso vip camarote superior é de R$ "+valorcamaroteS+" reais";
	}

	
}
