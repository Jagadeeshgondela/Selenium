package Core_Java;

public class TrafficLights implements UniversalTraffic,Pedistraints{

	public static void main(String[] args) {
		
		//Created this class to demonstrate Interface
		UniversalTraffic ut = new TrafficLights();	//created object for the class TrafficLights to access methods of interface UniversalTraffic
		
		ut.goGreen();
		ut.goRed();
		ut.goYellow();
		
		TrafficLights tl = new TrafficLights();	//Created object of the class TrafficLights to access method of class TrafficLights
		tl.classMethod();
		
		Pedistraints p = new TrafficLights();	// created object for the class TrafficLights to access methods of interface Pedistraints
		p.goWalk();

	}
	
	public void classMethod() {
		System.out.println("Class internal method executed");
	}

	@Override
	public void goGreen() {
		// TODO Auto-generated method stub
		System.out.println("Go Green executed");
		
	}

	@Override
	public void goRed() {
		// TODO Auto-generated method stub
		System.out.println("Go Red executed");
		
	}

	@Override
	public void goYellow() {
		// TODO Auto-generated method stub
		System.out.println("Go Yellow executed");
	}

	@Override
	public void goWalk() {
		// TODO Auto-generated method stub
		System.out.println("Go Walk executed");
		
	}

}

/*
 * An interface in Java is a blueprint for a class. It is used to specify a set of abstract methods that other classes must implement. Interfaces provide a way to achieve abstraction and multiple inheritance in Java.

🔧 Key Points:
An interface contains method declarations (no method bodies unless they are default or static methods).

A class implements an interface using the implements keyword.

One class can implement multiple interfaces, enabling multiple inheritance.

Variables in an interface are implicitly public, static, and final.

Methods are implicitly public and abstract (unless marked default or static).

*/
