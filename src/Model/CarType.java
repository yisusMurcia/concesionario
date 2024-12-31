package Model;

public enum CarType {
    CITY, SUBCOMPACT, COMPACT, FAMILY, EXECUTIVE, SUV;

    public static CarType getCarType(String carType){
        for (CarType type: CarType.values()){
            if (type.toString().equalsIgnoreCase(carType)){
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid car type");
    }
}
