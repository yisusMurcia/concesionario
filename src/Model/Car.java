package Model;

public class Car {
    private final String brand;
    private final int yearModel;
    private final int motorCapability;
    private final FuelType fuelType;
    private final CarType carType;
    private final CarColor color;
    private final int numOfSeats;
    private int speed;
    private final double maxSpeed;
    private int fine;
    private final int numOfDoors;
    private final boolean isAutomatic;
    private final int fineValue = 25;

    public Car(String brand, int motorCapability, FuelType fuelType, CarType carType, CarColor color, double maxSpeed, int numOfSeats, int numOfDoors, boolean isAutomatic){
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
        this.isAutomatic = isAutomatic;
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

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void accelerate(int speed){
        this.speed += speed;

        if(this.speed >= maxSpeed){
            this.speed = (int) maxSpeed;
            fine += fineValue;
        } else if (this.speed < 0) {
            this.speed = 0;
        }
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public int getFineValue() {
        return fineValue;
    }

    public void brake(){
        speed = 0;
    }

    public  double calculateTime(double distance){
        return distance / speed;
    }

}
