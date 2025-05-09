package Core_Java;

import java.util.HashSet;
import java.util.Set;

public class HashSEtExample {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		/*
         * Does not maintain insertion order (like a List does)
         * Does not allow duplicate values
         * Does not provide access by index
         */
		
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        System.out.println(set.contains("Banana"));
        set.remove("Banana");

        System.out.println(set);
	}
}
