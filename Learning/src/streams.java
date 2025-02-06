import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class streams {
	//@Test
	public static void getCount() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Jaga");
		a.add("Jain");									// Traditional logic
		a.add("Rakki");
		a.add("sam");
		int count=0;
		
		for(int i=0; i<a.size();i++) {
			if(a.get(i).startsWith("J")) {
				count+=1;
			}
		}
		System.out.println(count);
		}
	
	//@Test
	public static void streamCount() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Jaga");
		a.add("Jain");
		a.add("Rakki");
		a.add("sam");
		
		//a.stream().filter(name -> name.startsWith("J")).count(); 	// Using stream
		
		long counts = Stream.of("Raju","sanket","vishnu","sam","sundar").filter(n -> n.startsWith("s")).count();
		System.out.println("Count of names with starting letter s : "+counts);
	}
	
	@Test
	public void streamMap() {
		
		Stream.of("Raju","sanket","vishnu","sam","sundar","Ram").filter(s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String> l1 = Arrays.asList("Raghu","Arsaf","mahesh");
		List<String> l2 = Arrays.asList("Raunak","prem","vamsi");
		
		List<String> mergedList = Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());
		
		mergedList.stream().sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}
}



