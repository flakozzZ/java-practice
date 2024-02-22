public class Birds extends Animal {
    String typeOfAnimal = "Bird";

    public Birds() {
    }

    public Birds(int age, String name, Double weight, Boolean isHungry, Boolean isCageClear) {
        super(age, name, weight, isHungry, isCageClear);
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public String getAnimalData() {
        return super.getAnimalData() + ", Type of Animal: " + typeOfAnimal;
    }
}
