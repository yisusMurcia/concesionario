package View;

import Model.Car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarView {
    private final Scanner scan;

    public CarView(Scanner scan){
        this.scan = scan;
    }

    public static void displayCarInfo(Car car){
        System.out.println("""
                Brand:"""+ car.getBrand() + " " + car.getYearModel()+
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
                5. Get car speed
                6. Delete car
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

    public int getAcceleration(){
        int increaseSpeed;
        System.out.println("Enter the speed increase");
        try {
            increaseSpeed = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Something go wrong, try again");
            increaseSpeed = getAcceleration();
        }

        return increaseSpeed;
    }

    public int getDeceleration(){
        int decreaseSpeed;
        System.out.println("Enter the speed decrease");

        try{
            decreaseSpeed = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Something go wrong, try again");
            decreaseSpeed = getDeceleration();
        }

        return -decreaseSpeed;
    }

    public void displayAcceleration(Car car){
        System.out.println(car.getBrand()+ ": " + car.getSpeed() + "Km/h");
    }

    public void displayFineStatus(Car car){
        System.out.println(car.getFine() == 0? "Congratulations, the car has no debts": "Fine: " + car.getFine());
    }

    public void alertCarDeleted(){
        System.out.println("The car was deleted");
    }

    public void alertCarNoDeleted(){
        System.out.println("Something go wrong, the car wasn´t deleted");
    }

    public void alertNoValidOption(){
        System.out.println("You selected an invalid option or one in development");
    }
}
