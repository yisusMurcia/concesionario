package View;

import Model.CarColor;
import Model.CarType;
import Model.FuelType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarCreationView {
    private int num;
    private final Scanner scan;

    public CarCreationView(Scanner scan){
        System.out.println("Lets create a new car model");
        this.scan = scan;
    }

    public String getCarBrand(){
        System.out.println("Please enter the car´s model");
        String brand;
        do{
            brand = scan.nextLine();
        }while (brand.isEmpty());
        return brand;
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

    public int selectCarType(){
        System.out.println("Please select the car type");
        int typeNum = 1;
        for(CarType type : CarType.values()){
            System.out.println(typeNum + " " + type);
            typeNum ++;
        }
        try {
            num = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Something fail, try again");
            num = selectCarType();
        }

        return num;
    }

    public int selectCarFuelType(){
        System.out.println("Please select the fuel type");
        int typeNum = 1;
        for(FuelType type : FuelType.values()){
            System.out.println(typeNum + " " + type);
            typeNum ++;
        }
        try {
            num = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Something fail, try again");
            num = selectCarFuelType();
        }

        return num;
    }

    public int selectColor(){
        System.out.println("Please select the car color");
        int typeNum = 1;
        for(CarColor type : CarColor.values()){
            System.out.println(typeNum + " " + type);
            typeNum ++;
        }

        try {
            num = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Something fail, try again");
            num = selectColor();
        }

        return num;
    }

    public boolean setAutomatic(){
        System.out.println("Is the car automatic? Enter the number");
        System.out.println("1 Yes");
        System.out.println("2 No");
        try{
            int num = scan.nextInt();
        }catch (InputMismatchException e){
            scan.next();
            System.out.println("Something fail, try again");
            setAutomatic();
        }
        return num == 1;
    }

    public void close(){
        System.out.println("Car creation succeed");
    }

    public void alertIntOutsideLength(){
        System.out.println("The integer isn´t in the length of the options");
    }
}
