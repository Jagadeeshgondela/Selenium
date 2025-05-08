package Core_Java;


/*An Abstract class is a class where atleast one method is abstract
 * An abstract class is a class that cannot be instantiated and is meant to be extended by other classes. It can have:

Abstract methods (without body)

Concrete methods (with body)

It acts as a base class for subclasses to implement missing behavior.

Can use any access modifiers for the methods in abstract class apart from private */

public abstract class AbsParentAirlines {
	public void safety() {
		System.out.println("Follow safety precautions");
	}
	protected void engine() {
		System.out.println("Follow engine precautions");
	}
	public abstract void logo();
	

}
