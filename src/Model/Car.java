package Model;


public class Car {
    private String brand;
    private int yearModel;
    private int motorCapacility;
    private FuelType fuelType;
    private CarType carType;
    private int amountOfDoors;
    private int speed;
    private int maxSpeed;
    private CarColor color;
    private int fine;

    public Car(String brand, int motorCapacility, FuelType fuelType, CarType carType, CarColor carColor, int maxSpeed){
        yearModel = 2025;
        speed = 0;
        fine = 0;

        this.brand = brand;
        this.motorCapacility = motorCapacility;
        this.fuelType = fuelType;
        this.color = carColor;
        this.carType = carType;
        this.maxSpeed = maxSpeed;
    }

    public int getFine() {
        return fine;
    }

    public int getSpeed() {
        return speed;
    }

    private void increasePine(){
        fine += 120000;
    }

    public void acelerate(int speedIncrease){
        speed += speedIncrease;
    }
}
