package ru.eqour.spring.lab1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HelloController {

    private List<String> list;
    private Map<Integer, String> map;
    private final Random random = new Random();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "value", defaultValue = "null") String s) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(s);
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return list;
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "value", defaultValue = "null") String s) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(random.nextInt(), s);
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return map;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int listSize = list == null ? 0 : list.size();
        int mapSize = map == null ? 0 : map.size();
        return "ArrayList size: " + listSize + ", " + "HashMap size: " + mapSize;
    }
}
