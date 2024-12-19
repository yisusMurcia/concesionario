package View;

import Model.CarType;

import java.awt.image.RescaleOp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarCreationView {
    private String brand;
    private int num;
    private final Scanner scan;

    public CarCreationView(){
        System.out.println("Lets create a new car model");
        scan = new Scanner(System.in);
    }

    public String getCarBrand(){
        System.out.println("Please enter the car´s model");
        return scan.nextLine();
    }

    public int getMotorCapability(){
        System.out.println("Enter the motor capability");

        try{
            num = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("SOmething go wrong, let´s do it again");
            num = getMotorCapability();
        }

        return num;
    }

    public int getNumOfDoors(){
        System.out.println("Please enter the number of doors");
        try{
            num = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Somethin go wrong, lets try again");
            num = getNumOfDoors();
        }

        return num;
    }

    public int getNumOfSeats(){
        System.out.println("Enter the car´s number of seats");

        try{
            num = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Something fail, try again");
            num = getNumOfSeats();
        }

        return num;
    }

    public double getMaxSpeed(){
        System.out.println("Enter the max speed limit");
        double maxSpeed;
        try{
            maxSpeed = scan.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Something fail, let´s do it again");
            scan.next();
            maxSpeed = getMaxSpeed();
        }

        return maxSpeed;
    }
}
