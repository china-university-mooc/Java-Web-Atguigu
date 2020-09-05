package com.itutry.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itutry.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    @Test
    public void test1() {
        Person person = new Person(1, "李商隐");
        Gson gson = new Gson();

        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);

        Person jsonObj = gson.fromJson(jsonStr, Person.class);
        System.out.println(jsonObj);
    }

    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "李商隐"));
        personList.add(new Person(2, "杜牧"));
        Gson gson = new Gson();

        String jsonStr = gson.toJson(personList);
        System.out.println(jsonStr);

        List<Person> jsonParsed = gson.fromJson(jsonStr, new PersonListType().getType());
        System.out.println(jsonParsed.get(0));
    }

    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "李商隐"));
        personMap.put(2, new Person(2, "杜牧"));
        Gson gson = new Gson();

        String jsonStr = gson.toJson(personMap);
        System.out.println(jsonStr);

//        Map<Integer, Person> jsonParsed = gson.fromJson(jsonStr, new PersonMapType().getType());
        Map<Integer, Person> jsonParsed = gson.fromJson(jsonStr, new TypeToken<Map<Integer, Person>>(){}.getType());
        System.out.println(jsonParsed.get(1));
    }
}
