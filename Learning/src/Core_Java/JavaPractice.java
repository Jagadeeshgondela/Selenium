package Core_Java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.HashSet;

public class JavaPractice {

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,2,5,9,9,3,1,3,7,9};
        
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicate = new HashSet<>();
        
        for(int num : arr) {
        	if(!seen.add(num)) {
        		duplicate.add(num);
        	}
    }
        for(int num : duplicate)
        	System.out.println(num);

}
}



