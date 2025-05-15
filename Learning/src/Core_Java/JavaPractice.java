package Core_Java;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class JavaPractice {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hey","hi","goD");
        List<String> upper = words.stream().map(n-> n.toUpperCase()).collect(Collectors.toList());
        for(String word : upper) System.out.println(word);

}
}



