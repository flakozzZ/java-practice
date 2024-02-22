import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo zoo = createZoo();

        int choice;

        do {
            System.out.println("-------------------------[MENU]-------------------------");
            System.out.println("[INFO] PRESS [1] TO SEARCH ANIMAL BY NAME");
            System.out.println("[INFO] PRESS [2] TO SEARCH ANIMAL BY AGE");
            System.out.println("[INFO] PRESS [3] TO DISPLAY ALL HUNGRY ANIMALS");
            System.out.println("[INFO] PRESS [4] TO DISPLAY ALL ANIMALS WITH DIRTY CAGE");
            System.out.println("[INFO] PRESS [8] TO DISPLAY ALL ANIMALS IN THE ZOO");
            System.out.println("[INFO] PRESS [0] TO EXIT");
            System.out.println("--------------------------------------------------------");


            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("[ALERT] INSERT NAME OF THE ANIMAL:");
                    sc.nextLine();
                    String name = sc.nextLine();
                    searchAnimalByName(zoo, name);
                    break;
                case 2:
                    System.out.println("[ALERT] INSERT MINIMUM AGE OF ANIMAL:");
                    int minAge = sc.nextInt();
                    System.out.println("[ALERT] INSERT MAXIMUM AGE OF ANIMAL:");
                    int maxAge = sc.nextInt();
                    searchAnimalByAge(zoo, minAge, maxAge);
                    break;
                case 3:
                    printHungryAnimals(zoo);
                    int feedChoice;
                    do {
                        System.out.println("[INFO] PRESS [5] TO FEED ALL HUNGRY ANIMALS");
                        System.out.println("[INFO] PRESS [7] TO EXIT TO MENU");
                        feedChoice = sc.nextInt();
                        if (feedChoice == 5) {
                            feedHungryAnimals(zoo);
                        } else if (feedChoice != 7) {
                            System.out.println("[ERROR] INVALID CHOICE. PLEASE TRY AGAIN.");
                        }
                    } while (feedChoice != 7);
                    break;

                case 4:
                    printAnimalsWithDirtyCage(zoo);
                    int cleanChoice;
                    do {
                        System.out.println("[INFO] PRESS [5] TO CLEAR ALL DIRTY CAGES");
                        System.out.println("[INFO] PRESS [7] TO EXIT TO MENU");
                        cleanChoice = sc.nextInt();
                        if (cleanChoice == 5) {
                            cleanDirtyCages(zoo);
                        } else if (cleanChoice != 7) {
                            System.out.println("[ERROR] INVALID CHOICE. PLEASE TRY AGAIN.");
                        }
                    } while (cleanChoice != 7);
                    break;

                case 8:
                    System.out.println("[INFO] LIST OF ALL ANIMALS:");
                    printAllAnimals(zoo);
                    break;

                case 0:
                    System.out.println("[INFO] Exiting program...");
                    break;
                default:
                    System.out.println("[ERROR] INVALID CHOICE. PLEASE TRY AGAIN.");
            }
        } while (choice != 0);
    }

    public static void searchAnimalByName(Zoo zoo, String name) {
        boolean found = false;

        for (Animal animal : zoo.animals) {
            if (animal != null && animal.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                System.out.println("[SUCCESS] " + animal.getAnimalData());
                found = true;
            }
        }

        if (!found) {
            System.out.println("[ERROR] NO ANIMAL FOUND WITH THE NAME: " + name);
        }
    }

    public static void printHungryAnimals(Zoo zoo) {
        boolean found = false;

        System.out.println("[INFO] LIST OF HUNGRY ANIMALS:");
        for(Animal animal : zoo.animals) {
            if (animal != null && animal.getHungry()) {
                System.out.println(animal.getAnimalData());
                found = true;
            }
        }

        if (!found) {
            System.out.println("[INFO] THERE ARE NO HUNGRY ANIMALS IN THE ZOO.");
        }
    }

    public static void printAnimalsWithDirtyCage(Zoo zoo) {
        boolean found = false;

        System.out.println("[INFO] LIST OF ANIMALS WITH DIRTY CAGE:");
        for(Animal animal : zoo.animals) {
            if (animal != null && animal.getCageClear()) {
                System.out.println(animal.getAnimalData());
                found = true;
            }
        }

        if (!found) {
            System.out.println("[INFO] ALL CAGES ARE CLEAR.");
        }
    }

    public static void searchAnimalByAge(Zoo zoo, int minAge, int maxAge) {
        boolean found = false;

        for (Animal animal : zoo.animals) {
            if (animal != null && animal.getAge() >= minAge && animal.getAge() <= maxAge) {
                System.out.println("[SUCCESS] " + animal.getAnimalData());
                found = true;
            }
        }

        if(!found) {
            System.out.println("[ERROR] NO ANIMAL FOUND WITHIN THE SPECIFIED AGE RANGE.");
        }
    }

    public static void feedHungryAnimals(Zoo zoo) {
        System.out.println("[INFO] FEEDING ALL HUNGRY ANIMALS...");
        for (Animal animal : zoo.animals) {
            if (animal != null && animal.getHungry()) {
                animal.feed();
                animal.setHungry(false);
            }
        }
        System.out.println("[SUCCESS] ALL ANIMALS HAS BEEN FED.");
    }

    public static void cleanDirtyCages(Zoo zoo) {
        System.out.println("[INFO] CLEANING ALL DIRTY CAGES...");
        for (Animal animal : zoo.animals) {
            if (animal != null && !animal.getCageClear()) {
                animal.cleanCage();
                animal.setCageClear(true);
            }
        }
        System.out.println("[SUCCESS] ALL CAGES ARE CLEANED.");
    }

    public static void printAllAnimals(Zoo zoo) {
        System.out.println("[INFO] DISPLAYING ALL ANIMALS IN THE ZOO...");
        for (Animal animal : zoo.animals) {
            if (animal != null) {
                System.out.println(animal.getAnimalData());
            }
        }
        System.out.println("[SUCCESS] ALL ANIMALS HAS BEEN DISPLAYED.");
    }

    public static Zoo createZoo() {
        Zoo zoo = new Zoo("National Zoo of the Republic of Kazakhstan", "Almaty", "Kazakhstan");

        // Creating mammals
        zoo.addAnimal(new Mammals(5, "Lion", 200.0, true, true));
        zoo.addAnimal(new Mammals(3, "Elephant", 1500.0, false, true));
        zoo.addAnimal(new Mammals(2, "Giraffe", 1200.0, true, false));
        zoo.addAnimal(new Mammals(6, "Tiger", 250.0, false, true));
        zoo.addAnimal(new Mammals(4, "Bear", 300.0, true, false));

        // Creating reptiles
        zoo.addAnimal(new Reptiles(3, "Snake", 5.0, true, true));
        zoo.addAnimal(new Reptiles(4, "Turtle", 2.0, false, true));
        zoo.addAnimal(new Reptiles(2, "Crocodile", 300.0, true, false));
        zoo.addAnimal(new Reptiles(1, "Lizard", 0.2, true, false));
        zoo.addAnimal(new Reptiles(5, "Komodo Dragon", 80.0, false, false));


        // Creating birds
        zoo.addAnimal(new Birds(4, "Eagle", 6.0, true, true));
        zoo.addAnimal(new Birds(2, "Parrot", 0.5, false, true));
        zoo.addAnimal(new Birds(3, "Penguin", 15.0, true, false));
        zoo.addAnimal(new Birds(1, "Owl", 1.0, false, false));
        zoo.addAnimal(new Birds(5, "Flamingo", 3.0, true, false));


        return zoo;
    }
}