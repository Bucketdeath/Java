package Oficina;

public class Orçamento {
   
   String CpfCliente;
   String CpfMecanico;
   String Valor;
   String Serviços;
   
   public Orçamento(String CpfCliente, String CpfMecanico, String valor, String serviços) {
	this.CpfCliente = CpfCliente;
	this.CpfMecanico = CpfMecanico;
	this.Valor = valor;
	this.Serviços = serviços;
}

public String getCpfCliente() {
	return CpfCliente;
}

public void setCpfCliente(String cpfCliente) {
	CpfCliente = cpfCliente;
}

public String getCpfMecanico() {
	return CpfMecanico;
}

public void setCpfMecanico(String cpfMecanico) {
	CpfMecanico = cpfMecanico;
}

public String getValor() {
	return Valor;
}

public void setValor(String valor) {
	Valor = valor;
}

public String getServiços() {
	return Serviços;
}

public void setServiços(String serviços) {
	Serviços = serviços;
}
   
   
   
}
