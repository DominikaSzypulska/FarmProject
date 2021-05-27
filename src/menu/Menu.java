package menu;

import buildings.*;
import interfaces.RandomNumberGeneratorInt;
import notBuildings.Animal;
import notBuildings.Plant;
import notBuildings.Player;
import notBuildings.World;

import java.util.Scanner;

public class Menu {

    /* PLANTS */
    static Plant cornSeed = new Plant("cornSeed", 25.0, 10, RandomNumberGeneratorInt.randomBetween(200, 300), 20, 1.25, 200, 20, "corn");
    static Plant carrotSeed = new Plant("carrotSeed", 33.50, 11, RandomNumberGeneratorInt.randomBetween(100, 150), 50, 2.3, 300, 30, "carrot");
    static Plant sunflowerSeed = new Plant("sunflowerSeed", 22.0, 15, RandomNumberGeneratorInt.randomBetween(100, 220), 30, 0.25, 200, 20, "sunflower");
    static Plant potatoSeed = new Plant("potatoSeed", 13.0, 8, RandomNumberGeneratorInt.randomBetween(150, 200), 35, 4.3, 400, 40, "potato");
    static Plant wheatSeed = new Plant("wheatSeed", 43.40, 8, RandomNumberGeneratorInt.randomBetween(180, 200), 42, 2, 600, 60, "wheat");
    static Plant broccoliSeed = new Plant("broccoliSeed", 13.0, 7, RandomNumberGeneratorInt.randomBetween(100, 120), 25, 3, 700, 70, "broccoli");
    static Plant onionSeed = new Plant("onionSeed", 23.0, 12, RandomNumberGeneratorInt.randomBetween(100, 120), 30, 5.25, 200, 20, "onion");
    static Plant lettuceSeed = new Plant("lettuceSeed", 26.60, 5, RandomNumberGeneratorInt.randomBetween(160, 200), 20, 2.25, 200, 20, "lettuce");
    static Plant tomatoSeed = new Plant("tomatoSeed", 33.0, 9, RandomNumberGeneratorInt.randomBetween(100, 200), 33, 3.3, 400, 40, "tomato");
    /* fruits */
    static Plant appleSeed = new Plant("appleSeed", 300.0, 20, RandomNumberGeneratorInt.randomBetween(30, 50), 100, 0.3, 1000, 10, "apple");
    static Plant pearSeed = new Plant("pearSeed", 250.0, 22, RandomNumberGeneratorInt.randomBetween(35, 55), 120, 0.25, 2000, 20, "pear");
    static Plant cherrySeed = new Plant("cherrySeed", 400.0, 21, RandomNumberGeneratorInt.randomBetween(40, 60), 130, 0.25, 3000, 30, "cherry");
    static Plant melonSeed = new Plant("melonSeed", 50.0, 16, RandomNumberGeneratorInt.randomBetween(80, 110), 40, 4.3, 200, 20, "melon");
    static Plant watermelonSeed = new Plant("watermelonSeed", 55.50, 12, RandomNumberGeneratorInt.randomBetween(90, 200), 47, 5.25, 250, 30, "watermelon");
    static Plant lemonSeed = new Plant("lemonSeed", 27.0, 5, RandomNumberGeneratorInt.randomBetween(100, 200), 60, 0.25, 200, 20, "lemon");
    static Plant strawberriesSeed = new Plant("strawberriesSeed", 60.0, RandomNumberGeneratorInt.randomBetween(100, 200), 200, 34, 6.25, 500, 50, "strawberries");
    /*ANIMALS*/
    static Animal cow = new Animal("cow", 1000.0, 10.0, 200.0, 0.2, 2.0, "corn", "milk", "Cowshed", false);
    static Animal sheep = new Animal("sheep", 1200.0, 10.0, 250.0, 0.1, 2.0, "wheat", "wool", "Stable", false);
    static Animal pig = new Animal("pig", 800.0, 10.0, 180.0, 0.30, 2.0, "carrot", null, "Pigsty", false);
    static Animal chicken = new Animal("chicken", 200.0, 0.2, 50.0, 0.1, 2.0, "sunflower", "egg", "Chickencoop", false);
    static Animal dog = new Animal("dog", 2000.0, 1.0, 100.0, 0.2, 2.0, "dogFood", false);
    static Animal cat = new Animal("cat", 2200.0, 0.5, 80.0, 0.1, 2.0, "catFood", false);
    /*BUILDINGS*/
    static Building smallCowshed = new Cowshed("smallCowshed", 1000.0, 1.0, 10, "Cowshed");
    static Building smallPigsty = new Pigsty("smallPigsty", 1000.0, 1.0, 10, "Pigsty");
    static Building smallStable = new Stable("smallStable", 1000.0, 1.0, 10, "Stable");
    static Building smallChickencoop = new Chickencoop("smallChickencoop", 1000.0, 1.0, 10, "Chickencoop");

    static Building mediumCowshed = new Cowshed("mediumCowshed", 5000.0, 1.0, 30, "Cowshed");
    static Building mediumPigsty = new Pigsty("mediumPigsty", 5000.0, 1.0, 30, "Pigsty");
    static Building mediumStable = new Stable("mediumStable", 5000.0, 1.0, 30, "Stable");
    static Building mediumChickencoop = new Chickencoop("mediumChickencoop", 5000.0, 1.0, 30, "Chickencoop");

    static Building bigCowshed = new Cowshed("bigCowshed", 10000.0, 1.0, 100, "Cowshed");
    static Building bigPigsty = new Pigsty("bigPigsty", 10000.0, 1.0, 100, "Pigsty");
    static Building bigStable = new Stable("bigStable", 10000.0, 1.0, 100, "Stable");
    static Building bigChickencoop = new Chickencoop("bigChickencoop", 1000.0, 1.0, 100, "Chickencoop");

    static Silos silos = new Silos("silos", 2000.0);
    /*FARMS*/
    static Farm oldFarm = new Farm("Old Farm", RandomNumberGeneratorInt.randomBetween(1000, 1500), RandomNumberGeneratorInt.randomBetween(2, 5), 10);
    static Farm startedFarm = new Farm("startedFarm", RandomNumberGeneratorInt.randomBetween(3000, 4000), RandomNumberGeneratorInt.randomBetween(5, 10), 20);
    static Farm advancedFarm = new Farm("advancedFarm", RandomNumberGeneratorInt.randomBetween(5000, 8000), RandomNumberGeneratorInt.randomBetween(10, 15), 30);
    static Farm highTierFarm = new Farm("highTierFarm", RandomNumberGeneratorInt.randomBetween(10000, 15000), RandomNumberGeneratorInt.randomBetween(20, 25), 40);
    static Farm ultimateFarm = new Farm("ultimateFarm", RandomNumberGeneratorInt.randomBetween(200000, 300000), RandomNumberGeneratorInt.randomBetween(30, 40), 100);


    public static void mainMenu() {
        int menuChoice;
        int week;
        int year = 2020;
        for (week = 1; week > 0; week++) {

            /*MENU*/
            System.out.println("Year: " + year + " Week:" + week);

            for (int whichPlayer = 0; whichPlayer < Player.playerList.size(); whichPlayer++) {
                do {
                    System.out.println("\n\n");
                    System.out.println("---------------------");
                    System.out.println("Turn: " + Player.playerList.get(whichPlayer).toString());
                    System.out.println("---------------------");
                    System.out.println("MENU");
                    System.out.println("---------------------");
                    System.out.println("1 - SHOP ");
                    System.out.println("2 - Statistic of yours Farms");
                    System.out.println("3 - Manage your farms:");
                    System.out.println("---------------------");
                    System.out.println("4 - End a week");

                    Scanner scannerMenu = new Scanner(System.in);
                    menuChoice = scannerMenu.nextInt();
                    switch (menuChoice) {

                        case 1: /*SHOP*/
                            Menu.shopMenu(Player.playerList.get(whichPlayer));
                            break;

                        case 2: /*Statistic of your farm*/
                            Menu.farmStatistic(Player.playerList.get(whichPlayer));
                            break;

                        case 3: /*Manage your farm*/
                            Menu.farmManage(Player.playerList.get(whichPlayer));
                            break;
                    }
                }
                while (menuChoice < 4);
                if (menuChoice >= 4) {
                    break;
                }

                Plant.growingProcess(Player.playerList.get(whichPlayer));
                Plant.protectFromParasite(Player.playerList.get(whichPlayer));
                World.disasters(Player.playerList.get(whichPlayer), week);
                Animal.growingProcess(Player.playerList.get(whichPlayer));
                Animal.reproduction(Player.playerList.get(whichPlayer));
                Animal.productionItem(Player.playerList.get(whichPlayer));

                World.isWinner(Player.playerList.get(whichPlayer));
            }
            if (week == 52) {
                week = 0;
                year++;
            }
        }

    }

    public static void shopMenu(Player player) {

        System.out.println("---------------------");
        System.out.println("Welcome in the Shop");
        System.out.println("---------------------");
        System.out.println("1 - Buy new Farm");
        System.out.println("2 - Buy new Buildings");
        System.out.println("3 - Buy more field");
        System.out.println("4 - Buy Plants");
        System.out.println("5 - Buy Animals");
        System.out.println("---------------------");
        System.out.println("6 - Sell Plants");
        System.out.println("7 - Sell Animals");
        System.out.println("8 - Sell Field");
        System.out.println("---------------------");
        System.out.println("9 - Return");
        System.out.println("---------------------");

        switch (Menu.choiceMenu()) {
            case 1:
                System.out.println("---------------------");
                System.out.println("Buy new Farm");
                System.out.println("---------------------");
                Menu.whichFarm().buyFarm(player);
                break;

            case 2:
                System.out.println("---------------------");
                System.out.println(" Buy new Buildings");
                System.out.println("---------------------");
                Menu.whichBuilding().buy(player);
                break;

            case 3: {
                System.out.println("---------------------");
                System.out.println("Buy more field");
                System.out.println("---------------------");
                player.farm.get(0).buy(player);//check
                break;
            }
            case 4:
                System.out.println("---------------------");
                System.out.println("Buy Plants");
                System.out.println("---------------------");
                Menu.whichPlant().buy(player);
                break;

            case 5:
                System.out.println("---------------------");
                System.out.println("Buy Animals");
                System.out.println("---------------------");
                Menu.whichAnimal().buy(player);
                break;

            case 6:
                System.out.println("---------------------");
                System.out.println("Your plants: " + player.yourPlants);
                System.out.println("---------------------");
                System.out.println("Sell Plants");
                System.out.println("---------------------");
                Menu.whichPlant().sell(player);
                break;

            case 7:
                System.out.println("---------------------");
                System.out.println("Yours animals" + player.yourAnimals);
                System.out.println("---------------------");
                System.out.println("Sell Animals");
                System.out.println("---------------------");
                Menu.whichAnimal().sell(player);
                break;

            case 8:
                System.out.println("---------------------");
                System.out.println("Sell Field");
                System.out.println("---------------------");
                player.farm.get(0).sell(player);
        }
    }

    public static void farmStatistic(Player player) {

        System.out.println("---------------------");
        System.out.println("Statistic of yours Farms");
        System.out.println("---------------------");
        System.out.println("1 - Your farm");
        System.out.println("2 - List of your buildings");
        System.out.println("3 - List of your animals");
        System.out.println("4 - List of your seeds/saplings");
        System.out.println("5 - List of your planted plants");
        System.out.println("6 - List of your plants");
        System.out.println("7 - Silos status");
        System.out.println("---------------------");
        System.out.println("0 - Return");

        switch (Menu.choiceMenu()) {
            case 1:
                System.out.println("Your farm:");
                System.out.println(player.farm);
                break;
            case 2:
                System.out.println("List of your buildings:");
                System.out.println(player.yourBuildings);
                break;
            case 3:
                System.out.println("List of your Animals:");
                System.out.println(player.yourAnimals);
                break;
            case 4:
                System.out.println("List of your Seeds:");
                System.out.println(player.yourSeeds);
                break;
            case 5:
                System.out.println("List of your planted Seeds:");
                System.out.println(player.yourPlantedPlants);
                break;
            case 6:
                System.out.println("List of your plants:");
                System.out.println(player.yourPlants);
                break;
            case 7:
                System.out.println("Silos: " + player.isSilos);
                break;
        }
    }

    public static void farmManage(Player player) {

        System.out.println("---------------------");
        System.out.println("Manage your farms:");
        System.out.println("---------------------");
        System.out.println("1 - plant seeds/saplings");
        System.out.println("2 - harvest ready plants");
        System.out.println("3 - feed animals");
        System.out.println("---------------------");
        System.out.println("0 - Return");

        switch (Menu.choiceMenu()) {
            case 1:
                System.out.println("---------------------");
                System.out.println("Your seeds: " + player.yourSeeds);
                System.out.println("---------------------");
                System.out.println("which plant you want to plant:");
                System.out.println("---------------------");
                Menu.whichPlant().plant(player);
                break;

            case 2:
                Plant.harvest(player);
                break;
            case 3:
                Animal.feed(player);
                break;
        }
    }

    public static int choiceMenu() {
        Scanner scannerMenu = new Scanner(System.in);
        int choiceMenu = scannerMenu.nextInt();
        return choiceMenu;
    }

    public static Plant whichPlant() {

        System.out.println("---------------------");
        System.out.println("1 - cornSeed");
        System.out.println("2 - carrotSeed");
        System.out.println("3 -  sunflowerSeed");
        System.out.println("4 -  potatoSeed.");
        System.out.println("5 -  wheatSeed. ");
        System.out.println("6 -  broccoliSeed.");
        System.out.println("7 -  onionSeed. ");
        System.out.println("8 -  lettuceSeed.");
        System.out.println("9 -  tomatoSeed.");
        System.out.println("10 - appleSeed.");
        System.out.println("11 - pearSeed. ");
        System.out.println("12 - cherrySeed.");
        System.out.println("13 - melonSeed.");
        System.out.println("14 - watermelonSeed");
        System.out.println("15 - lemonSeed.");
        System.out.println("16 - strawberriesSe");
        System.out.println("---------------------");
        System.out.println("0 - Return");
        System.out.println("---------------------");

        System.out.println("Select plant:");

        switch (Menu.choiceMenu()) {
            case 0:
                break;
            case 1:
                return cornSeed;
            case 2:
                return carrotSeed;
            case 3:
                return sunflowerSeed;
            case 4:
                return potatoSeed;
            case 5:
                return wheatSeed;
            case 6:
                return broccoliSeed;
            case 7:
                return onionSeed;
            case 8:
                return lettuceSeed;
            case 9:
                return tomatoSeed;
            case 10:
                return appleSeed;
            case 11:
                return pearSeed;
            case 12:
                return cherrySeed;
            case 13:
                return melonSeed;
            case 14:
                return watermelonSeed;
            case 15:
                return lemonSeed;
            case 16:
                return strawberriesSeed;
        }
        return null;
    }

    public static Animal whichAnimal() {

        System.out.println("1 - cow");
        System.out.println("2 - sheep");
        System.out.println("3 - pig");
        System.out.println("4 - chicken");
        System.out.println("5 - cat");
        System.out.println("6 - dog");
        System.out.println("---------------------");
        System.out.println("0 - Return");
        System.out.println("---------------------");

        System.out.println("Select animal:");

        switch (Menu.choiceMenu()) {
            case 1:
                return cow;
            case 2:
                return sheep;
            case 3:
                return pig;
            case 4:
                return chicken;
            case 5:
                return dog;
            case 6:
                return cat;
        }
        return null;
    }

    public static Building whichBuilding() {

        System.out.println("1 - " + smallCowshed.toString());
        System.out.println("2 - " + smallPigsty.toString());
        System.out.println("3 - " + smallStable.toString());
        System.out.println("4 - " + smallChickencoop.toString());
        System.out.println("5 - " + mediumCowshed.toString());
        System.out.println("6 - " + mediumPigsty.toString());
        System.out.println("7 - " + mediumStable.toString());
        System.out.println("8 - " + mediumChickencoop.toString());
        System.out.println("9 - " + bigCowshed.toString());
        System.out.println("10 - " + bigPigsty.toString());
        System.out.println("11 - " + bigStable.toString());
        System.out.println("12 - " + bigChickencoop.toString());
        System.out.println("13 - " + silos.toString());
        System.out.println("---------------------");
        System.out.println("0 - return");
        System.out.println("---------------------");

        System.out.println("Select building:");

        switch (Menu.choiceMenu()) {
            case 1:
                return smallCowshed;
            case 2:
                return smallPigsty;
            case 3:
                return smallStable;
            case 4:
                return smallChickencoop;
            case 5:
                return mediumCowshed;
            case 6:
                return mediumPigsty;
            case 7:
                return mediumStable;
            case 8:
                return mediumChickencoop;
            case 9:
                return bigCowshed;
            case 10:
                return bigPigsty;
            case 11:
                return bigStable;
            case 12:
                return bigChickencoop;
            case 13:
                return silos;
        }
        return null;
    }

    public static Farm whichFarm() {

        System.out.println("1 - " + oldFarm.toString());
        System.out.println("2 - " + startedFarm.toString());
        System.out.println("3 - " + advancedFarm.toString());
        System.out.println("4 - " + highTierFarm.toString());
        System.out.println("5 - " + ultimateFarm.toString());
        System.out.println("---------------------");
        System.out.println("0 - Return");
        System.out.println("---------------------");

        System.out.println("select farm:");

        switch (Menu.choiceMenu()) {
            case 1:
                return oldFarm;
            case 2:
                return startedFarm;
            case 3:
                return advancedFarm;
            case 4:
                return highTierFarm;
            case 5:
                return ultimateFarm;
        }
        return null;
    }
}
