package pl.agata.service;

import pl.agata.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private User user;
    private DBService dbService;
    private List<User> users;
    private String name;
    private String surname;
    private String pass;

    public UserService(DBService dbService) {
        this.dbService = dbService;
        this.users = new ArrayList<>();
    }

    public User createUser() throws SQLException {
        System.out.println("Podaj imie!");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Podaj nazwisko!");
        surname = scanner.nextLine();
        System.out.println("Podaj password!");
        pass = scanner.nextLine();
        user = new User(name,surname,pass);
        int quantity=0;
        dbService.init();
        ResultSet resultSet = dbService.query("SELECT COUNT(*) FROM `users` u WHERE u.name='"+user.getName()+
                "' AND u.surname='"+user.getUsername()+"';");

        while(resultSet.next()) {
            quantity = resultSet.getInt("COUNT(*)");
            if (quantity != 0) {
                System.out.println("Jest już taki w bazie!");
                break;
            }
        }
        if(quantity==0){
            dbService.init();
            ResultSet resultSetID = dbService.query("SELECT MAX(id) FROM `users`;");
            while(resultSetID.next()){
                int id = resultSetID.getInt("MAX(id)")+1;
                user.setId(id);
            }
            dbService.dml("INSERT INTO `users`(`id`, `name`, `surname`, `password`) VALUES ("+user.getId()+",'"+user.getName()+"','"
                    +user.getUsername()+"','"+user.getPassword()+"');");
            users.add(user);
            return user;
        }
        return null;
    }

    public User loginUser() throws SQLException {
        System.out.println("Podaj imie!");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Podaj nazwisko!");
        surname = scanner.nextLine();
        System.out.println("Podaj password!");
        pass = scanner.nextLine();
        user = new User(name,surname,pass);
        int id=0;
        dbService.init();
        ResultSet resultSet = dbService.query("SELECT id FROM `users` u WHERE u.name='"+user.getName()+
                "' AND u.surname='"+user.getUsername()+"' AND u.password='"+user.getPassword()+"';");
        while(resultSet.next()) {
            id = resultSet.getInt("id");
            user.setId(id);
            users.add(user);
            System.out.println("Jesteś zalogowany");
            return user;
        }
        if(id==0){
            System.out.println("Błędny login lub hasło!");
        }
        return null;

    }

}
