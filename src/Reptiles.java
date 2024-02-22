public class Reptiles extends Animal {
    String typeOfAnimal = "Reptile";

    public Reptiles() {
    }

    public Reptiles(int age, String name, Double weight, Boolean isHungry, Boolean isCageClear) {
        super(age, name, weight, isHungry, isCageClear);
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public String getAnimalData() {
        return super.getAnimalData() + ", Type of Animal: " + typeOfAnimal;
    }
}
