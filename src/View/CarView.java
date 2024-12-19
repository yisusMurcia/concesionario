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
                Brand:"""+ car.getBrand() + " " + car.getYearModel()+
                "Motor capability: " + car.getMotorCapability()+
                "Fuel type: " + car.getFuelType()+
                "Car type: " + car.getCarType()+
                "Color: " + car.getColor()+
                "Number of seats; " + car.getNumOfSeats()+
                "Number of doors: " + car.getNumOfDoors()+
                "Max speed: " + car.getMaxSpeed()
        );
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
