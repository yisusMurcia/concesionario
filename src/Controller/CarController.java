package Controller;

import Model.Car;
import View.CarView;


public class CarController {
    private final Car car;
    private final CarView view;
    private final Controller control;
    public CarController(Car car, Controller control){
        this.car = car;
        this.control = control;
        view = new CarView(control.getView().getScan());
        int option;
        do {
            view.displayMenu();

            option = view.getOption();

            switch (option){
                case 1:
                    car.accelerate(view.getAcceleration());
                    view.displayAcceleration(car);
                    break;
                case 2:
                    car.accelerate(view.getDeceleration());
                    view.displayAcceleration(car);
                    break;
                case 3:
                    view.displayFineStatus(car);
                    break;
                case 4:
                    CarView.displayCarInfo(car);
                    break;
                case 5:
                    view.displayAcceleration(car);
                case 6:
                    deleteCar();
                    option = 0;
                    break;
                case 0:
                    break;
                default:
                    view.alertNoValidOption();
            }
        }while (option != 0);
    }


    private void deleteCar(){
        if(control.deleteCar(car)){
            view.alertCarDeleted();
        }else{
            view.alertCarNoDeleted();
        }
    }
}
