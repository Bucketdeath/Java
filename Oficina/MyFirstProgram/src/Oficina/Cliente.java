package Oficina;

public class Cliente extends Pessoa {
	String id;
    String email;
    String telefone;
    String endereco;
    String placa;
	public Cliente(String n, String c,String e, String t, String en, String p, String id) {
		super(n, c);
		this.email = e;
		this.telefone = t;
		this.endereco = en;
		this.placa = p;
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
  
}
