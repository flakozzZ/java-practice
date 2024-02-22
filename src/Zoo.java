public class Zoo {
    private String name;
    private String city;
    private String country;
    public Animal[] animals = new Animal[100];
    private int countOfAnimals = 0;

    public Zoo() {
    }

    public Zoo(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addAnimal(Animal a) {
        if (countOfAnimals < 100) {
            animals[countOfAnimals] = a;
            countOfAnimals++;
        } else {
            System.out.println("Zoo is full!");
        }
    }

    public void printZooData() {
        System.out.println("Zoo: " + name + ", City: " + city + ", Country: " + country);
        System.out.println("Animals:");
        for (int i = 0; i < countOfAnimals; i++) {
            System.out.println((i + 1) + ". " + animals[i].getAnimalData());
        }
    }
}
