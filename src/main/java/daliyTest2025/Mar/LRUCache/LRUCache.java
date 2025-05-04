package daliyTest2025.Mar.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer,Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = cache.remove(key);
        if(value!=null){
            cache.put(key,value);
            return value;
        }else
            return -1;
    }

    public void put(int key, int value) {
        if(cache.remove(key)!=null){
            cache.put(key,value);
            return;
        }
        if(cache.size()==this.capacity){
            Integer oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
            cache.put(key,value);
        }
    }
}
