package com.holovin.holovin_lab1.DAO;

import com.holovin.holovin_lab1.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonDAO {

    //    int nextId = 0;
    //    List<Person> database = new ArrayList<>();


    List<Person> database = new ArrayList<>(List.of(
            new Person(0, "Egor", "email@Egor", 32),
            new Person(1, "Igor", "email@Igor", 22),
            new Person(2, "Eugene", "email@Eugene", 17),
            new Person(3, "Bohdan", "email@Bohdan", 67),
            new Person(4, "Ruslan", "email@Ruslan", 55)
    ));

    int nextId = 5;

    public List<Person> getAll() {
        return database;
    }

    public Person getPerson(int id) {
        return database.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .get();
    }

    public void add(Person person) {
        person.setId(nextId);
        nextId++;
        database.add(person);
    }

    public void update(Person person, int id) {
        database.add(id, person);
    }

    public void delete(int id) {
        database.remove(id);
    }

    public int getSize() {
        return database.size();
    }
}
