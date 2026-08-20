import java.util.HashMap;
import java.util.LinkedList;

public class SimpleCache  {
    private final int MAX_SIZE = 5;
    private HashMap<String, String>  cache = new HashMap<>();
    private LinkedList<String> listCache = new LinkedList<>();


    public void put(String key, String value) {
        if (key == null || value == null || key.isEmpty()) {
            return;
        }
        if (listCache.size() >= MAX_SIZE) {
            cache.remove(listCache.removeFirst());
        }
        listCache.addLast(key);
        cache.put(key, value);
    }
    public String get(String key) {
        if (key == null || key.isEmpty()) {
            System.out.println("Error: key is null or empty");
            return null;
        }
        return cache.get(key);
    }
    public void printCache() {
        if (listCache.isEmpty()) {
            System.out.println("No items in this loot");
            return;
        }
        for (String key : cache.keySet()) {
            System.out.println(key + ": " + cache.get(key));
        }
    }
}
