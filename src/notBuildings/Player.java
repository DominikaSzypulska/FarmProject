package notBuildings;

import buildings.Farm;
import buildings.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    public static final List<Player> playerList = new ArrayList<>();
    private final String name;
    public List<Farm> farm = new ArrayList<>();
    public List<Plant> yourSeeds = new ArrayList<>();
    public List<Plant> yourPlantedPlants = new ArrayList<>();
    public List<Plant> yourPlants = new ArrayList<>();
    public List<Animal> yourAnimals = new ArrayList<>();
    public List<Building> yourBuildings = new ArrayList<>();
    public boolean isSilos = false;
    private double cash;

    Player(String name) {
        this.name = name;
        this.cash = 5000.0;
    }

    public static void newPlayer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type how many player:");
        int howManyPlayer = scan.nextInt();

        if (playerList.isEmpty()) {
            for (int i = 0; i < howManyPlayer; i++) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Type a name:");
                String name = scanner.nextLine();
                playerList.add(new Player(name));
            }
        }
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash += cash;
    }

    public String getName() {
        return name;
    }

    public boolean isFarm() {
        return !this.farm.isEmpty();
    }

    public String toString() {
        return "name: " + this.name +
                "\ncash: " + this.cash;
    }


}
