package Core_Java;

public class InvertedTriangle {
	public static void main(String[] args) {
		int v=1;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4-i;j++) {
				System.out.print(v);
				System.out.print("  ");
				v++;
			}
			System.out.println("");
		}
	}

}
