package Core_Java;

public class Class1 {
	
	public void outsideMain() {
		
		System.out.println("This is outside to main method");
	}

	public static void main(String[] args) {
		
		System.out.println("This is class-1");
		
		Class1 c1 = new Class1();	// new keyword creates memory allocation for the class1 object
		c1.outsideMain();	// have to create object of the class if you want to access methods which is outside of main method
		
		Class2 c2 = new Class2();	// you can access another class methods by creating object to that class
		c2.setData();
		
	}

}
