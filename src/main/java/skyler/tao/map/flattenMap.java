package skyler.tao.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class flattenMap {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        for (int i = 0; i < 29; i++) {
            myMap.put("key " + i, i);
        }

        System.out.println(myMap.values());

        System.out.println(new ArrayList<>(myMap.keySet()));
    }
}
