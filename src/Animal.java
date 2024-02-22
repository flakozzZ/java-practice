public class Animal {
    private int age;
    private String name;
    private Double weight;
    private Boolean isHungry;
    private Boolean isCageClear;

    public Animal() {
    }

    public Animal(int age, String name, Double weight, Boolean isHungry, Boolean isCageClear) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.isHungry = isHungry;
        this.isCageClear = isCageClear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getHungry() {
        return isHungry;
    }

    public void setHungry(Boolean hungry) {
        isHungry = hungry;
    }

    public Boolean getCageClear() {
        return isCageClear;
    }

    public void setCageClear(Boolean cageClear) {isCageClear = cageClear;}

    public void feed() {
        if (isHungry) {
            System.out.println("[INFO] " + name + " HAS BEEN FED.");
            isHungry = false;
        } else {
            System.out.println("[INFO] " +name + " IS NOT HUNGRY.");
        }
    }

    public void cleanCage() {
        if (isCageClear) {
            System.out.println("[INFO] CAGE OF " + name + " HAS BEEN CLEANED.");
        }
    }

    public String getAnimalData() {
        return  "Name: " + name +
                ", Age: " + age +
                ", Weight: " + weight +
                (isHungry ? ", Animal is hungry" : ", Animal is not hungry") +
                (isCageClear ? ", Cage is clear" : ", Cage is dirty");
    }
}
