package Oficina;

public class Or�amento {
   
   String CpfCliente;
   String CpfMecanico;
   String Valor;
   String Servi�os;
   
   public Or�amento(String CpfCliente, String CpfMecanico, String valor, String servi�os) {
	this.CpfCliente = CpfCliente;
	this.CpfMecanico = CpfMecanico;
	this.Valor = valor;
	this.Servi�os = servi�os;
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

public String getServi�os() {
	return Servi�os;
}

public void setServi�os(String servi�os) {
	Servi�os = servi�os;
}
   
   
   
}
