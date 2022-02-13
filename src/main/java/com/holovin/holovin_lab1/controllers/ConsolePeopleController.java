package com.holovin.holovin_lab1.controllers;

import com.holovin.holovin_lab1.DAO.PersonDAO;
import com.holovin.holovin_lab1.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Controller
public class ConsolePeopleController {

    private final String CONSOLE_INFO = "ConsolePeopleController - info > ";
    private final String CONSOLE_ERROR = "ConsolePeopleController - error > ";
    private final String CONSOLE_INPUT = "ConsolePeopleController - input > ";
    private final String CONSOLE_OUT = "ConsolePeopleController - output > ";

    PersonDAO peopleDAO;
    Scanner scanner;

    @Autowired
    ConsolePeopleController(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
        scanner = new Scanner(System.in);
    }

    @PostConstruct
    void postConstruct() {
        System.out.println("\n\n\n");
        while (true) {
            try {
                readConsole();
            } catch (Exception ex) {
                System.out.println(CONSOLE_ERROR + ex.getMessage());
            }
        }
    }

    private void readConsole() {
        System.out.print("ConsolePeopleController - command > ");
        String line = scanner.nextLine();

        switch (line) {
            case "getAllPeople" -> getAllPeople();
            case "getPerson" -> getPerson();
            case "addNewPerson" -> addNewPerson();
            case "updatePerson" -> updatePerson();
            case "deletePerson" -> deletePerson();
            case "help" -> help();
            default -> noSuchCommand();
        }
    }

    private void getAllPeople() {
        System.out.println(CONSOLE_OUT + "size " + peopleDAO.getSize());
        System.out.println(CONSOLE_OUT + peopleDAO.getAll());
    }

    private void getPerson() {
        System.out.println(CONSOLE_INFO + "Write index of person");
        System.out.print(CONSOLE_INPUT);
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println(CONSOLE_OUT + peopleDAO.getPerson(id));
    }

    private void addNewPerson() {
        System.out.println(CONSOLE_INFO + "Write data in this format -- name email age");
        System.out.print(CONSOLE_INPUT);
        String[] arguments = scanner.nextLine().split(" ");
        Person personToAdd = new Person(
                arguments[0],
                arguments[1],
                Integer.parseInt(arguments[2])
        );

        peopleDAO.add(personToAdd);
        System.out.println(CONSOLE_OUT + "Success add new person " + personToAdd);
    }

    private void updatePerson() {
        System.out.println(CONSOLE_INFO + "Write data in this format -- id name email age");
        System.out.print(CONSOLE_INPUT);
        String[] arguments = scanner.nextLine().split(" ");
        Person personToUpdate = new Person(
                Integer.parseInt(arguments[0]),
                arguments[1],
                arguments[2],
                Integer.parseInt(arguments[3])
        );

        peopleDAO.update(personToUpdate, Integer.parseInt(arguments[0]));
        System.out.println(CONSOLE_OUT + "Success update person " + personToUpdate);
    }

    private void deletePerson() {
        System.out.println(CONSOLE_INFO + "Write index of person");
        System.out.print(CONSOLE_INPUT);
        int id = Integer.parseInt(scanner.nextLine());

        peopleDAO.delete(id);
        System.out.println(CONSOLE_OUT + "Success delete person with id " + id);
    }


    private void help() {
        System.out.println(CONSOLE_INFO +
                " You can write commands \"getAllPeople\" " +
                " || \"getPerson\" " +
                " || \"addNewPerson\" " +
                " || \"updatePerson\" " +
                " || \"deletePerson\" ");
    }

    private void noSuchCommand() {
        System.out.println(CONSOLE_ERROR + "No such command");
    }
}
