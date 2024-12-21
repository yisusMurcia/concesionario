package View;

import Model.Car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarView {
    private int speed;
    private Scanner scan;

    public CarView(){
        scan = new Scanner(System.in);
    }

    public static void displayCarInfo(Car car){
        System.out.println("""
                Brand: """+ car.getBrand() + " " + car.getYearModel()+
                "\nMotor capability: " + car.getMotorCapability()+
                "\nFuel type: " + car.getFuelType()+
                "\nCar type: " + car.getCarType()+
                "\nColor: " + car.getColor()+
                "\nNumber of seats; " + car.getNumOfSeats()+
                "\nNumber of doors: " + car.getNumOfDoors()+
                "\nMax speed: " + car.getMaxSpeed()
        );
    }

    public static void displayBrand(Car car){
        System.out.println(car.getBrand());
    }

    public void displayMenu(){
        System.out.println("""
                Menu:
                1. Accelerate
                2. Decelerate
                3. Get fine status
                4. Display model info
                5. Delete car
                \t 0. Exit""");
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
}
