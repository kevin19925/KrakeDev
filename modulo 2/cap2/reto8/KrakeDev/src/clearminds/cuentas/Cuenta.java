package clearminds.cuentas;

public class Cuenta {

	private String Id;
	private String Tipo;
	private double Saldo;
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	public Cuenta(String id) {
	
		this.Id = id;
		this.Tipo="A";
		
	}

	public Cuenta(String id, String tipo, double saldo) {
		super();
		Id = id;
		Tipo = tipo;
		Saldo = saldo;
	}
	
	
	
	public void imprimir() {
		
		System.out.println("\n\n\n********************");
		System.out.println("CUENTA");
		System.out.println("********************");
		System.out.println("Numero de Cuenta : "+this.Id);
		System.out.println("Tipo: "+this.Tipo);
		System.out.println("Saldo:USD "+this.Saldo);
		System.out.println("**********************");

		
	}
	
	
}
