package Model;

public enum FuelType {
    ELECTRIC, FUEL, BIOETHANOL, BIODIESEL, GAS;

    public static FuelType getFuelType(String name){
        for(FuelType fuelType: FuelType.values()){
            if(fuelType.name().equalsIgnoreCase(name)){
                return fuelType;
            }
        }
        throw new IllegalArgumentException("Fuel type not found");
    }
}
