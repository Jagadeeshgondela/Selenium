package Core_Java;

import java.util.ArrayList;

public class ArrayListCollection {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();	/* ArrayList class implements List interface, which made easy to add/modify/delete elements in the array
		 - It is sequential collection, indexing used to delete/add/modify data
		 - Duplicates are allowed*/
		al.add("Ram");
		al.add("Sita");
		al.add("laxman");
		System.out.println(al);
		al.add(2, "Hanuma");
		System.out.println(al);
		al.add(0,"extra");
		System.out.println(al);
		al.remove(0);
		System.out.println(al);
		al.set(0, "rama");
		System.out.println(al);
		System.out.println(al.isEmpty());
	}

}
