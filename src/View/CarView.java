package View;

import Model.Car;

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
                1. Acelerate
                2. Get fine status
                3. Display model info
                4. Delete car
                \t 0. Exit""");
    }
}
