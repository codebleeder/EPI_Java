package Chapter12_HashTables;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashTables_03_LRUCache {
    public static class LRUCache {
        LinkedHashMap<Integer, Integer> isbnToPrice;

        public LRUCache(int capacity) {

            isbnToPrice = new LinkedHashMap<>(capacity, 1.0f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                    return this.size() > capacity;
                }
            };
        }

        public Integer lookup(Integer key) {
            if (!isbnToPrice.containsKey(key)) {
                return null;
            }
            return isbnToPrice.get(key);
        }

        public void insert(Integer key, Integer value) {
            isbnToPrice.get(key);
            if (!isbnToPrice.containsKey(key)) {
                isbnToPrice.put(key, value);
            }
        }

        public Boolean erase(Object key) {
            return isbnToPrice.remove(key) != null;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        for (int i = 0; i < 5; ++i) {
            cache.insert(i, i);
        }
        System.out.println(cache.lookup(2));
    }
}
