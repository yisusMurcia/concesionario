package View;

import Model.Car;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private final Scanner scan;

    public MainView(){
        scan = new Scanner(System.in);

        System.out.println("Welcome, this is our car dealer");
    }

    public Scanner getScan() {
        return scan;
    }

    public void displayMenu(){
        System.out.println("""
                Menu:
                1. Display car models.
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
            scan.nextLine();
            System.out.println("Something go wrong, lets try again");
            option = getOption();
        }
        return option;
    }

    public void alertNoValidOption(){
        System.out.println("You selected an invalid option or one in development");
    }

    public String selectCar(ArrayList<Car> carArrayList){
        System.out.println("car brands: ");
        for(Car car: carArrayList){
            CarView.displayBrand(car);
        }
        String brand;
        do {
            System.out.println("Please enter the car model");
            brand = scan.nextLine();
        }while (brand == null || brand.isEmpty());

        return brand;
    }

    public void alertErrorSelectingCar(){
        System.out.println("The car selected isn´t valid");
    }

    public void exit(){
        System.out.println("Thanks for using this car dealer");
        scan.close();
    }
}
