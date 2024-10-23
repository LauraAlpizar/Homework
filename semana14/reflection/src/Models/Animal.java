package Models;

public class Animal {
    private String species;
    private int age;

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    private void makeSound() {
        System.out.println("The " + species + " goes roar!");
    }

    private static void showInfo(String species) {
        System.out.println("Information about: " + species);
    }
}