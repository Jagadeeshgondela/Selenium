package Core_Java;

import java.util.HashMap;

public class HasMapDemo {

	public static void main(String[] args) {
		
		HashMap<Integer,String> map = new HashMap<>();	// Key value pairs
		// Add
        map.put(1, "Apple");
        map.put(2, "Banana");

        // Modify
        map.put(2, "Blueberry"); // or map.replace(2, "Blueberry");

        // Delete
        map.remove(1);

        System.out.println(map); // Output: {2=Blueberry}
        map.put(11, "Apricot");
        map.put(22, "Badam");
        System.out.println(map.get(11));	//Apricot
        

	}

}
