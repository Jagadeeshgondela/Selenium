package Core_Java;

public class AkasaAirlines extends AbsParentAirlines{	// Inheriting parent class

	public static void main(String[] args) {
		AkasaAirlines al = new AkasaAirlines();	
		al.engine();	// just by creating object of child class, we can access parent class methods also because of inheritance
		al.safety();
		al.logo();

	}

	@Override
	public void logo() {
		System.out.println("Akasa logo");
		
	}

}
