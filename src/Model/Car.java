package Model;

public class Car {
    private String brand;
    private int yearModel;
    private int motorCapability;
    private FuelType fuelType;
    private CarType carType;
    private CarColor color;
    private int numOfSeats;
    private int speed;
    private final int maxSpeed;
    private int fine;
    private int numOfDoors;

    public Car(String brand, int motorCapability, FuelType fuelType, CarType carType, CarColor color, int maxSpeed, int numOfSeats, int numOfDoors){
        fine = 0;
        speed = 0;
        yearModel = 2025;
        this.maxSpeed = maxSpeed;

        this.brand = brand;
        this.motorCapability = motorCapability;
        this.fuelType = fuelType;
        this.carType = carType;
        this.color = color;
        this.numOfSeats = numOfSeats;
        this.numOfDoors = numOfDoors;
    }

    public int getFine() {
        return fine;
    }

    public int getSpeed() {
        return speed;
    }

    public String getBrand() {
        return brand;
    }

    public int getYearModel() {
        return yearModel;
    }

    public int getMotorCapability() {
        return motorCapability;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

    public CarColor getColor() {
        return color;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void acelerate(int speed){
        this.speed += speed;

        if(this.speed >= maxSpeed){
            this.speed = maxSpeed;
            fine += 25;
        } else if (this.speed < 0) {
            this.speed = 0;
        }
    }

    public void brake(){
        speed = 0;
    }

    public  double calculateTime(double distance){
        return distance / speed;
    }

}
