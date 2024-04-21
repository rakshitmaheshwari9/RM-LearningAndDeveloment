package StackAndQueue.stackImplementation;

import java.util.*;

public class LFUCache {

    int capacity;
    Map<Integer, Integer> map;
    Map<Integer, Integer> mapCount;
    Deque<Integer> deque;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.mapCount = new HashMap<>();
        this.deque = new LinkedList<>();

    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
//        [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
//        1,-1,3,-1,3,4  ---->> this one should be  the answer rahul khichar

    }

    public int get(int key) {

        if (!map.containsKey(key)) return -1;
        int value = map.get(key);
        mapCount.put(key, mapCount.get(key) + 1);
        deque.remove(key);

        Stack<Integer> st = new Stack<>();

        while (!deque.isEmpty() && mapCount.get(deque.getLast()) > mapCount.get(key)) {
            st.add(deque.removeLast());
        }

        while (!st.isEmpty()) {
            deque.addLast(st.pop());
        }

        return value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            mapCount.put(key, 0);
        }

        map.put(key, value);

        mapCount.put(key, mapCount.get(key) + 1);
        deque.remove(key);

        Stack<Integer> st = new Stack<>();

        while (!deque.isEmpty() && mapCount.get(deque.getLast()) > mapCount.get(key)) {
            st.add(deque.removeLast());
        }

        while (!st.isEmpty()) {
            deque.addLast(st.pop());
        }

        if (deque.size() > this.capacity) {
            int key2 = deque.removeFirst();
            map.remove(key2);
            mapCount.remove(key2);
        }

    }
}
