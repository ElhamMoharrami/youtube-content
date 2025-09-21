package tutorials.hashMapVsHashSet;

import java.util.HashMap;
import java.util.HashSet;

public class LiveCodeExample {
    public static void main(String[] args) {
        HashMap<String,Integer> map= new HashMap<>();
        map.put("Apple",10);
        map.put("Banana",20);
        map.put("Orange",30);
        map.put("Pear",40);

        System.out.println("HashMap content: "+map);

        System.out.println("Value for key 'Orange':"+ map.get("Orange"));
        System.out.println("Does the map contain key 'Apple':"+ map.containsKey("Apple"));
        map.remove("Apple");
        System.out.println("HashMap after remove key 'Apple':"+ map);

        for(String key: map.keySet()){
            System.out.println(key+"=>"+map.get(key));
        }

        HashSet<String> set=new HashSet<>();
        set.add("Red");
        set.add("Blue");
        set.add("Green");
        set.add("Green");
        System.out.println("HashSet content: "+set);

        System.out.println("Does the set contain 'Blue'?"+set.contains("Blue"));
        set.remove("Red");
        System.out.println("HashSet after removing Red"+set);

        for(String color:set){
            System.out.println(color);
        }
    }
}
