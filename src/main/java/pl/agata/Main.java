package pl.agata;

import pl.agata.controller.CommendController;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        runMenu();

    }

    private static void runMenu() {
        String option;
        CommendController commendController = new CommendController();
        commendController.createCreateOption();
        commendController.createDeleteOption();
        commendController.createEditOption();
        commendController.createFindOption();
        commendController.createHelpOption();
        commendController.createNoneOption();

        do{
            System.out.println("Witaj w lubelskiej bibliotece!");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Wybierz opcje: ");
            option = scanner.nextLine().toLowerCase(Locale.ROOT);

            if(!option.equals("exit")) {
                try{
                    commendController.getOption(option);
                    commendController.getOption(option).execute();
                } catch(NullPointerException e){
                    System.out.println("Wpisz 'help' jeśli chcesz uzyskać pomoc.");
                }
            }
        } while(!option.equals("exit"));
    }
}
