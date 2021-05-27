package notBuildings;

import interfaces.Buyable;
import interfaces.RandomNumberGeneratorDouble;
import interfaces.RandomNumberGeneratorInt;
import interfaces.Saleable;

import java.util.Scanner;

@SuppressWarnings("SuspiciousListRemoveInLoop")
public class Plant implements Buyable, Saleable {

    public final double value_kg;
    public final double costOfPlanting;
    public final int costOfProtectingFromParasite;
    public final double costOfHarvesting;
    public final String name;
    public final String product;
    public double costOfBuying;
    public int amountInInventory = 0;
    public int efficiency_ha;
    public int timeToGrow;


    public Plant(String name, double costOfPlanting, int costOfProtectingFromParasite, int efficiency_Ha, int timeToGrow, double costOfHarvesting, double costOfBuying, double value_KG, String product) {
        this.name = name;
        this.costOfPlanting = costOfPlanting;
        this.costOfProtectingFromParasite = costOfProtectingFromParasite;
        this.efficiency_ha = efficiency_Ha;
        this.timeToGrow = timeToGrow;
        this.costOfHarvesting = costOfHarvesting;
        this.costOfBuying = costOfBuying;
        this.value_kg = value_KG;
        this.product = product;

    }

    public Plant(String name, double costOfPlanting, int costOfProtectingFromParasite, int efficiency_ha, int timeToGrow, double costOfHarvesting, String product, int amountInInventory, double value_kg) {
        this.name = name;
        this.costOfPlanting = costOfPlanting;
        this.costOfProtectingFromParasite = costOfProtectingFromParasite;
        this.efficiency_ha = efficiency_ha;
        this.timeToGrow = timeToGrow;
        this.costOfHarvesting = costOfHarvesting;
        this.product = product;
        this.amountInInventory = amountInInventory;
        this.value_kg = value_kg;
    }

    public void plant(Player player) {

        System.out.println("How much you want to plant?");
        Scanner scannerAmount = new Scanner(System.in);
        int amount = scannerAmount.nextInt();

        for (int i = 0; i < player.yourSeeds.size(); i++) {
            if (player.yourSeeds.get(i).name.contains(this.name)) {
                if (player.yourSeeds.get(i).amountInInventory >= amount) {
                    if (player.farm.get(0).fieldsSlots >= amount) {
                        if (player.yourSeeds.get(i).amountInInventory == 0) {
                            player.yourSeeds.remove(i);
                            break;
                        }
                        if (!player.yourPlantedPlants.isEmpty()) {
                            one:
                            {
                                for (int n = 0; n < player.yourPlantedPlants.size(); n++) {
                                    if (player.yourPlantedPlants.get(n).name.contains(this.name)) {
                                        player.yourPlantedPlants.get(n).amountInInventory += amount;
                                        break one;
                                    }
                                }
                                player.yourPlantedPlants.add(new Plant(this.name, this.costOfPlanting, this.costOfProtectingFromParasite, this.efficiency_ha, this.timeToGrow, this.costOfHarvesting, this.product, amount, this.value_kg));
                            }
                        } else {
                            player.yourPlantedPlants.add(new Plant(this.name, this.costOfPlanting, this.costOfProtectingFromParasite, this.efficiency_ha, this.timeToGrow, this.costOfHarvesting, this.product, amount, this.value_kg));
                        }
                        System.out.println("You planted " + amount + " Ha of " + this.name);
                        player.yourSeeds.get(i).amountInInventory -= amount;
                        double value = player.yourSeeds.get(i).costOfPlanting * amount;
                        player.setCash(-value);
                        player.farm.get(0).fieldsSlots -= amount;

                        if (player.yourSeeds.get(i).amountInInventory == 0)
                            player.yourSeeds.remove(i);
                    } else {
                        System.out.println("You don't have enough field");
                    }
                }
            }
        }
    }

    public static void growingProcess(Player player) {
        if (!player.yourPlantedPlants.isEmpty()) {
            for (int i = 0; i < player.yourPlantedPlants.size(); i++) {
                if (player.yourPlantedPlants.get(i).timeToGrow != 0)
                    player.yourPlantedPlants.get(i).timeToGrow -= 1;
                else {
                    System.out.println("Plant: " + player.yourPlantedPlants.get(i).name + "is ready to harvest");
                }
            }
        }
    }

    public static void harvest(Player player) {
        if (!player.isSilos) {

            for (int i = 0; i < player.yourPlantedPlants.size(); i++) {
                double amount = player.yourPlantedPlants.get(i).amountInInventory * player.yourPlantedPlants.get(i).efficiency_ha;
                double value = player.yourPlantedPlants.get(i).costOfHarvesting * amount;

                if (player.yourPlantedPlants.get(i).timeToGrow <= 0) {
                    System.out.println("You successful harvest your plants");
                    if (player.yourPlantedPlants.get(i).name.equals("appleseed") || player.yourPlantedPlants.get(i).name.equals("pearSeed") || player.yourPlantedPlants.get(i).name.equals("cherrySeed") || player.yourPlantedPlants.get(i).name.equals("lemonSeed")) {
                        player.setCash(amount * player.yourPlantedPlants.get(i).value_kg);
                        player.yourPlantedPlants.get(i).timeToGrow = 52;
                    } else {

                        player.farm.get(0).fieldsSlots += player.yourPlantedPlants.get(i).amountInInventory;
                        player.setCash(amount * player.yourPlantedPlants.get(i).value_kg);
                        player.yourPlantedPlants.remove(i);
                        player.setCash(-value);
                    }
                }
            }
        } else if (player.isSilos) {
            for (int i = 0; i < player.yourPlantedPlants.size(); i++) {
                if (player.yourPlantedPlants.get(i).timeToGrow <= 0) {
                    player.yourPlants.add(new Plant(player.yourPlantedPlants.get(i).product,
                            player.yourPlantedPlants.get(i).costOfPlanting,
                            player.yourPlantedPlants.get(i).costOfProtectingFromParasite,
                            player.yourPlantedPlants.get(i).efficiency_ha,
                            player.yourPlantedPlants.get(i).timeToGrow,
                            player.yourPlantedPlants.get(i).costOfHarvesting,
                            player.yourPlantedPlants.get(i).product,
                            player.yourPlantedPlants.get(i).amountInInventory * player.yourPlantedPlants.get(i).efficiency_ha,
                            player.yourPlantedPlants.get(i).value_kg));


                    if (player.yourPlantedPlants.get(i).name.equals("appleseed") || player.yourPlantedPlants.get(i).name.equals("pearSeed") || player.yourPlantedPlants.get(i).name.equals("cherrySeed") || player.yourPlantedPlants.get(i).name.equals("lemonSeed")) {
                        player.yourPlantedPlants.get(i).timeToGrow = 52;

                    } else {
                        player.farm.get(0).fieldsSlots += player.yourPlantedPlants.get(i).amountInInventory;
                        player.yourPlantedPlants.remove(i);
                    }
                }
            }
        }
    }

    public static void protectFromParasite(Player player) {
        int insects = RandomNumberGeneratorInt.randomBetween(0, 100);

        for (int i = 0; i < player.yourPlantedPlants.size(); i++) {
            int value = 0;
            value += player.yourPlantedPlants.get(i).costOfProtectingFromParasite * player.yourPlantedPlants.get(i).amountInInventory;

            if (!player.yourPlantedPlants.isEmpty()) {
                if (player.getCash() > value) {
                    player.setCash(-value);

                } else if (insects == 5) {
                    int random = RandomNumberGeneratorInt.randomBetween(0, player.yourPlantedPlants.get(i).amountInInventory);
                    player.yourPlantedPlants.get(i).amountInInventory -= random;
                    if (player.yourPlantedPlants.get(i).amountInInventory == 0) {
                        player.yourPlantedPlants.remove(i);
                    }
                    player.farm.get(0).fieldsSlots += random;
                }
            }
        }
    }

    @Override
    public void sell(Player player) {

        System.out.println("How much you want to buy?");
        Scanner scannerAmount = new Scanner(System.in);
        int amount = scannerAmount.nextInt();

        for (int i = 0; i < player.yourPlants.size(); i++) {

            if (player.yourPlants.get(i).name.equals(this.product)) {
                if (player.yourPlants.get(i).amountInInventory >= amount) {

                    double valueOfTransaction = amount * this.value_kg * RandomNumberGeneratorDouble.randomBetween(0.8, 1.2);

                    System.out.println("You can sell " + this.name + " for " + valueOfTransaction + "\nDo you want to do this \n 1- Yes\n 2- no");

                    Scanner scannerYesOrNot = new Scanner(System.in);
                    int choicerYesOrNot = scannerYesOrNot.nextInt();

                    if (choicerYesOrNot == 1) {

                        player.setCash(valueOfTransaction);
                        System.out.println("You successful sell " + amount + " of " + this.name + " for" + valueOfTransaction);
                        player.yourPlants.get(i).amountInInventory -= amount;
                        if (player.yourPlants.get(i).amountInInventory == 0) {
                            player.yourPlants.remove(i);
                            break;
                        }

                    }

                } else if (player.yourPlants.get(i).amountInInventory < amount) {
                    System.out.println("You don't have enough " + this.name + " to sell");
                }
            } else {
                System.out.println("You don't have " + this.name + " to sell");
            }

        }
    }

    @Override
    public void buy(Player player) {

        System.out.println("How much you want to buy?");
        Scanner scannerAmount = new Scanner(System.in);
        int amount = scannerAmount.nextInt();

        if (player.getCash() >= this.value_kg) {
            double value = this.costOfBuying * amount;
            if (player.yourSeeds.isEmpty()) {
                player.yourSeeds.add(new Plant(this.name, this.costOfPlanting, this.costOfProtectingFromParasite, this.efficiency_ha, this.timeToGrow, this.costOfHarvesting, this.product, amount, this.value_kg));
                player.setCash(-value);

            } else {
                if (player.yourSeeds.size() == 1 && player.yourSeeds.get(0).name.equals(this.name)) {
                    player.yourSeeds.get(0).amountInInventory += amount;
                } else {
                    if (player.yourSeeds.size() == 1) {
                        player.yourSeeds.add(new Plant(this.name, this.costOfPlanting, this.costOfProtectingFromParasite, this.efficiency_ha, this.timeToGrow, this.costOfHarvesting, this.product, amount, this.value_kg));
                        player.setCash(-value);
                    } else
                        one:{
                            for (int i = 0; i < player.yourSeeds.size(); i++) {
                                if (player.yourSeeds.get(i).name.contains(this.name)) {
                                    player.yourSeeds.get(i).amountInInventory += amount;
                                    player.setCash(-value);
                                    break one;
                                }
                            }
                            player.yourSeeds.add(new Plant(this.name, this.costOfPlanting, this.costOfProtectingFromParasite, this.efficiency_ha, this.timeToGrow, this.costOfHarvesting, this.product, amount, this.value_kg));
                            player.setCash(-value);
                        }
                }
            }
            System.out.println("You bought " + amount + " " + this.name);
        } else {
            System.out.println("You don't have enough money!");
        }
    }

    public String toString() {
        return "\nName: " + this.name +
                "\nCost of Planting: " + this.costOfPlanting +
                "\nCost of protecting frm parasite: " + this.costOfProtectingFromParasite +
                "\nEfficiency for one hectare: " + this.efficiency_ha +
                "\nTime to grow: " + this.timeToGrow +
                "\nCost of harvesting: " + this.costOfHarvesting +
                "\nValue for one Kilogram: " + this.value_kg +
                " Amount: " + this.amountInInventory + "\n";

    }
}

