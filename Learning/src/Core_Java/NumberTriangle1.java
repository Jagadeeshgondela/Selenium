package Core_Java;

public class NumberTriangle1 {
	public static void main(String[] args) {
		int v=1;
		for(int i=0;i<4;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(v);
				System.out.print(" ");
				v++;
			}
			System.out.println("");
		}
	}

}
