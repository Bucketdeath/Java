package Show;
import java.util.Scanner;
import Casa.Imovel;
import Casa.novo;
import Casa.velho;
public class main {
	public static void main(String []args) {
		   ingresso i = new ingresso(50);
		   Vip v = new Vip(50,90);
		   camaroteInferior ci = new camaroteInferior(50,90);
		   camaroteSuperior cs = new camaroteSuperior (50,90,60);
		   Scanner input =new Scanner (System.in);
		   System.out.println("Escolha o ingresso abaixo:");
		   System.out.println("1: ingresso normal\n2: ingresso Vip");
		   int resp = input.nextInt();
		   if (resp==2) {
			   System.out.println("Seu ingresso é vip");
			   System.out.println("Escolha o tipo de camarote abaixo");
			   System.out.println("1: camarote superior\n2: camarote inferior");
			   int resp1 = input .nextInt();
			   if (resp1==1) {
				   System.out.println("você escolheu o camarote superior");
				   System.out.println(cs.getValorcamaroteS());
				   System.out.println("------------------------");
			   }
			   else {
				   System.out.println("você excolheu o camarote inferior");
				   System.out.println(ci.getLocal());
				   System.out.println(v.getValorAdc());
				   System.out.println("------------------------");
			   }
			   
		   }
		   else {
			   System.out.println(i.imprimeValor());
			   System.out.println("------------------------");
			   
		   }
		   Imovel casinha = new Imovel("44091-580", 50000);
		   novo casinhaNova = new novo("44091-580", 50000, 20);
		   velho casinhaVelha = new velho("44091-580", 50000, 20);
		   System.out.println("Escolha o Imovel abaixo:");
		   System.out.println("1: Imovel novo\n2: Imovel velho");
		   int respImovel = input.nextInt();
		   if(respImovel == 1) {
			   casinhaNova.adicionalPreço();
			   casinhaNova.getPreço();
		   }
		   else {
			   casinhaVelha.descontoVelhoPreço();
			   casinhaVelha.getVelhoPreço();
		   }
		   
	  }
}
