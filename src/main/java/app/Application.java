package app;


import app.model.Age;
import app.model.Income;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class Application {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }


}
