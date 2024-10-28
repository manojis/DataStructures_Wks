package com.HackerRank;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/27/24
 */
public class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Set accessOrder to true to maintain the order of access
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                // Remove the oldest entry if the cache size exceeds the capacity
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public V get(K key) {
        // Return the value if it exists, otherwise return null
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        // Add or update the key-value pair
        cache.put(key, value);
    }

    public void displayCache() {
        System.out.println(cache);
    }

    public static void main(String[] args) {
        // Test the LRU Cache with a capacity of 3
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");
        lruCache.displayCache();  // Output: {1=One, 2=Two, 3=Three}

        lruCache.get(1);  // Access key 1, making it recently used
        lruCache.displayCache();
        lruCache.put(4, "Four");  // Add key 4, which should evict key 2

        lruCache.displayCache();  // Output: {3=Three, 1=One, 4=Four}
    }
}
