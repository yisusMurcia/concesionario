package Model;

import java.awt.*;

public enum CarColor {
    WHITE, BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET;

    public static CarColor getColor(String color){
        for(CarColor carColor: CarColor.values()){
            if(carColor.toString().equalsIgnoreCase(color)){
                return carColor;
            }
        }

        throw new IllegalArgumentException("Invalid color");
    }
}
