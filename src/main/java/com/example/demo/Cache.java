package com.example.demo;

import java.util.*;


public class Cache {

    HashMap<Integer, String> HashCache = new HashMap<>();

    public Cache(HashMap<Integer, String> hashCache) {
        this.HashCache = hashCache;
    }

    public void put(Integer key, String value) {

        HashCache.put(key, value);
    }

    public String get(Integer key) {
        return HashCache.get(key);
    }


//    public String get(int key) {
//        String value=HashCache.get(key);
//
//        return value;


    public void set(Integer key, String value) {
        HashCache.put(key, value);
    }


//    public void set(Integer key, String value) {
//        HashCache.putIfAbsent(key, value);
//    }


    public boolean has(int key) {
        if (HashCache.containsKey(key)) {
            return true;
        } else {
            return false;
        }
    }

    public void delete(Integer key) {
        HashCache.remove(key);

    }

    public void setTTL(Integer userId, int sec) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                delete(userId);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,(sec*1000));
    }



    @Override
    public String toString() {
        return "com.example.demo.Cache{" +
                "HashCache=" + HashCache;
    }
}
