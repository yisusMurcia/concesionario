package View;

import Model.Car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private final Scanner scan;

    public MainView(){
        scan = new Scanner(System.in);

        System.out.println("Welcome, this is our car dealer");
    }

    public void displayMenu(){
        System.out.println("""
                Menu:
                1. Create car model.
                2. Select a car model.
                3. Create a car model.
                \t0. Exit""");
    }

    public int getOption(){
        System.out.println("Please select an option");

        int option;
        try {
            option = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Somethin go wrong, lets try again");
            option = getOption();
        }

        return option;
    }

    public void alertNoValidOption(){
        System.out.println("You selected an invalid option or one in development");
    }

    public void displayCarModels(Car[] carsModels){
        for(Car car: carsModels){
            CarView.displayCarInfo(car);
        }
    }

    public String selectCar(Car[] cars){
        displayCarModels(cars);

        System.out.println("Please enter the car model");

        return scan.nextLine();
    }

    public void exit(){
        System.out.println("Thanks for using this car dealer");
        scan.close();
    }
}
