package modelo;

public class Site {
	
 //atributos
	private String Nome;
	private int id;
	private String Endereco;
	
	
	//construtores
	
	public Site(int id, String Nome, String Endereco) {
	this.id=id;
	this.Nome=Nome;
	this.Endereco=Endereco;
	
}
	public Site() {
		// TODO Auto-generated constructor stub
	}
	//gets e sets
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		this.Endereco = endereco;
	}
	
	//metodos
	public String show() {
		return "Id: " +this.id + "\nNome: " +this.Nome
				+ " \nEndereco: " + this.Endereco; 
	}
}
