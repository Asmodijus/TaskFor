package lt.code.academy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {




    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        String line;
        do {
            main.menu();
            line = sc.nextLine();
            main.userSelection(sc,line , objectMapper , users);

        } while(!line.equals("4"));

    }



    private void userSelection(Scanner sc, String action , ObjectMapper objectMapper ,  List<User> users) {
        switch(action) {
            case "1" -> writeUser(objectMapper , sc , users);
            case "2" -> display(users);
            case "3" -> System.out.println("3");
            case "4"-> System.out.println("baige darba");
            default -> System.out.println("nera reiskmes");
        }
    }

    private void writeUser(ObjectMapper objectMapper , Scanner sc  , List<User> users)  {
        System.out.println("Iveskite varda");
        String yourName =sc.nextLine();
        System.out.println("Iveskite pavarda");
        String yourSurname =sc.nextLine();
        System.out.println("Iveskite id");
        String id =sc.nextLine();

        User user = new User(yourName,yourSurname,id);
        users.add(user);

        try {
            objectMapper.writeValue(new File("Users.json") , users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void display (List<User> users){
        System.out.println(users);
    }


    private void menu() {
        System.out.println("""
								   [1]. Enter user
								   [2]. Display user
								   [3] display user file
								   [4]. Exit
								   """);
    }
}
