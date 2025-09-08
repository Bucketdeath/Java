package Oficina;

public class Funcionario extends Pessoa{
    String id;
    String senha;
	public char[] getnome;
    
    public Funcionario() {
    	
    }
	public Funcionario(String n, String c, String s, String i) {
		super(n, c);
		this.senha = s;
		this.id = i;
		
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String novoCpf) {
		this.cpf = novoCpf;
	}
	public void setId(String newId) {
		this.id =  newId;
	}
	public String getId() {
		return id;
	}
	
	
}