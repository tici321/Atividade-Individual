package modelo;

public class Usuario {
	private int id;
	private String Nome;
	private String Endereco;
	private String Usuario;
	private String Email;
	private String senha;
	
	//construtores
	
		public Usuario(int id, String Nome, String Endereco, String Usuario, String Email, String senha) {
		this.id=id;
		this.Nome=Nome;
		this.Endereco=Endereco;
		this.Usuario=Usuario;
		this.Email=Email;
		this.senha=senha;
		
	}
		public Usuario() {
			// TODO Auto-generated constructor stub
		}
		//gets e sets
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
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
		Endereco = endereco;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
