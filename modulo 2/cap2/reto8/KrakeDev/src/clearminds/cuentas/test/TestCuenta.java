package clearminds.cuentas.test;
import clearminds.cuentas.*;
public class TestCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Cuenta cuental = new Cuenta("03476");
cuental.setSaldo(675);
Cuenta cuenta2 = new Cuenta("03476","C",98);

Cuenta cuenta3 = new Cuenta("03476");
cuenta3.setTipo("C");

System.out.println("---Valores Iniciales---");
cuental.imprimir();
cuenta2.imprimir();
cuenta3.imprimir();

// VALORES MODIFICADOS
System.out.println("---Valores modificados---");

cuental.setSaldo(444);
cuenta3.setSaldo(567);
cuenta2.setTipo("D");



cuental.imprimir();
cuenta2.imprimir();
cuenta3.imprimir();

//CUENTA 6
Cuenta cuenta4 = new Cuenta("0987");
cuenta4.setTipo("A");
cuenta4.setSaldo(10);
cuenta4.imprimir();

//CUENTA 5
Cuenta cuenta5 = new Cuenta("0557","C",10);
cuenta5.imprimir();


 //CUENTA 6
Cuenta cuenta6 = new Cuenta("0666","A",0);
cuenta6.imprimir();

	}

	
}
