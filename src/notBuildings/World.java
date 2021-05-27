package notBuildings;

import buildings.Farm;
import interfaces.RandomNumberGeneratorInt;

public class World {

    public static void disasters(Player player, int week) {

        if (!player.yourPlantedPlants.isEmpty()) {
            for (int i = 0; i < player.yourPlantedPlants.size(); i++) {
                int flood = RandomNumberGeneratorInt.randomBetween(0, 100);
                int drought = RandomNumberGeneratorInt.randomBetween(0, 100);
                int insects = RandomNumberGeneratorInt.randomBetween(0, 100);

                if (week > 10 && week < 20 && flood == 5) {
                    player.yourPlantedPlants.get(i).efficiency_ha *= 0.7;
                    System.out.println("Flood decrees efficiency of your plants ");
                }
                if (week > 20 && week < 30 && drought == 6) {
                    player.yourPlantedPlants.get(i).timeToGrow += RandomNumberGeneratorInt.randomBetween(10, 15);
                    System.out.println("Drought slow down growing process of your plants");
                }
                if (week > 30 && week < 40 && insects == 3) {
                    player.yourPlantedPlants.get(i).amountInInventory *= 0.5;
                    System.out.println("Insects ate some of your plants");
                }
            }
        }
    }

    public static void isWinner(Player player) {
        if (player.farm.isEmpty()) {
            if (player.farm.get(0).name.equals("ultimateFarm") && player.getCash() >= 1000000.0) {
                System.out.println("Player:" + player.getName() + " win the game!!!");
                System.exit(0);
            }
        }

    }
}
