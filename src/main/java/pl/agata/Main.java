package pl.agata;

import pl.agata.controller.CommandController;
import pl.agata.database.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(Statement statement = DataSource.getConnection().createStatement()) {

            statement.executeUpdate("INSERT INTO users(id,name,surname) VALUES (6,'Aga','Ra')");



        } catch (SQLException e) {
            e.printStackTrace();
        } ;

        //runMenu();

    }

    private static void runMenu() {
        String option;
        CommandController commandController = new CommandController();
        commandController.createCreateOption();
        commandController.createDeleteOption();
        commandController.createEditOption();
        commandController.createFindOption();
        commandController.createHelpOption();
        commandController.createNoneOption();

        do{
            System.out.println("Witaj w lubelskiej bibliotece!");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Wybierz opcje: ");
            option = scanner.nextLine().toLowerCase(Locale.ROOT);

            if(!option.equals("exit")) {
                try{
                    commandController.getOption(option);
                    commandController.getOption(option).execute();
                } catch(NullPointerException e){
                    System.out.println("Wpisz 'help' jeśli chcesz uzyskać pomoc.");
                }
            }
        } while(!option.equals("exit"));
    }
}
