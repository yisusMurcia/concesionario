package Controller;

import Model.Car;
import View.CarView;

import java.util.Scanner;

public class CarController {
    private Car car;
    private Scanner scan;
    private CarView view;
    public CarController(Car car){
        this.car = car;
        scan = new Scanner(System.in);
        view = new CarView();
        int option;
        do {
            view.displayMenu();

            option = view.getOption();

            switch (option){
                case 1:

            }
        }while (option != 0);
    }

}
