package pl.agata.service;

import pl.agata.basket.Basket;
import pl.agata.rental.Rental;
import pl.agata.user.Hash;
import pl.agata.user.User;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {

    private User user;
    private DBService dbService;
    private List<User> users;
    private List<Rental> rentals;
    private String name;
    private String surname;
    private String pass;
    private int quantityRentalBook;
    private Hash hash;

    public UserService(DBService dbService) {
        this.dbService = dbService;
        this.users = new ArrayList<>();

    }

    public User createUser(String name,String surname, String pass) throws SQLException, NoSuchAlgorithmException {
        hash = new Hash();
        String passHash = hash.toHexString(hash.getSHA(pass));
        user = new User(name,surname,passHash);
        int quantity=0;

        ResultSet resultSet = dbService.query("SELECT COUNT(*) FROM `users` u WHERE u.name='"+user.getName()+
                "' AND u.surname='"+user.getSurname()+"';");

        while(resultSet.next()) {
            quantity = resultSet.getInt("COUNT(*)");
            if (quantity != 0) {
                System.out.println("Jest już taki w bazie!");
                dbService.closeStatement();
                break;
            }
        }
        if(quantity==0){

            ResultSet resultSetID = dbService.query("SELECT MAX(id) FROM `users`;");
            while(resultSetID.next()){
                int id = resultSetID.getInt("MAX(id)")+1;
                user.setId(id);
            }
            dbService.dml("INSERT INTO `users`(`id`, `name`, `surname`, `password`) VALUES ("+user.getId()+",'"+user.getName()+"','"
                    +user.getSurname()+"','"+user.getPassword()+"');");
            dbService.dml("INSERT INTO `baskets`(`id`, `id_user`) VALUES ("+user.getId()+","+user.getId()+")");
            users.add(user);
            dbService.closeStatement();
            return user;
        }

        return null;
    }

    public User loginUser(String name, String surname, String pass) throws SQLException, NoSuchAlgorithmException {
        int id=0;
        hash = new Hash();
        String passHash = hash.toHexString(hash.getSHA(pass));
        user = new User(name,surname,passHash);

        ResultSet resultSet = dbService.query("SELECT id FROM `users` u WHERE u.name='"+user.getName()+
                "' AND u.surname='"+user.getSurname()+"' AND u.password='"+user.getPassword()+"';");
        if(resultSet.next()) {
            id = resultSet.getInt("id");
            user.setId(id);
            System.out.println(id);
            users.add(user);
            System.out.println("Jesteś zalogowany");
            dbService.closeStatement();
            return user;
        }
        else {
            System.out.println("Błędny login lub hasło!");
            return null;
        }
    }

    public User getLoginedUser(){
        return this.user;
    }

    public List<Rental> getRentalsUser(User user) throws SQLException {
        this.rentals = new ArrayList<>();
        int id =0;
        String title = "";
        String publisher = "";
        String author="";
        Date startDate = new Date();
        Date endDate = new Date();
        ResultSet resultSet = dbService.query("SELECT books.title, books.author,rentals.start,rentals.end FROM `rentals` " +
                "INNER JOIN books ON books.id = rentals.id_book WHERE id_user="+this.user.getId()+" AND is_return=0");
        while(resultSet.next()){
            title = resultSet.getString("title");
            author = resultSet.getString("author");
            startDate = resultSet.getDate("start");
            endDate = resultSet.getDate("end");
            Rental rental = new Rental(title,author,startDate,endDate);
            this.rentals.add(rental);
        }
        dbService.closeStatement();
        return rentals;
    }
    public int quantityRentalsUser(List<Rental> rentals ){
        quantityRentalBook = rentals.size();
        return quantityRentalBook;
    }


    public User getUserById(int id) throws SQLException {
        String name="";
        String surname ="";
        String pass="";

        ResultSet resultSet = dbService.query("SELECT * FROM `users` WHERE id="+id);
        while(resultSet.next()){
            name = resultSet.getString("name");
            surname= resultSet.getString("surname");
            pass = resultSet.getString("password");
            user = new User(name,surname,pass);
        }
        dbService.closeStatement();
        return user;
    }

}
