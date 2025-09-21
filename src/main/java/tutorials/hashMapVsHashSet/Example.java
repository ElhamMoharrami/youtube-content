package tutorials.hashMapVsHashSet;

import java.util.HashMap;
import java.util.HashSet;

public class Example {
    public static void main(String[] args) {
        HashMap<String,Integer> scores=new HashMap<>();
        scores.put("John",80);
        scores.put("Jane",90);
        scores.put("Jack",70);

        HashSet<String> colors=new HashSet<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("Example HashMap:");
        System.out.println(scores);

        System.out.println("Example HashSet:");
        System.out.println(colors);
    }
}
