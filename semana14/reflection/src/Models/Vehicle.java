package Models;

public class Vehicle {
    private String type;
    private String brand;

    public Vehicle(String type, String brand) {
        this.type = type;
        this.brand = brand;
    }

    private void showBrand(String brand) {
        System.out.println("This vehicle is a " + brand + " " + type + ".");
    }

    private static void showInfo(String brand) {
        System.out.println("Vehicle brand: " + brand);
    }
}
