package Controller;

import Model.Car;
import Model.CarColor;
import Model.CarType;
import Model.FuelType;
import View.CarCreationView;

public class CarCreationController {
    private final CarCreationView view;
    public CarCreationController(Controller control){
        view = new CarCreationView(control.getView().getScan());
        Car car = new Car(view.getCarBrand(), view.getMotorCapability(), getFuelType(), getCarType(), getCarColor(), view.getMaxSpeed(), view.getNumOfSeats(), view.getNumOfDoors(), view.setAutomatic());
        control.addCar(car);

        view.close();
    }

    private CarType getCarType(){
        int num = view.selectCarType();
        while (num > CarType.values().length){
            view.alertIntOutsideLength();
            num = view.selectCarType();
        }

        return CarType.values()[num - 1];
    }

    private FuelType getFuelType(){
        int num = view.selectCarFuelType();
        while (num > FuelType.values().length){
            view.alertIntOutsideLength();
            num = view.selectCarFuelType();
        }

        return FuelType.values()[num - 1];
    }

    private CarColor getCarColor(){
        int num = view.selectColor();
        while (num > CarColor.values().length){
            view.alertIntOutsideLength();
            num = view.selectColor();
        }

        return CarColor.values()[num - 1];
    }
}
