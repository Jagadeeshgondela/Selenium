package Core_Java;

public class MultiDimentionalArray {

	public static void main(String[] args) {
		
		// Declaring a multi dimentional array
		
		int a[][] = new int[3][2];	// 3 rows, 2colummns
		
		// adding elements into the array
		
		a[0][0] = 10;
		a[0][1] = 11;
		a[1][0] = 12;
		a[1][1] = 13;
		a[2][0] = 14;
		a[2][1] = 15;
		
		// simply we can initiate a multi dimentional array like this
		int b[][] = {{1,2,3},{4,5,6}};	//2 rows, 3 columns
		
		System.out.println(a.length);	// a.length gives no.of rows
		// printing all the elements in the 2D array
		
		for(int i =0;i<b.length;i++) {
			for(int j=0;j<2;j++) {
			System.out.println(b[i][j]);
		}
		}

	}

}
