import java.util.ArrayList;

public class Java_Basics {
	public static void main(String[] args) {
		
		// ***** Arrayas *****
		int a[] = new int[5];
		a[0]=1;
		a[1]=2;
		System.out.println(a[1]);
		
		// Directly initializing with array elements
		int array2[] = {10,11,12,13,14,15};
		for(int i=0;i<array2.length;i++) {
		System.out.println(array2[i]);
		}
		
		
		//*** ArrayList ***
		ArrayList<String> NewArray = new ArrayList<String>();
		NewArray.add("Jagadeeswara");
		NewArray.add("Rao");
		NewArray.add("Gondela");
		
		for(int i=0;i<NewArray.size();i++){
			
			System.out.println(NewArray.get(i));

		}
		
		NewArray.remove(1);
		
		for(int i=0;i<NewArray.size();i++){
			
			System.out.println(NewArray.get(i));

		}
		Java_Basics b = new Java_Basics();
		b.method3();
		b.method2();
		b.method1();
		
	}
	
	// ***** Methods *****
	
	public void method1()
	{
		System.out.println("Method-1");
	}
	
	public int method2()
	{
		int a= 10;
		int b = 20;
		int c = a+b;
		System.out.println("Method-2 : "+ c);
		return c;
	}
	
	public static void method3()
	{
		System.out.println("Method-3");
	}


}

