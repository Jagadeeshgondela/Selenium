package Core_Java;

public class Strings {

	public static void main(String[] args) {
		
		// Strings are immutable - once a String object is created, its value cannot be changed.
		// There are two ways of creating strings
		
		String a = " He!llo";	// it's called string literal (in the backend java creates object to the String class)
		String b = "Hello";	// a,b points to same memory location
		
		String c = new String("World");	// it's called object creation(new keyword used to create new object(new memory location))
		String d = new String("World");	// c,d stores in two different locations eventhough the value is same
		
		System.out.println("a == b: " + (a == b));     // true	- as == checks the memory location
		System.out.println("c == d: " + (c == d));     // false
		System.out.println("c.equals(d): " + c.equals(d)); // true - as .equals() checks the value
		
		/*
		 * ---Immutability---
		 * Let's say we have one string s1 = "Ram";
		 * s1=s1+"Sita";
		 * In this case, new object created for s1 after concatination.
		 * Previous object which stored only Ram is now dereferenced from s1 but not modified because of immutability but still 'Ram' is there in the String pool
		 * It'll be taken care by garbage collector */
		
		System.out.println(a.charAt(0));	// prints H
		System.out.println(a.indexOf("o"));	// prints 4
		System.out.println(a.substring(1,4));	//prints 'ell'
		System.out.println(a.substring(2));	//prints 'llo'
		System.out.println(a.replace('l','S'));	//prints 'HeSSo'
		System.out.println(a.toUpperCase());	//prints 'HELLO'
		System.out.println(a.toLowerCase());	//prints 'hello'
		System.out.println(a.trim());
		
		String[] v = a.split("!");
		System.out.println(v[0]);
		System.out.println(v[1]);
		
		
		/*To make Strings mutable, there are two classes 
		 * 1. StringBuilder - not thread(sub-program) safe (Asynchronous) - fast in execution
		 * 2. StringBuffer	- thread safe (Synchronous) - comparatively slow
		 * */
		
		StringBuilder sb = new StringBuilder("Krishna");
		System.out.println(sb);
		sb.insert(0, "Radha");
		System.out.println(sb);
		sb.append("ki jai");
		System.out.println(sb);
		sb.delete(13,19);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.replace(0, 5,"gopi");
		System.out.println(sb);
		


	}

}
