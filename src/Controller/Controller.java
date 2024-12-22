package Controller;

import Model.Car;
import  View.*;

import java.util.ArrayList;

public class Controller {
    private final MainView view;
    private final ArrayList<Car> carList = new ArrayList<>();

    public Controller(){
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
}
