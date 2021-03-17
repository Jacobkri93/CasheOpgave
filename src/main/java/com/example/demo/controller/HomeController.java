package com.example.demo.controller;

import com.example.demo.Cache;
import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
public class HomeController {

    Cache userCache = new Cache(new HashMap<Integer, String>());

    @GetMapping("/get-user-data")
    @ResponseBody
    public String userCache(@RequestParam Integer id) throws InterruptedException{
        if (!userCache.has(id)){
            User user = new User(id);
            String value = user.getDataSlow();

            userCache.set(id, value);
            userCache.setTTL(id, 40);

        }
        return userCache.get(id);
    }




    //Creating the com.example.demo.Cache
//        com.example.demo.Cache userCache = new com.example.demo.Cache(1, "2");

    //putting in keys and values (ID nr , firstName) to the userCache

//        userCache.put(1, "Jack");
//        userCache.put(2, "Jacob");
//        userCache.put(3, "Jessica");
//        userCache.put(4, "Jayden");
//        userCache.put(5, "Joshua");
//        userCache.put(6, "Jake");
//        userCache.put(7, "James");
//        userCache.put(8, "Jamie");
//        userCache.put(9, "Julia");
//        userCache.put(10, "Jasmine");
//        userCache.put(11, "Jaque");

    //total of 10 mappings in the cache Hashmap
    //Prints the hashmap out to the console
//        System.out.println("The Hashmap printed out:");
//        System.out.println(userCache);
//
//        System.out.println("----");
//        //get(key)?
//        System.out.println("Value of given key: 5");
//        System.out.println(userCache.get(5));
//
//        System.out.println("----");
//        //Adds two new keys and values to the list - using the set method
//        System.out.println();
//        System.out.println("Added two more mappings");
//        userCache.set(11, "Janick");
//        userCache.set(12, "Janus");
//
//
//        //Prints the list out after the set method
//        System.out.println(userCache);
//
//
//
//        System.out.println("----");
//        //has(key) returns a Boolean indicating if there is data for the key
//
//        System.out.println("Does the com.example.demo.Cache contain 15: "+userCache.has(15));
//        System.out.println("Does the com.example.demo.Cache contain 25: "+userCache.has(25));
//
//        System.out.println("----");
//        System.out.println("Now we delete the key and value of 4, Jayden, and show the updated cache:");
//        //delete(key) deletes the value and the key from the Hashmap
//        userCache.delete(4, "Jayden");
//        //Prints the map again after deleting
//        System.out.println(userCache);

}
