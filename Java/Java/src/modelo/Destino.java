package modelo;


public class Destinos {

	private int id;
	private String nacional;
	private String internacional;
	private double valor;
	
	
	public Destinos(int id, String nacional,String internacional, double valor) {
		super();
		this.id = id;
		this.nacional = nacional;
		this.internacional = internacional;
		this.valor = valor;
	
	public Destinos() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNacional() {
		return nacional;
	}
	public void setNacional(String nacional) {
		this.nacional = nacional;
	}
	
	}
	public String getInternacional() {
		return internacional;
	}
	public void setInternacional(String destino) {
		this.internacional = internacional;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
	
	