package StackAndQueue.stackImplementation;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    Deque<Integer> deq;
    int capacity;
    Map<Integer, Integer> mp;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        deq = new LinkedList<>();
    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));


    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        deq.remove(key);
        deq.addLast(key);
        return mp.get(key);

    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            // Update the value and move the key to the end of the deque
            mp.put(key, value);
            deq.remove(key);
            deq.addLast(key);
        } else {
            // Add the new key-value pair
            mp.put(key, value);
            deq.addLast(key);

            // Check if the size exceeds capacity and remove the least recently used key
            if (deq.size() > this.capacity) {
                int removedKey = deq.removeFirst();
                mp.remove(removedKey);
            }
        }

    }
}
