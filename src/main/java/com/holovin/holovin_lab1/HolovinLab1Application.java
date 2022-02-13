package com.holovin.holovin_lab1;

import com.holovin.holovin_lab1.controllers.ConsolePeopleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolovinLab1Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(HolovinLab1Application.class, args);
        var consolePeopleController = (ConsolePeopleController) context.getBean("consolePeopleController");
        consolePeopleController.run();
    }
}
