public class Mammals extends Animal {
    String typeOfAnimal = "Mammal";

    public Mammals() {
    }

    public Mammals(int age, String name, Double weight, Boolean isHungry, Boolean isCageClear) {
        super(age, name, weight, isHungry, isCageClear);
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public String getAnimalData() {
        return super.getAnimalData() + ", Type of Animal: " + typeOfAnimal;
    }
}
