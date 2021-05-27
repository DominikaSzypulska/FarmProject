# Project Name- FarmProject
> "Farm Project" is a program in the form of a text game simulating the work of a farm owner.

## Table of contents
* [General Information](#general-information)
* [Technologies](#technologies)
* [Features](#features)
* [Screenshots](#screenshots)
* [Code Examples](#code-examples)
* [Setup](#setup)
* [Status](#status)
* [Contact](#contact)

## General Information
You start the game by specifying the number of players. You start out with a certain amount of cash (5000 coins). You don't own land, buildings, animals, or crops. 
At the beginning of each game, a new set of farms is available for purchase. Each farm has a different size and number of buildings. 
On the farm you can raise animals, grow plants and build buildings (but first you have to buy them). 
The goal of the game is to achieve the status of a perfect farmer in as few turns as possible, who has at least 20 hectares, 5 different species of farm animals, 5 different types of crops, food for all his animals for year.
Each week is one round. The game starts in week # 1 of 2020. <br>
To achieve the goal, develop your farm: buy buildings and animals, sell crops. Don't forget to take care of pets. 
You have to feed them so that they do not starve to death. Provide them with suitable buildings in which to live.

## Technologies
Project is created with:
- Intellij IDEA version: 2021.1.1
- Java version: 11.0.11


## Features
In each round, you can do any of the following any number of times:
- Purchase of a farm
- Purchase/sale of arable land
- Purchase of new buildings
- Purchase/sale of animals or plants
- Purchase/sale of the field
- Planting plants
- Harvesting plants (if you have a harvest ready)
- Inventory check
- View information about owned animals, buildings
- View information about your seedlings and planted plants

**To Do:**
- Add drought, flood and Colorado beetle (10%) - there is a slight chance that some crops will be destroyed regardless of the player's actions
- Add support for fluctuations in the selling price of agricultural products (10%) - the price can fluctuate randomly, you can sell the crops right after the harvest or store them for a while and wait for a better opportunity.

## Screenshots
Sample screenshots showing the operation of the console game:

Menu view after selecting the number of players:
![Menu](/images/menu.PNG)

Shop view:
![Shop View](/images/shop.PNG)

Buying a farm:
![Buy Farm](/images/farm.PNG)

Statistic of your Farms:
![Statistic of your Farms](/images/statistic.PNG)

Manage your Farms:
![Manage your Farms](/images/manage.PNG)

## Code Examples
The code shows the logic of harvesting the harvest:
```
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
```

## Setup
To start the game, you need to download and install the [Intellij IDE](https://www.jetbrains.com/idea/download/#section=windows) and [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html).
After correct installation, download FarmProject and open it in Intellij. Then start the console game by clicking the "Run" button.

## Status
Project is: *in progress*.

## Contact
Created by [Dominika Szypulska](https://github.com/DominikaSzypulska).
<br>E-mail: dominikaszypulska@onet.pl -feel free to contact me!
