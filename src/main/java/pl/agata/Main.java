package pl.agata;

import pl.agata.controller.CommandController;
import pl.agata.service.DBService;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        
        try {
            runMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runMenu() throws SQLException {
        DBService dbService = new DBService("jdbc:mysql://localhost/library","root","");
        dbService.configure();
        String option;
        CommandController commandController = new CommandController(dbService);
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
                    commandController.getOption(option).execute(dbService);
                } catch(NullPointerException e){
                    System.out.println("Wpisz 'help' jeśli chcesz uzyskać pomoc.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } while(!option.equals("exit"));
    }
}
