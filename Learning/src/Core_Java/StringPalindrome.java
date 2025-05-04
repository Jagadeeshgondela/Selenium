package Core_Java;

public class StringPalindrome {
	public static void main(String[] args) {
		String name = "Ram";
		String reverse = "";
		for(int i =0;i<name.length();i++) {
			reverse=name.charAt(i)+reverse;
		}
		
		if(name.equals(reverse)) 
			System.out.println("Given name: '"+name+"' is a Palindrome");
		else
			System.out.println("Given name: '"+name+"' is not a Palindrome");
		
	}

}
