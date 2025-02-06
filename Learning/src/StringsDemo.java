
public class StringsDemo {
	public static void main(String[] args) {
		String a = "hello"; 
		String b = "hello"; // since both a, b having same value, both are pointing to same memory location
		System.out.println(a==b); // == checks whether memory location pointing by both variables same or not
		System.out.println(a.equals(b)); // equals() checks the content of variables same or not
		
		// Another way of declaring strings, this declaration creates separate memory location for each variable eventhough the value they are storing is same
		String c = new String("hey");
		String d = new String("hey");
		System.out.println(c==d); // returns false because memory locations are different for c,d
		System.out.println(c.equals(d)); //return true because both have same value
		
		//strings are immutable
		a = a + " world";
		System.out.println(a); // returns hello world
		System.out.println(b); // returns hello
		
		/*initially both a,b pointing to same location because of same value they are holding, 
		 * once a is modified, separate string literal created in another location instead of changing in previous location because of immutability.
		 */
		
		// we can make the strings mutable with 2 classes called StringBuffer and StringBuilder
		
		StringBuffer sb = new StringBuffer("mutable string");
		StringBuffer sc = new StringBuffer("mutable string");
		System.out.println(sb==sc); //returns false because of two different references
		System.out.println(sb.equals(sc)); 
		/*In Object, equals() also checks for reference equality, just like ==.
		Hence, this will also return false, as sb and sc refer to different objects.*/
		
		System.out.println(sb.append(" end"));
		System.out.println(sc.reverse());
		System.out.println(sb.insert(0,"hi"));
		System.out.println(sb.deleteCharAt(1));
		System.out.println(sb.replace(0, 2, "im"));
		
		/*both StringBuffer & StringBuilder are same but the only difference is 
		 * StringBuffer is synchronized - only allow one thread at a time(Tasks are executed one after another)
		 * StringBuilder is Asynchronous - Tasks can be executed concurrently.
		 */
	}
}
