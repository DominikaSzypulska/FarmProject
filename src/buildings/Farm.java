package buildings;

import interfaces.Buyable;
import notBuildings.Player;
import interfaces.RandomNumberGeneratorInt;
import interfaces.Saleable;

import java.util.Scanner;

public class Farm implements Buyable, Saleable {

    public final int maxFieldsSlots;
    public final String name;
    public final double price;
    public int fieldsSlots;


    public Farm(String name, double price, int fieldsSlots, int maxFieldsSlots) {
        this.name = name;
        this.price = price;
        this.fieldsSlots = fieldsSlots;
        this.maxFieldsSlots = maxFieldsSlots;
    }

    public String toString() {
        return " name: " + this.name +
                " price: " + this.price +
                " field Slots: " + this.fieldsSlots +
                " max field slots: " + this.maxFieldsSlots;
    }

    public void buyFarm(Player player) {

        if (player.getCash() >= this.price) {

            if (player.farm.isEmpty()) {
                player.setCash(-this.price);
                player.farm.add(new Farm(this.name, this.price, this.fieldsSlots, this.maxFieldsSlots));
                System.out.println("You bought: " + this.name);

            } else if (player.farm.get(0).name.equals(this.name)) {
                System.out.println("You already have: " + this.name);

            } else {
                player.setCash(-this.price);
                player.farm.remove(0);
                player.farm.add(new Farm(this.name, this.price, this.fieldsSlots, this.maxFieldsSlots));
                System.out.println("You bought: " + this.name);
            }

        } else {
            System.out.println("You don't have enough money to buy: " + this.name);
        }
    }

    /*Method is used for selling field in farm*/
    @Override
    public void sell(Player player) {

        System.out.println("You have " +player.farm.get(0).fieldsSlots + " from " + player.farm.get(0).maxFieldsSlots);

        System.out.println("How much you want to sell?");
        Scanner scannerAmount = new Scanner(System.in);
        int amount = scannerAmount.nextInt();

        double valueOfTransaction = amount * RandomNumberGeneratorInt.randomBetween(800, 1000);
        if (player.farm.get(0).name.equals(this.name)) {
            if (this.fieldsSlots > amount) {
                player.setCash(valueOfTransaction);
                this.fieldsSlots -= amount;
            } else {
                System.out.println("You don't have enough field to sell");
            }
        } else {
            System.out.println("You don't any have farm");
        }
    }

    /*Method is used for buying field in farm*/
    @Override
    public void buy(Player player) {

        System.out.println("You have " +player.farm.get(0).fieldsSlots + " from " + player.farm.get(0).maxFieldsSlots);

        System.out.println("How much you want to buy?");
        Scanner scannerAmount = new Scanner(System.in);
        int amount = scannerAmount.nextInt();

        double valueOfTransaction = amount * RandomNumberGeneratorInt.randomBetween(800, 1000);

        if (player.getCash() >= valueOfTransaction && player.farm != null) {
            if (player.farm.get(0).name.equals(this.name)) {
                if (this.maxFieldsSlots >= amount && player.getCash() >= valueOfTransaction && this.fieldsSlots < this.maxFieldsSlots) {
                    this.fieldsSlots += amount;
                    player.setCash(-valueOfTransaction);
                    System.out.println("You successful expand your farm by " + amount + " new Ha of field");
                } else {
                    System.out.println("You don't have enough space for new field");
                }
            } else {
                System.out.println("You don't have farm to expand");
            }
        } else {
            System.out.println("You don't have enough money for new field!");
        }
    }
}

