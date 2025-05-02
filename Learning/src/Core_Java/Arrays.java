package Core_Java;

public class Arrays {

	public static void main(String[] args) {
		
		//Array is a sequence of values of same type like integer array, array of strings,characters so on
		
		int a[] = new int[5];	// declaration of array by specifying the fixed size
		
		// adding elements into the array
		a[0]=1;
		a[1]=2;
		a[2]=3;
		a[3]=4;
		a[4]=10;
		
		// printing all elements in the array
		
		for(int i =0; i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		
		//Initiating array with values
		
		String[] s = {"ram","laxman","Janaki"};	// Array of strings
		
		char[] letters = {'a','b','c'};	// Array of characters
		
		// Convert a string to character array
		
		String name = "Rama";
		char[] c = name.toCharArray();
		
		for(int i =0;i<c.length;i++) {
			System.out.println(c[i]);

		}

	}

}
