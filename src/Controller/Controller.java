package Controller;

import Model.Car;
import Model.CarColor;
import Model.CarType;
import Model.FuelType;
import  View.*;

import java.io.*;
import java.util.ArrayList;

public class Controller {
    private final MainView view;
    private ArrayList<Car> carList = new ArrayList<>();

    public Controller(){

        File file = new File("cars.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
                System.out.println("File created");
            }else{
                carList = readCars();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        view = new View.MainView();

        int option;
        do{
            view.displayMenu();

            option = view.getOption();

            switch (option){
                case 0:
                    view.exit();
                    break;
                case 1:
                    for(Car car: carList){
                        CarView.displayCarInfo(car);
                    }
                    break;
                case 2:
                    Car car = getCar();
                    if(car == null){
                        view.alertErrorSelectingCar();
                    }else{
                        new CarController(car, this);
                    }
                    break;
                case 3:
                    new CarCreationController(this);
                    break;
                default:
                    view.alertNoValidOption();
            }
        }while (option != 0);
    }

    public void addCar(Car car){
        carList.add(car);
    }

    private Car getCar(){
        for(Car car: carList){
            CarView.displayBrand(car);
        }
        String brandName = view.selectCar(carList);
        for(Car car : carList){
            if(car.getBrand().equalsIgnoreCase(brandName)){
                return car;
            }
        }

        return null;
    }

    public boolean deleteCar(Car car){
        for(Car carObj: carList){
            if(carObj.getBrand().equals(car.getBrand())){
                carList.remove(carObj);
                return  true;
            }
        }

        return false;
    }

    public MainView getView(){
        return this.view;
    }

    public void saveCar(Car car){
        try{
            FileWriter fileWriter = new FileWriter("cars.txt", true);
            fileWriter.write(car.getBrand() + "\n");
            fileWriter.write(car.getMotorCapability() + "\n");
            fileWriter.write(car.getFuelType() + "\n");
            fileWriter.write(car.getCarType() + "\n");
            fileWriter.write(car.getColor() + "\n");
            fileWriter.write(car.getNumOfSeats() + "\n");
            fileWriter.write(car.getNumOfDoors() + "\n");
            fileWriter.write(car.getMaxSpeed() + "\n");
            fileWriter.write(car.isAutomatic() + "\n");
            fileWriter.close();
            System.out.println("Car saved");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Car> readCars(){
        ArrayList<Car> cars = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("cars.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                String brand = line;
                int motorCapability = Integer.parseInt(bufferedReader.readLine());
                String fuelType = bufferedReader.readLine();
                String carType = bufferedReader.readLine();
                String color = bufferedReader.readLine();
                int numOfSeats = Integer.parseInt(bufferedReader.readLine());
                int numOfDoors = Integer.parseInt(bufferedReader.readLine());
                double maxSpeed = Double.parseDouble(bufferedReader.readLine());
                boolean automatic = Boolean.parseBoolean(bufferedReader.readLine());

                Car car = new Car(brand, motorCapability, FuelType.getFuelType(fuelType), CarType.getCarType(carType), CarColor.getColor(color), maxSpeed, numOfSeats, numOfDoors, automatic);
                cars.add(car);
            }
            bufferedReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return cars;
    }
}
